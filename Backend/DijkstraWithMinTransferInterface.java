import java.util.List;

public interface DijkstraWithMinTransferInterface<NodeType,EdgeType extends Number> extends GraphADT<NodeType,EdgeType> {

  // public DijkstraWithMinTransfer();
  public int minTransfer(AirportInterface start, AirportInterface end);
  public List<AirportInterface> findAirportConnections(AirportInterface start);
}

