import java.util.List;

public interface DijkstraWithMinTransferInterface<NodeType,EdgeType extends Number> extends GraphADT<NodeType,EdgeType> {

	// public DijkstraWithMinTransfer();
	public int minTransfer(NodeType start, NodeType end);
	public List<NodeType> findAirportConnections(NodeType start, NodeType end);

}
