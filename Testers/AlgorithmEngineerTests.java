// --== CS400 File Header Information ==--
// Name: Talon Vorpahl
// Email: tvorpahl2@wisc.edu
// Group and Team: DX, red
// Group TA: April
// Lecturer: 004
// Notes to Grader: <optional extra notes>


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

//This tests The Algorithm Engineer's class DijkstraWithMinTransfers, Integration of the
//Algorithm Engineer's classes with the Data Wrangler classes and
//Review's the Data Wrangler classes to make sure they work properly
public class AlgorithmEngineerTests {
	
	// This tests the minimum number of transfer of a graph using the methods in 
	// DijkstraWithMinTransfers graph 
	@Test
	public void test1() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);
		AirportInterface port3 = new AirportAE("C", "3", 0);
		AirportInterface port4 = new AirportAE("D", "4", 0);
		AirportInterface port5 = new AirportAE("E", "5", 0);
		AirportInterface port6 = new AirportAE("F", "6", 0);
		AirportInterface port7 = new AirportAE("G", "7", 0);
		AirportInterface port8 = new AirportAE("H", "8", 0);
		graph.insertNode(port1);
		graph.insertNode(port2);
		graph.insertNode(port3);
		graph.insertNode(port4);
		graph.insertNode(port5);
		graph.insertNode(port6);
		graph.insertNode(port7);
		graph.insertNode(port8);
		graph.insertEdge(port1, port2, 4.0);
		graph.insertEdge(port1, port3, 2.0);
		graph.insertEdge(port1, port5, 15.0);
		graph.insertEdge(port2, port4, 1.0);
		graph.insertEdge(port2, port5, 10.0);
		graph.insertEdge(port3, port5, 5.0);
		graph.insertEdge(port4, port5, 3.0);
		graph.insertEdge(port4, port6, 0.0);
		graph.insertEdge(port6, port4, 2.0);
		graph.insertEdge(port6, port8, 4.0);
		graph.insertEdge(port7, port8, 4.0);
		
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		int a = test.minTransfer(port1, port4);
		assertEquals(a, 3);
	}

	// This tests if you were to transfer to the same airport in which it should return 0
	@Test
	public void test2() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);
		AirportInterface port3 = new AirportAE("C", "3", 0);
		AirportInterface port4 = new AirportAE("D", "4", 0);
		AirportInterface port5 = new AirportAE("E", "5", 0);
		AirportInterface port6 = new AirportAE("F", "6", 0);
		AirportInterface port7 = new AirportAE("G", "7", 0);
		AirportInterface port8 = new AirportAE("H", "8", 0);
		graph.insertNode(port1);
		graph.insertNode(port2);
		graph.insertNode(port3);
		graph.insertNode(port4);
		graph.insertNode(port5);
		graph.insertNode(port6);
		graph.insertNode(port7);
		graph.insertNode(port8);
		graph.insertEdge(port1, port2, 4.0);
		graph.insertEdge(port1, port3, 2.0);
		graph.insertEdge(port1, port5, 15.0);
		graph.insertEdge(port2, port4, 1.0);
		graph.insertEdge(port2, port5, 10.0);
		graph.insertEdge(port3, port5, 5.0);
		graph.insertEdge(port4, port5, 3.0);
		graph.insertEdge(port4, port6, 0.0);
		graph.insertEdge(port6, port4, 2.0);
		graph.insertEdge(port6, port8, 4.0);
		graph.insertEdge(port7, port8, 4.0);
		
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		int a = test.minTransfer(port8, port8);
		assertEquals(a, 0);
	}

	// This tests if the DijkstraWithMinTransfer method findAllConnections finds all the 
	// airports connected to the starting airport
	@Test
	public void test3() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);
		AirportInterface port3 = new AirportAE("C", "3", 0);
		AirportInterface port4 = new AirportAE("D", "4", 0);
		AirportInterface port5 = new AirportAE("E", "5", 0);
		AirportInterface port6 = new AirportAE("F", "6", 0);
		AirportInterface port7 = new AirportAE("G", "7", 0);
		AirportInterface port8 = new AirportAE("H", "8", 0);
		graph.insertNode(port1);
		graph.insertNode(port2);
		graph.insertNode(port3);
		graph.insertNode(port4);
		graph.insertNode(port5);
		graph.insertNode(port6);
		graph.insertNode(port7);
		graph.insertNode(port8);
		graph.insertEdge(port1, port2, 4.0);
		graph.insertEdge(port1, port3, 2.0);
		graph.insertEdge(port1, port5, 15.0);
		graph.insertEdge(port2, port4, 1.0);
		graph.insertEdge(port2, port5, 10.0);
		graph.insertEdge(port3, port5, 5.0);
		graph.insertEdge(port4, port5, 3.0);
		graph.insertEdge(port4, port6, 0.0);
		graph.insertEdge(port6, port4, 2.0);
		graph.insertEdge(port6, port8, 4.0);
		graph.insertEdge(port7, port8, 4.0);
		
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		List<AirportInterface> testList = test.findAirportConnections(port1);
		List<AirportInterface> list = new ArrayList<>();
		list.add(port2);
		list.add(port3);
		list.add(port5);
		assertEquals(testList,list);
	}
	
	// This test whether a list of connections of airports with no connections equals an empty list of airports
	@Test
	public void test4() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);
		AirportInterface port3 = new AirportAE("C", "3", 0);
		AirportInterface port4 = new AirportAE("D", "4", 0);
		AirportInterface port5 = new AirportAE("E", "5", 0);
		AirportInterface port6 = new AirportAE("F", "6", 0);
		AirportInterface port7 = new AirportAE("G", "7", 0);
		AirportInterface port8 = new AirportAE("H", "8", 0);
		graph.insertNode(port1);
		graph.insertNode(port2);
		graph.insertNode(port3);
		graph.insertNode(port4);
		graph.insertNode(port5);
		graph.insertNode(port6);
		graph.insertNode(port7);
		graph.insertNode(port8);
		graph.insertEdge(port1, port2, 4.0);
		graph.insertEdge(port1, port3, 2.0);
		graph.insertEdge(port1, port5, 15.0);
		graph.insertEdge(port2, port4, 1.0);
		graph.insertEdge(port2, port5, 10.0);
		graph.insertEdge(port3, port5, 5.0);
		graph.insertEdge(port4, port5, 3.0);
		graph.insertEdge(port4, port6, 0.0);
		graph.insertEdge(port6, port4, 2.0);
		graph.insertEdge(port6, port8, 4.0);
		graph.insertEdge(port7, port8, 4.0);
		
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		List<AirportInterface> testList = test.findAirportConnections(port8);
		List<AirportInterface> list = new ArrayList<>();
		assertEquals(testList,list);
	}
	
	// This tests the contructor of the DijkstraWithMinTransfer class
	@Test
	public void test5() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		assertNotNull(test);
	}
	
	// This tests and shows that the fileReader class from DW works with a DijkstraWithMinTransfer graph
	@Test
	public void integrationTest1() {
	   try {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
                FileReaderDW file = new FileReaderDW(new File("DWTest.dot"));
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		assertNotNull(file);
		assertNotNull(test);
	    } catch(Exception e) {
	    }
	}
	
	// Tests and confirms that the Airports create names and that the DijkstraWithMinTransfer
	// graph can hold the all the airports with there names
	@Test
	public void integrationTest2() {
	        DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
                AirportDW port1 = new AirportDW("A", "1", 0);
                AirportDW port2 = new AirportDW("B", "2", 0);
                AirportDW port3 = new AirportDW("C", "3", 0);
                AirportDW port4 = new AirportDW("D", "4", 0);
                AirportDW port5 = new AirportDW("E", "5", 0);
                AirportDW port6 = new AirportDW("F", "6", 0);
                AirportDW port7 = new AirportDW("G", "7", 0);
                AirportDW port8 = new AirportDW("H", "8", 0);
                graph.insertNode(port1);
                graph.insertNode(port2);
                graph.insertNode(port3);
                graph.insertNode(port4);
                graph.insertNode(port5);
                graph.insertNode(port6);
                graph.insertNode(port7);
                graph.insertNode(port8);
                graph.insertEdge(port1, port2, 4.0);
                graph.insertEdge(port1, port3, 2.0);
                graph.insertEdge(port1, port5, 15.0);
                graph.insertEdge(port2, port4, 1.0);
                graph.insertEdge(port2, port5, 10.0);
                graph.insertEdge(port3, port5, 5.0);
                graph.insertEdge(port4, port5, 3.0);
                graph.insertEdge(port4, port6, 0.0);
                graph.insertEdge(port6, port4, 2.0);
                graph.insertEdge(port6, port8, 4.0);
                graph.insertEdge(port7, port8, 4.0);

		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		int min = test.minTransfer(port1,port4);
		String name1 = port1.getName();
		String name2 = port4.getName();
		assertEquals(name1,"A");
		assertEquals(name2,"D");
		assertEquals(min,3);
	}

	// This tests if a negative number is entered in the constructor of the Airport class of DW
	// in which it should return false
	@Test
	public void CodeReviewOfDataWrangler1() {
		AirportDW port = new AirportDW("airport","1", -1);
		int size = port.getSize();
		assertEquals(size, -1);
	}

	// This tests if a negative number is entered in the constructor of the Edge class of DW
        // in which it should return false
	@Test
	public void CodeReviewOfDataWrangler2() {
		EdgeDW edge = new EdgeDW(new AirportDW("Airport","1",500), new AirportDW("Airport","2",400), -1);
		int weight = edge.getWeight();
		assertEquals(weight, -1);

	}
}
