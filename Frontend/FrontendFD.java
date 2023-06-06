// --== CS400 Project Three File Header ==--
// Name: Diego Wu
// CSL Username: ti
// Email: twu353@wisc.edu
// Lecture #: 4 3:30-4:20
// Team: DX red
// Notes to Grader: Orz
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.Group;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import java.util.List;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.StackPane;


public class FrontendFD extends Application implements FrontendInterface {


  private String mode= "dark mode";
  // private helper method for print
  private static <T> void print(T x) {
    System.out.println(x);
  }
  private static final String LIGHT_MODE = "light";
  private static final String DARK_MODE = "dark";
  private BorderPane borderPane = new BorderPane();

  private String currentMode = LIGHT_MODE;
  private FlightPathBackendInterface backend=  new FlightPathBackendBD();
  private ToggleButton darkModeButton = new ToggleButton(mode);
  private AirportInterface st;

  private AirportInterface end;

  private void setDarkMode() {
    if (!currentMode.equals(DARK_MODE)) {
      currentMode = DARK_MODE;
      mode= "light mode";
      darkModeButton.setText(mode);
      Scene scene = borderPane.getScene();
      scene.getStylesheets().clear();
      scene.getStylesheets().add(getClass().getResource("./CSS/style-dark.css").toExternalForm());
    }
  }

  private void setLightMode() {
    if (!currentMode.equals(LIGHT_MODE)) {
      currentMode = LIGHT_MODE;
      mode= "dark mode";
      darkModeButton.setText(mode);
      Scene scene = borderPane.getScene();
      scene.getStylesheets().clear();
      scene.getStylesheets().add(getClass().getResource("./CSS/style.css").toExternalForm());
    }
  }
  public Text displayAllShortestPaths() {

    StringBuilder sb = new StringBuilder();
    Text pathsText;
    try {

      List<AirportInterface> paths = this.backend.shortestPaths(this.st, this.end);
      for (AirportInterface airport : paths) {

        sb.append(airport.getName()).append(" (").append(airport.getAbrName()).append(") -> ");
      }
      sb.delete(sb.length() - 4, sb.length());
      sb.append("\n");
      pathsText = new Text(sb.toString());
    } catch (Exception e) {
      pathsText = new Text("DNE");
    }

    pathsText.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
    pathsText.setFill(Color.BLACK);

    return pathsText;
  }

  @Override
  public Text displayArrivalTime() {
    Text text;
    String t = "The path DNE";
    try {
      int temp = backend.arrivalTime(this.st, this.end);
      t = Integer.toString(temp);
      text = new Text(t);

    } catch (Exception e) {
      text = new Text(t);
    }
    return text;
  }

  private List<AirportInterface> getList() {
    List<AirportInterface> temp = this.backend.getAllAirports();

    return temp;
  }

  @Override
  public Text displayDirectFightAvailable() {
    Text text;
    String t = "the path DNE";
    try {
      boolean ck = backend.directFlight(this.st, this.end);
      t = ck ? "Yes" : "No";
      text = new Text(t);
    } catch (Exception e) {
      text = new Text(t);
    }
    return text;
  }



