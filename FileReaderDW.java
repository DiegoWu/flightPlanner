// --== CS400 Project Three File Header ==--
// Name: Viola Vinatzer
// CSL Username: viola
// Email: vinatzer@wisc.edu
// Lecture #: Lecture 4 MWF 3:30pm - 4:20pm
// Notes to Grader: None
// TA: April Roszkowski

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * Class to read dot files representing airport connections
 */
public class FileReaderDW implements fileReaderInterface{

  // List of airport 'nodes'
  ArrayList<AirportInterface> airportList = new ArrayList<AirportInterface>();
  // List of edges in graph
  ArrayList<EdgeInterface> edgeList = new ArrayList<EdgeInterface>();

  /**
   * Constructor
   *
   * @param file - dot File representing graph of airport connections
   */
  public FileReaderDW(File file) {
    try{
      Scanner scan = new Scanner(file);

      // Stores lines representing edges for later iteration
      ArrayList<String> edgeStringList = new ArrayList<String>();

      // Fills airportList
      while(scan.hasNextLine()){

        // Gets nextLine
        String nextLine = scan.nextLine();

        // Stores edge line
        if(nextLine.contains("--"))
          edgeStringList.add(nextLine);


        // Adds node (Airplane)
        if(nextLine.contains("abbreviation")){

          // Gets abbreviation
          int abbIndex = nextLine.indexOf("abbreviation=");
          String abbreviation = nextLine.substring(abbIndex);
          abbreviation = abbreviation.substring(abbreviation.indexOf("\"") + 1);
          abbreviation = abbreviation.substring(0, abbreviation.indexOf("\""));

          // Gets name
          String name = nextLine.substring(0, nextLine.indexOf(" "));
          name = name.trim();

          // Gets size
          int sizeIndex = nextLine.indexOf("size=");
          String sizeS = nextLine.substring(sizeIndex);
          sizeS = sizeS.substring(sizeS.indexOf("=") + 1);
          sizeS = sizeS.substring(0, sizeS.indexOf(" "));
          int size = Integer.parseInt(sizeS);

          // Adds airport to list
          airportList.add(new AirportDW(name,abbreviation,size));


        }
      }


    // Adds edges
    for(int i = 0; i < edgeStringList.size(); ++i){

      // Get line
      String line = edgeStringList.get(i);

      // Get predecessor
      String predecessor = line.substring(0,line.indexOf("-"));
      predecessor = predecessor.trim();	

      // Get successor
      String successor = line.substring(line.indexOf("-") + 3, line.indexOf("[") - 1);

      // Get edgeWeight
      int distanceIndex = line.indexOf("distance=");
      String distanceS = line.substring(distanceIndex);
      distanceS = distanceS.substring(distanceS.indexOf("=") + 1);
      distanceS = distanceS.substring(0, distanceS.indexOf("]"));
      int edgeWeight = Integer.parseInt(distanceS);


      // Find airports based on name
      AirportInterface predAirport = null;
      AirportInterface sucAirport = null;

      for(int j = 0; j < airportList.size(); ++j){

        if(airportList.get(j).getName().equals(predecessor)){
          predAirport = airportList.get(j);
        }
        if(airportList.get(j).getName().equals(successor)){
          sucAirport = airportList.get(j);
        }

      }

      // Add edge
      edgeList.add(new EdgeDW(predAirport,sucAirport,edgeWeight));

    }
  }catch(FileNotFoundException e){
    System.out.println("File not found");
  };



}

/**
 * Returns list of airport 'nodes'
 *
 * @return airportList - list of airport 'nodes'
 */
@Override
public List<AirportInterface> getAirportList(){
  return airportList;
}

/**
 * Returns list of connecting edges
 *
 * @return edgeList - list of edges in graph
 */
@Override
public List<EdgeInterface> getEdgeList(){
  return edgeList;
}

}
