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

public class DijkstraWithMinTransfer<NodeType, EdgeType extends Number> extends DijkstraGraph<AirportInterface, EdgeType>
		implements DijkstraWithMinTransferInterface<AirportInterface, EdgeType> {

	private DijkstraGraph<AirportInterface, EdgeType> graph;

	public DijkstraWithMinTransfer(DijkstraGraph<AirportInterface, EdgeType> graph) {
		this.graph = graph;
	}

	@Override
	public int minTransfer(AirportInterface start, AirportInterface end) {
		if(start.equals(end))
			return 0;
		return graph.shortestPathData(start, end).size();
	}

	@Override
	public List<AirportInterface> findAirportConnections(AirportInterface start, AirportInterface end) {
		List<AirportInterface> list = new ArrayList<>();
		Node startNode = new Node(start);
		for(Edge edge : startNode.edgesLeaving)
			list.add((AirportInterface) edge.successor);
		return list;
	}




}

