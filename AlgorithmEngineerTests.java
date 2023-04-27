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

public class AlgorithmEngineerTests {
	
	@Test
	public void test1() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);;
		AirportInterface port3 = new AirportAE("C", "3", 0);;
		AirportInterface port4 = new AirportAE("D", "4", 0);;
		AirportInterface port5 = new AirportAE("E", "5", 0);;
		AirportInterface port6 = new AirportAE("F", "6", 0);; 
		AirportInterface port7 = new AirportAE("G", "7", 0);;
		AirportInterface port8 = new AirportAE("H", "8", 0);;
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
	
	@Test
	public void test2() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);;
		AirportInterface port3 = new AirportAE("C", "3", 0);;
		AirportInterface port4 = new AirportAE("D", "4", 0);;
		AirportInterface port5 = new AirportAE("E", "5", 0);;
		AirportInterface port6 = new AirportAE("F", "6", 0);; 
		AirportInterface port7 = new AirportAE("G", "7", 0);;
		AirportInterface port8 = new AirportAE("H", "8", 0);;
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
	
	@Test
	public void test3() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);;
		AirportInterface port3 = new AirportAE("C", "3", 0);;
		AirportInterface port4 = new AirportAE("D", "4", 0);;
		AirportInterface port5 = new AirportAE("E", "5", 0);;
		AirportInterface port6 = new AirportAE("F", "6", 0);; 
		AirportInterface port7 = new AirportAE("G", "7", 0);;
		AirportInterface port8 = new AirportAE("H", "8", 0);;
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
		List<AirportInterface> testList = test.findAirportConnections(port1, port8);
		List<AirportInterface> list = new ArrayList<>();
		list.add(port2);
		list.add(port3);
		list.add(port5);
		assertNotNull(testList);
	}
	
	@Test
	public void test4() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		AirportInterface port1 = new AirportAE("A", "1", 0);
		AirportInterface port2 = new AirportAE("B", "2", 0);;
		AirportInterface port3 = new AirportAE("C", "3", 0);;
		AirportInterface port4 = new AirportAE("D", "4", 0);;
		AirportInterface port5 = new AirportAE("E", "5", 0);;
		AirportInterface port6 = new AirportAE("F", "6", 0);; 
		AirportInterface port7 = new AirportAE("G", "7", 0);;
		AirportInterface port8 = new AirportAE("H", "8", 0);;
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
		List<AirportInterface> testList = test.findAirportConnections(port8, port8);
		List<AirportInterface> list = new ArrayList<>();
		assertEquals(testList,list);
	}
	
	@Test
	public void test5() {
		DijkstraGraph<AirportInterface, Double> graph = new DijkstraGraph<AirportInterface, Double>();
		DijkstraWithMinTransfer<AirportInterface, Double> test = new DijkstraWithMinTransfer<AirportInterface, Double>(graph);
		assertNotNull(test);
	}
	
}
