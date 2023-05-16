
import javax.swing.GroupLayout.Group;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public interface FrontendInterface {


public void start(final Stage stage); 
  
public Text displayAllShortestPaths();

//public void addStartingPlace(AirportInterface start);  
//public void addDestination(AirportInterface end); 


public Text displayArrivalTime(); 

public Text displayDirectFightAvailable(); 

}

