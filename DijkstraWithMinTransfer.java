// --== CS400 File Header Information ==--
// Name: Talon Vorpahl
// Email: tvorpahl2@wisc.edu
// Group and Team: DX, red
// Group TA: April
// Lecturer: 004
// Notes to Grader: <optional extra notes>

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// This is a class that extends the Dijkstra Graph class and
//adds two extra methods to it, minTransfer and findAirportConnections
public class DijkstraWithMinTransfer<NodeType, EdgeType extends Number> extends DijkstraGraph<AirportInterface, EdgeType>
  implements DijkstraWithMinTransferInterface<AirportInterface, EdgeType> {

  private DijkstraGraph<AirportInterface, EdgeType> graph; // graph used

  public DijkstraWithMinTransfer(DijkstraGraph<AirportInterface, EdgeType> graph) {
    this.graph = graph;// obtains graph
  }

  @Override
  public int minTransfer(AirportInterface start, AirportInterface end) {
    if(start.equals(end)) // if theres no path
      return 0;
    return graph.shortestPathData(start, end).size(); // the miniumum transfers
  }
  public List<AirportInterface> shortestPathData(AirportInterface start, AirportInterface end) {
    return graph.shortestPathData(start, end);
  }
  @Override
  public List<AirportInterface> findAirportConnections(AirportInterface start) {
    List<AirportInterface> list = new ArrayList<>(); // A list
    for(Edge edge : graph.nodes.get(start).edgesLeaving) // finds all nodes connected to the start
      list.add(edge.successor.data);
    return list; // A list
  }

}

