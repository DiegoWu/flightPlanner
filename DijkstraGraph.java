
// --== CS400 File Header Information ==--
// Name: Talon Vorpahl
// Email: tvorpahl2@wisc.edu
// Group and Team: DX, red
// Group TA: April
// Lecturer: 004
// Notes to Grader: <optional extra notes>

import java.util.PriorityQueue;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes. This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number> extends BaseGraph<NodeType, EdgeType>
		implements GraphADT<NodeType, EdgeType> {

	/**
	 * While searching for the shortest path between two nodes, a SearchNode
	 * contains data about one specific path between the start node and another node
	 * in the graph. The final node in this path is stored in it's node field. The
	 * total cost of this path is stored in its cost field. And the predecessor
	 * SearchNode within this path is referened by the predecessor field (this field
	 * is null within the SearchNode containing the starting node in it's node
	 * field).
	 *
	 * SearchNodes are Comparable and are sorted by cost so that the lowest cost
	 * SearchNode has the highest priority within a java.util.PriorityQueue.
	 */
	protected class SearchNode implements Comparable<SearchNode> {
		public Node node;
		public double cost;
		public SearchNode predecessor;

		public SearchNode(Node node, double cost, SearchNode predecessor) {
			this.node = node;
			this.cost = cost;
			this.predecessor = predecessor;
		}

		public int compareTo(SearchNode other) {
			if (cost > other.cost)
				return +1;
			if (cost < other.cost)
				return -1;
			return 0;
		}
	}

	/**
	 * This helper method creates a network of SearchNodes while computing the
	 * shortest path between the provided start and end locations. The SearchNode
	 * that is returned by this method is represents the end of the shortest path
	 * that is found: it's cost is the cost of that shortest path, and the nodes
	 * linked together through predecessor references represent all of the nodes
	 * along that shortest path (ordered from end to start).
	 *
	 * @param start the data item in the starting node for the path
	 * @param end   the data item in the destination node for the path
	 * @return SearchNode for the final end node within the shortest path
	 * @throws NoSuchElementException when no path from start to end is found or
	 *                                when either start or end data do not
	 *                                correspond to a graph node
	 */
	protected SearchNode computeShortestPath(NodeType start, NodeType end) throws NoSuchElementException {
		// Checks if the start and end are Nodes in the tree
		if (!containsNode(start) || !containsNode(end))
			throw new NoSuchElementException("No start No end");

		// Create a Hashtable to keep track of visited nodes and their corresponding
		// SearchNodes
		Hashtable<Node, SearchNode> visited = new Hashtable<>();

		// Create a priority queue to store SearchNodes with the smallest cost at the
		// top
		PriorityQueue<SearchNode> queue = new PriorityQueue<>();

		// Create a SearchNode for the start node and add it to the queue
		SearchNode startNode = new SearchNode(nodes.get(start), 0, null);
		queue.add(startNode);

		// While there are SearchNodes in the queue, continue searching for the shortest
		// path
		while (!queue.isEmpty()) {
			// Get the SearchNode with the smallest cost
			SearchNode curSearch = queue.poll();
			Node curNode = curSearch.node;
			double curCost = curSearch.cost;
			// Get the edges leaving the current node
			List<Edge> sucEdges = new LinkedList<>(curNode.edgesLeaving);

			// For each successor edge, create a new SearchNode and add it to the queue if
			// necessary
			while (!sucEdges.isEmpty()) {
				// Get the edge with the smallest cost
				Edge nextEdge = minHelper(sucEdges);

				// Create a new SearchNode for the successor node
				SearchNode nextSearch = new SearchNode(nextEdge.successor, curCost + nextEdge.data.doubleValue(),
						curSearch);
				Node nextNode = nextSearch.node;
				// If the successor node has already been visited, update the corresponding
				// SearchNode if the new SearchNode has a smaller cost
				if (visited.containsKey(nextNode)) {
					if (nextSearch.compareTo(visited.get(nextNode)) < 0)
						visited.replace(nextNode, nextSearch);
				} else // Otherwise, add the new SearchNode to the queue
					queue.add(nextSearch);
			}

			// If the current node has already been visited, update the corresponding
			// SearchNode if the new SearchNode has a smaller cost
			if (visited.containsKey(curNode)) {
				if (visited.get(curNode).compareTo(curSearch) > 0)
					visited.replace(curNode, curSearch);
			} else // Otherwise, add the new SearchNode to the visited Hashtable
				visited.put(curNode, curSearch);
		}

		// If there is a SearchNode for the end node in the visited Hashtable, return it
		if (visited.get(nodes.get(end)) != null)
			return visited.get(nodes.get(end));

		// Otherwise, there is no path from start to end
		throw new NoSuchElementException("no path");
	}

	/**
	 * A helper method to find the minimum edge weight in the all the edges leaving the vertex
	 * 
	 * @param list - A list of all the edges in the tree
	 * @return - removes the smallest edge and returns that edge
	 */
	private Edge minHelper(List<Edge> list) {
		// algorithm for finding the minimum value
		double min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			if (min > list.get(i).data.doubleValue()) {
				index = i;
				min = list.get(i).data.doubleValue();
			}
		}
		// remove edge
		Edge returned = list.remove(index);
		return returned;
	}

	/**
	 * Returns the list of data values from nodes along the shortest path from the
	 * node with the provided start value through the node with the provided end
	 * value. This list of data values starts with the start value, ends with the
	 * end value, and contains intermediary values in the order they are encountered
	 * while traversing this shorteset path. This method uses Dijkstra's shortest
	 * path algorithm to find this solution.
	 *
	 * @param start the data item in the starting node for the path
	 * @param end   the data item in the destination node for the path
	 * @return list of data item from node along this shortest path
	 */
	public List<NodeType> shortestPathData(NodeType start, NodeType end) {
		// TODO: implement in step 7
		List<NodeType> path = new LinkedList<>();

		// Compute shortest path
		SearchNode endSearchNode = computeShortestPath(start, end);

		// Add nodes to path list (in reverse order)
		SearchNode currentNode = endSearchNode;
		path.add(0, currentNode.node.data);
		while (currentNode.predecessor != null) {
			path.add(0, currentNode.predecessor.node.data);
			currentNode = currentNode.predecessor;
		}
		return path;
	}

	/**
	 * Returns the cost of the path (sum over edge weights) of the shortest path
	 * freom the node containing the start data to the node containing the end data.
	 * This method uses Dijkstra's shortest path algorithm to find this solution.
	 *
	 * @param start the data item in the starting node for the path
	 * @param end   the data item in the destination node for the path
	 * @return the cost of the shortest path between these nodes
	 */
	public double shortestPathCost(NodeType start, NodeType end) {
		// TODO: implement in step 7
		// Compute shortest path
		SearchNode endSearchNode = computeShortestPath(start, end);

		// Return cost of shortest path
		return endSearchNode.cost;
	}

}
