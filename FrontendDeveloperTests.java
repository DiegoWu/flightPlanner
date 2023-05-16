// --== CS400 Project Three File Header ==--
// Name: Diego Wu
// CSL Username: ti
// Email: twu353@wisc.edu
// Lecture #: 4 3:30-4:20
// Team: DX red
// Notes to Grader: did my best 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javafx.scene.text.Text; 
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Menu;
import java.util.*;


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
  /*
   *
   * testing that after clicking the start button, the time is displayed 
   */
  @Test
  public void test2() {
    Text time= lookup("#time").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("total time: 0", time.getText()); 
  }
  /*
   *
   * testing that after clicking the end button on a nonexist path, the path is displayed as nope 
   */
  @Test
  public void test3() {
    Text path= lookup("#path").query(); // lookup the node by ID
    clickOn("#end"); // simulates mouse clicking
    clickOn("#temp3"); // simulates mouse clicking
    assertEquals("Shortest path: nope", path.getText()); 

  }
  /*
   * testing that after clicking the start button, the availability is displayed
   * 
   */
  @Test 
  public void test4(){
    Text av= lookup("#av").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("direct flight availability: No", av.getText());
  }
  /*
   * testing that after clicking the end button on a nonexist path, the availability is displayed as nope
   * 
   */
  @Test 
  public void test5(){
    Text av= lookup("#av").query(); // lookup the node by ID
    clickOn("#end"); // simulates mouse clicking
    clickOn("#temp3"); // simulates mouse clicking
    assertEquals("direct flight availability: nope", av.getText());
  }
  /*
   * :
   * testing AlgorithmEngineer's minTransfer function
   *
   */
  @Test
  public void CodeReviewofAlgorithmEngineer1(){

    DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
    AirportInterface port1 = new AirportDW("A", "1", 0);
    AirportInterface port2 = new AirportDW("B", "2", 0);
    AirportInterface port3 = new AirportDW("C", "3", 0);
    AirportInterface port4 = new AirportDW("D", "4", 0);
    AirportInterface port5 = new AirportDW("E", "5", 0);
    AirportInterface port6 = new AirportDW("F", "6", 0);
    AirportInterface port7 = new AirportDW("G", "7", 0);
    AirportInterface port8 = new AirportDW("H", "8", 0);
    graph.insertNode(port1);
    graph.insertNode(port2);
    graph.insertNode(port3);
    graph.insertNode(port4);
    graph.insertNode(port5);
    graph.insertNode(port6);
    graph.insertNode(port7);
    graph.insertNode(port8);
    graph.insertEdge(port1, port2, 4.0);
    graph.insertEdge(port2, port1, 4.0);
    graph.insertEdge(port3, port1, 2.0);
    graph.insertEdge(port1, port3, 2.0);
    graph.insertEdge(port1, port5, 15.0);
    graph.insertEdge(port5, port1, 15.0);
    graph.insertEdge(port2, port4, 1.0);
    graph.insertEdge(port4, port2, 1.0);
    graph.insertEdge(port2, port5, 10.0);
    graph.insertEdge(port5, port2, 10.0);
    graph.insertEdge(port3, port5, 5.0);
    graph.insertEdge(port5, port3, 5.0);
    graph.insertEdge(port4, port5, 3.0);
    graph.insertEdge(port5, port4, 3.0);
    graph.insertEdge(port4, port6, 0.0);
    graph.insertEdge(port6, port4, 0.0);
    graph.insertEdge(port6, port8, 4.0);
    graph.insertEdge(port8, port6, 4.0);
    graph.insertEdge(port7, port8, 4.0);
    graph.insertEdge(port8, port7, 4.0);

    DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
    int min = test.minTransfer(port7,port1);
    assertEquals(min, 6);
  }
  /*
   * testing algorithmEngineer's findAirportConnections function
   *
   */
  @Test
  public void CodeReviewofAlgorithmEngineer2(){
    
    DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
    AirportInterface port1 = new AirportDW("A", "1", 0);
    AirportInterface port2 = new AirportDW("B", "2", 0);
    AirportInterface port3 = new AirportDW("C", "3", 0);
    AirportInterface port4 = new AirportDW("D", "4", 0);
    AirportInterface port5 = new AirportDW("E", "5", 0);
    AirportInterface port6 = new AirportDW("F", "6", 0);
    AirportInterface port8 = new AirportDW("H", "8", 0);
    graph.insertNode(port1);
    graph.insertNode(port2);
    graph.insertNode(port3);
    graph.insertNode(port4);
    graph.insertNode(port5);
    graph.insertNode(port6);
    graph.insertNode(port8);
    graph.insertEdge(port1, port2, 4.0);
    graph.insertEdge(port2, port1, 4.0);
    graph.insertEdge(port3, port1, 2.0);
    graph.insertEdge(port1, port3, 2.0);
    graph.insertEdge(port1, port5, 15.0);
    graph.insertEdge(port5, port1, 15.0);
    graph.insertEdge(port2, port4, 1.0);
    graph.insertEdge(port4, port2, 1.0);
    graph.insertEdge(port2, port5, 10.0);
    graph.insertEdge(port5, port2, 10.0);
    graph.insertEdge(port3, port5, 5.0);
    graph.insertEdge(port5, port3, 5.0);
    graph.insertEdge(port4, port5, 3.0);
    graph.insertEdge(port5, port4, 3.0);
    graph.insertEdge(port4, port6, 0.0);
    graph.insertEdge(port6, port4, 0.0);
    graph.insertEdge(port6, port8, 4.0);
    graph.insertEdge(port8, port6, 4.0);
    DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
    List<AirportInterface> list = test.findAirportConnections(port5);
    
    assertEquals(list.size(), 4);
    // as our great algorithm engineer changed, the list should only includes the nodes that is connected to the leaving edges of the starting nodes

  }
  /*
   * testing integration between frontend and dataWrangler
   * frontend already makes use of dataWrangler's functions such as AirportDW
   */
  @Test
  public void integrationTest1(){
   Text av= lookup("#av").query(); // lookup the node by ID
    clickOn("#end"); // simulates mouse clicking
    clickOn("#temp3"); // simulates mouse clicking
    assertEquals("direct flight availability: nope", av.getText());
  
  }
  /*
   * testing integration between frontend and dataWrangler by clicking another button
   */
  @Test 
  public void integrationTest2(){
    Text av= lookup("#path").query(); // lookup the node by ID
    clickOn("#start"); // simulates mouse clicking
    clickOn("#temp"); // simulates mouse clicking
    assertEquals("Shortest path: a-> b-> c-> d", av.getText());
  }
}
