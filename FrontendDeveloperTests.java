import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.text.Text; 
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Menu;
import edu.wisc.cs.cs400.JavaFXTester;
public class FrontendDeveloperTests extends JavaFXTester{
  //this JavaFXTester class implements the TestFX FXRobot class, do$
  // https://testfx.github.io/TestFX/docs/javadoc/testfx-core/javado$

  public FrontendDeveloperTests() {
    super(FrontendFD.class);
  }
  /*
  * testing that after clicking the start button, the path is displayed 
  */
  @Test
  public void test1() {
    Text path= lookup("#path").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("Shortest path: a-> b-> c-> d", path.getText()); 

  }

  @Test
  public void test2() {
    Text time= lookup("#time").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("total time: 0", time.getText()); 
  }

  @Test
  public void test3() {
    Text path= lookup("#path").query(); // lookup the node by ID
    clickOn("#end"); // simulates mouse clicking
    clickOn("#temp3"); // simulates mouse clicking
    assertEquals("Shortest path: nope", path.getText()); 

  }
  
  @Test 
  public void test4(){
    Text av= lookup("#av").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("direct flight availability: No", av.getText());
  }
  @Test 
  public void test5(){
    Text av= lookup("#av").query(); // lookup the node by ID
    clickOn("#end"); // simulates mouse clicking
    clickOn("#temp3"); // simulates mouse clicking
    assertEquals("direct flight availability: nope", av.getText());
  }
}
