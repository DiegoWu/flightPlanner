import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;

public class FileReader implements fileReaderInterface{

	ArrayList<AirportInterface> airportList = new ArrayList<AirportInterface>();
	ArrayList<EdgeInterface> edgeList = new ArrayList<EdgeInterface>();

	public FileReader(File file) throws FileNotFoundException {

		Scanner scan = new Scanner(file);

		// Stores lines representing edges for later iteration
		ArrayList<String> edgeStringList = new ArrayList<String>();

		// Fills airportList
		while(scan.hasNextLine()){

			// Gets nextLine
			String nextLine = scan.nextLine();

			// Stores edge line
			if(nextLine.contains("--")){
				edgeStringList.add(nextLine);
			}


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
				airportList.add(new Airport(name,abbreviation,size));
				

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
			edgeList.add(new Edge(predAirport,sucAirport,edgeWeight));

		}

		


	}

	@Override
	public List<AirportInterface> getAirportList(){
		return airportList;
	}

	@Override
	public List<EdgeInterface> getEdgeList(){
		return edgeList;
	}

}
