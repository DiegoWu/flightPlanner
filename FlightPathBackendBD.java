import java.util.*;
import java.io.*;  
import java.nio.file.Files;
public class FlightPathBackendBD implements FlightPathBackendInterface{
  //private File f= new File("DWTest2.dot");
  private CSVReader reader;

  private DijkstraGraph<AirportInterface, Integer> graph= new DijkstraGraph<AirportInterface, Integer>() ;

  private  DijkstraWithMinTransfer<AirportInterface, Integer> min;

  public FlightPathBackendBD() {
    try{
      reader= new CSVReader();

    }catch(Exception e){
    }
    for(AirportInterface airport: this.reader.getAirportList()){
      this.graph.insertNode(airport);
    }
    for(EdgeInterface edge: this.reader.getEdgeList()){
      this.graph.insertEdge(edge.getPredecessor(), edge.getSuccessor(), edge.getWeight());
    }
    min= new DijkstraWithMinTransfer<AirportInterface, Integer> ( this.graph);
  }
  @Override
  public int arrivalTime(AirportInterface st, AirportInterface end) throws NoSuchElementException{

    return this.min.minTransfer(st, end);

  }
  @Override
  public boolean directFlight(AirportInterface st, AirportInterface end){
    return this.min.minTransfer(st, end)<=2? true: false;
  }
  @Override
  public List<AirportInterface> shortestPaths(AirportInterface st, AirportInterface end){

    return this.min.shortestPathData(st, end); 
  }

  @Override
  public List<AirportInterface> getAllAirports(){
    return this.reader.getAirportList();
  }
  @Override
  public void LoadMap(String filename) throws FileNotFoundException{
  }
}
