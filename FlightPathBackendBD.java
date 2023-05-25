public class FlightPathBackendBD{

  private fileReaderInterface reader= fileReaderDW("DWTest2.dot");
  private DijstraGraph<AirportInterface, EdgeInterface> graph;
  for(AirportInterface airport: reader.getAirportList()){
    graph.insertNode(airport);
  }
  for(EdgeInterface edge: reader.getEdgeList()){
    graph.insertEdge(edge.getPredecessor(), edge.getSuccessor(), edge.getWeight());
  }
  private  DijkstraWithMinTransfer<AirportInterface, EdgeInterface>() min= new DijkstraWithMinTransfer<AirportInterface, EdgeInterface> (this.graph);

  public int arrivalTime(AirportInterface start, AirportInterface end, int time){
    
    return min.minTransfer(start, end);

  }
  public boolean directFlight(AirportInterface st, AirportInteface end){

    return null;

  }
  public List<AirportInterface> shortestPath(AirportInterface st, AirportInterface end){

    return min.shortestPathData(st, end); 
  }
}