  @Override
  public void start(final Stage stage) {

    // Retrieve the dimensions of the screen
    javafx.geometry.Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();


    // Calculate the size of the window as 50% of the screen size
    double windowWidth = screenBounds.getWidth()*0.5;
    double windowHeight = screenBounds.getHeight() * 0.5;

    MenuButton start = new MenuButton("From: ");
    MenuButton end = new MenuButton("To: ");

    List<AirportInterface> list = this.getList();
    Text path = new Text();
    Text time= new Text(); 
    Text av= new Text(); 

    Button exitButton = new Button("Exit");
    exitButton.setOnAction(e -> {
      Platform.exit();
    });

    try {
      for (AirportInterface x : list) {
        MenuItem temp = new MenuItem(x.getName()+ " ("+x.getAbrName()+")");
        MenuItem temp1 = new MenuItem(x.getName()+ " ("+x.getAbrName()+")");

        temp.setOnAction(e -> {
          start.setText(temp.getText());
          this.st = x;
          path.setText("Shortest path: "+ displayAllShortestPaths().getText());
          time.setText("total stops: "+ displayArrivalTime().getText());  
          av.setText("direct flight availability: "+displayDirectFightAvailable().getText()); 

        });
        temp1.setOnAction(e -> {
          end.setText(temp1.getText());
          this.end = x;
          path.setText("Shortest path: "+ displayAllShortestPaths().getText());
          time.setText("total stops: "+ displayArrivalTime().getText());  
          av.setText("direct flight availability: "+displayDirectFightAvailable().getText()); 

        });

        start.getItems().add(temp);
        end.getItems().add(temp1);

      }

    } catch (Exception e) {

      // placeholder

      MenuItem temp = new MenuItem("Airport 1");

      MenuItem temp1 = new MenuItem("Airport 2");
      MenuItem temp2 = new MenuItem("Airport 1");
      MenuItem temp3 = new MenuItem("Airport 2");

      temp.setOnAction(ee -> {
        start.setText(temp.getText());

        path.setText("Shortest path: "+ displayAllShortestPaths().getText());
        time.setText("total time: "+ displayArrivalTime().getText());  
        av.setText("direct flight availability: "+displayDirectFightAvailable().getText()); 
        AirportInterface ai = new AirportDW("airport1", "ai1", 100);
        this.st = ai;

      });

      temp1.setOnAction(ee -> {
        start.setText(temp1.getText());

        path.setText("Shortest path: "+ displayAllShortestPaths().getText());
        time.setText("total time: "+ displayArrivalTime().getText()); 
        av.setText("direct flight availability: "+displayDirectFightAvailable().getText()); 

        AirportInterface ai = new AirportDW("airport2", "ai2", 100);
        this.st = ai;

      });

      temp2.setOnAction(ee -> {
        end.setText(temp2.getText());

        path.setText("Shortest path: "+ displayAllShortestPaths().getText());
        time.setText("total time: "+ displayArrivalTime().getText());  
        av.setText("direct flight availability: "+displayDirectFightAvailable().getText()); 

        AirportInterface ai = new AirportDW("airport1", "ai1", 100);
        this.end = ai;

      });

      temp3.setOnAction(ee -> {
        end.setText(temp3.getText());

        AirportInterface ai = new AirportDW("airport2", "ai2", 100);
        this.end = ai;

        path.setText("Shortest path: "+ "nope");
        time.setText("total time: "+ "nope");  
        av.setText("direct flight availability: "+"nope"); 

      });
      temp.setId("temp");
      temp3.setId("temp3");
      start.getItems().addAll(temp, temp1);
      end.getItems().addAll(temp2, temp3);

    }

    path.setFont(new Font(30));
    path.setFill(Color.BROWN); 
    time.setFont(new Font(20));
    time.setFill(Color.BROWN); 
    av.setFont(new Font(20));
    av.setFill(Color.BROWN); 
    StackPane buttonPane = new StackPane();

    darkModeButton.setOnAction(e -> {
      if (darkModeButton.isSelected()) {
        setDarkMode();
      } else {
        setLightMode();
      }
    });

    HBox hbox = new HBox(start, end);
    HBox darkModeButtonPane = new HBox(darkModeButton);
    HBox topContainer = new HBox(hbox, darkModeButtonPane);
    topContainer.setSpacing(10);

    //buttonPane.getChildren().addAll(hbox);
    StackPane pane = new StackPane(path); 
    StackPane pane1 = new StackPane(time);
    StackPane pane2 = new StackPane(av);
    VBox vbox= new VBox(exitButton); 
    VBox vbox1= new VBox(pane, pane1, pane2); 
    pane.setPadding(new Insets(30, 20, 20, 30)); // sets 10px top, 20px right, 30px bottom, 40px left insets
    pane1.setPadding(new Insets(35, 20, 20, 30)); // sets 10px top, 20px right, 30px bottom, 40px left insets
    pane2.setPadding(new Insets(40, 20, 20, 30)); // sets 10px top, 20px right, 30px bottom, 40px left insets

    borderPane.setTop(topContainer);    
    borderPane.setCenter(vbox1);
    borderPane.setBottom(vbox);
    Scene scene = new Scene(borderPane, windowWidth, windowHeight, Color.BEIGE);
    stage.setTitle("FlightPathDemo");
    scene.getStylesheets().add(getClass().getResource("./CSS/style.css").toExternalForm());
    stage.setScene(scene);

    stage.show();
    start.setId("start");
    end.setId("end");
    exitButton.setId("exit");
    borderPane.setId("pane");
    path.setId("path");
    time.setId("time");
    av.setId("av"); 
  }

  public static void main(String[] args) {
    Application.launch();
  }
}
