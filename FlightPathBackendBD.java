import java.util.*;
import java.io.*;  
import java.nio.file.Files;
public class FlightPathBackendBD implements FlightPathBackendInterface{
  private File f= new File("./DWTest2.dot");
  private fileReaderInterface reader;

  private DijkstraGraph<AirportInterface, Integer> graph;
  private  DijkstraWithMinTransfer<AirportInterface, Integer> min= new DijkstraWithMinTransfer<AirportInterface, Integer> ( this.graph);

  public FlightPathBackendBD() throws FileNotFoundException{
    try{
      reader= new FileReaderDW(f);
    }catch(Exception e){
      throw new FileNotFoundException(); 
    };


    for(AirportInterface airport: this.reader.getAirportList()){
      this.graph.insertNode(airport);
    }
    for(EdgeInterface edge: this.reader.getEdgeList()){
      this.graph.insertEdge(edge.getPredecessor(), edge.getSuccessor(), edge.getWeight());
    }

  }

  @Override
  public int arrivalTime(AirportInterface start, AirportInterface end) throws NoSuchElementException{

    return this.min.minTransfer(start, end);

  }
  @Override
  public boolean directFlight(AirportInterface st, AirportInterface end){

    return false;

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
