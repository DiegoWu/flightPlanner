// --== CS400 File Header Information ==00
// Name: Viola Vinatzer
// Email: vinatzer@wisc.edu
// Group and Team: DX red
// Group TA: April Roszkowski
// Lecturuer: Florian Heimerl
// Notes to Grader: None

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Menu;

import edu.wisc.cs.cs400.JavaFXTester;

/**
 * DataWrangler testing class
 */
public class DataWranglerTests extends JavaFXTester {

	/**
	 * Constructor, necessary as 
	 * Frontend tester
	 */
	public DataWranglerTests(){
		super(FrontendFD.class);
	}

	/**
	 * Tests Airport constructor
	 * and getters
	 */
	@Test
	public void test1(){

		try{
			// Constructs Airport
			String name = "Airport1";
			String abr = "a1";
			int size = 55;

			AirportInterface airport = new AirportDW(name,abr,size);

			// Tests getters/constructor
			assertEquals(true,airport.getName().equals("Airport1"));
			assertEquals(true,airport.getAbrName().equals("a1"));
			assertEquals(55,airport.getSize());


		}
		catch(Exception e){
			// Fails if exception was thrown
			assertEquals(0,1);
		}

	}

	/**
	 * Tests Edge consstructor
	 * and getters
	 */
	@Test
	public void test2(){

		try{
			// Constructs Airports to be part of edge
			AirportInterface a1 = new AirportDW("Airport1","a1",55);
			AirportInterface a2 = new AirportDW("Airport2","a2",67);

			// Constructs edge
			EdgeInterface edge = new EdgeDW(a1,a2,5);

			// Tests getters/constructor
			assertEquals(5,edge.getWeight());
			assertEquals(true,edge.getPredecessor().getName().equals("Airport1"));
			assertEquals(true,edge.getSuccessor().getName().equals("Airport2"));
			assertEquals(true,edge.getPredecessor().getAbrName().equals("a1"));
			assertEquals(true,edge.getSuccessor().getAbrName().equals("a2"));
			assertEquals(55,edge.getPredecessor().getSize());
			assertEquals(67,edge.getSuccessor().getSize());


		}
		catch(Exception e){
			// Fails if exception was thrown
			assertEquals(0,1);
		}

	}

	/**
	 * Tests FileReader construct
	 */
	@Test
	public void test3(){

		try{

			// Tests that constructor throws exception for non-existant file
			try{
				File fake = new File("Fake.txt");
				FileReaderDW reader1 = new FileReaderDW(fake);
				// Fails if non-existent file didn't throw exception
				assertEquals(0,1);
			}
			catch(FileNotFoundException e){
				// Passed
			}
			catch(Exception e){
				// Fails if exception other than expected thrown
				assertEquals(0,1);
			}

			// Tests that exception not throw for existent file
			File real = new File("DWTest.dot");
			FileReaderDW reader2 = new FileReaderDW(real);

		}
		catch(Exception e){
			// Fails if unexpected exception thrown
			assertEquals(0,1);
		}
	}

	/**
	 * Tests FileReader's getAirportList
	 */
	@Test
	public void test4(){

		try{
			FileReaderDW reader = new FileReaderDW(new File("DWTest.dot"));
			List<AirportInterface> airportList = reader.getAirportList();

			// Checks size
			assertEquals(3,airportList.size());

			//Checks name, abr, size of airports in list
			
			assertEquals(true,airportList.get(0).getName().equals("airport1"));
			assertEquals(true,airportList.get(1).getName().equals("airport2"));
			assertEquals(true,airportList.get(2).getName().equals("airport3"));

			assertEquals(true,airportList.get(0).getAbrName().equals("a1"));
			assertEquals(true,airportList.get(1).getAbrName().equals("a2"));
			assertEquals(true,airportList.get(2).getAbrName().equals("a3"));

			assertEquals(548,airportList.get(0).getSize());
			assertEquals(200,airportList.get(1).getSize());
			assertEquals(623,airportList.get(2).getSize());


		}
		catch(Exception e){
			// Fails if exception thrown
			assertEquals(0,1);
		}
	}

	/**
	 * Tests FileReader's getEdgeList
	 */
	@Test
	public void test5(){

		try{
			FileReaderDW reader = new FileReaderDW(new File("DWTest.dot"));
			List<EdgeInterface> edgeList = reader.getEdgeList();

			// Checks size
			assertEquals(3,edgeList.size());
                         
			// Checks successor and predecessor by airport abbreviation
			
			assertEquals(true,edgeList.get(0).getPredecessor().getAbrName().equals("a1"));
			assertEquals(true,edgeList.get(0).getSuccessor().getAbrName().equals("a2"));

			assertEquals(true,edgeList.get(1).getPredecessor().getAbrName().equals("a2"));
			assertEquals(true,edgeList.get(1).getSuccessor().getAbrName().equals("a3"));

			assertEquals(true,edgeList.get(2).getPredecessor().getAbrName().equals("a1"));
			assertEquals(true,edgeList.get(2).getSuccessor().getAbrName().equals("a3"));


		}
		catch(Exception e){
			// Fails if exception thrown
			assertEquals(0,1);
		}
	}

	/*
	 * Tests path from a1 to a2
	 * (DWTest2)
	 */
	@Test
	public void Integration1(){
	}

	/*
	 * Tests path from a1 to a4
	 * (DWTest2)
	 */
	@Test
	public void Integration2(){
	}

	/*
	 * Tests initial display
	 */
	@Test
	public void CodeReviewOfFrontendDeveloper1(){
	}

	/*
	 * Tests result when shortest path display
	 * requested
	 */
	@Test
	public void CodeReviewOfFrontendDeveloper2(){
	}

}
