public class FlightPathBackendBD{
  private DijstraGraph<AirportInterface, Double> graph;
  private  DijkstraWithMinTransfer<AirportInterface, Double>() min= new DijkstraWithMinTransfer<AirportInterface, Double> (this.graph);

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
