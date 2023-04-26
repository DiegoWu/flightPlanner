
import java.util.List;

public interface DijkstraWithMinTransferInterface<NodeType,EdgeType extends Number> {

  // public DijkstraWithMinTransfer();
  public int minTransfer(AirportInterface start, AirportInterface end);
  public List<AirportInterface> findAirportConnections(AirportInterface start, AirportInterface end);
}

