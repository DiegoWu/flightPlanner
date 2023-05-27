// --== CS400 File Header Information ==--
// Name: <Ti Wu>
// Email: <twu353@wisc.edu>
// Group and Team: <DX>
// Group TA: <April>
// Lecturer: <Florian>
// Notes to Grader: <Orz>
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Hashtable;
import java.util.List;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class extends the BaseGraph data structure with additional methods for computing the total
 * cost and list of node data along the shortest path connecting a provided starting to ending
 * nodes. This class makes use of Dijkstra's shortest path algorithm.
 */
public class DijkstraGraph<NodeType, EdgeType extends Number> extends BaseGraph<NodeType, EdgeType>
    implements GraphADT<NodeType, EdgeType> {

  /**
   * While searching for the shortest path between two nodes, a SearchNode contains data about one
   * specific path between the start node and another node in the graph. The final node in this path
   * is stored in it's node field. The total cost of this path is stored in its cost field. And the
   * predecessor SearchNode within this path is referened by the predecessor field (this field is
   * null within the SearchNode containing the starting node in it's node field).
   *
   * SearchNodes are Comparable and are sorted by cost so that the lowest cost SearchNode has the
   * highest priority within a java.util.PriorityQueue.
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

  // private helper method for print
  private static <T> void print(T x) {
    System.out.println(x);
  }

  /**
   * This helper method creates a network of SearchNodes while computing the shortest path between
   * the provided start and end locations. The SearchNode that is returned by this method is
   * represents the end of the shortest path that is found: it's cost is the cost of that shortest
   * path, and the nodes linked together through predecessor references represent all of the nodes
   * along that shortest path (ordered from end to start).
   *
   * @param start the data item in the starting node for the path
   * @param end   the data item in the destination node for the path
   * @return SearchNode for the final end node within the shortest path
   * @throws NoSuchElementException when no path from start to end is found or when either start or
   *                                end data do not correspond to a graph node
   */
  protected SearchNode computeShortestPath(NodeType start, NodeType end)
      throws NoSuchElementException {

    if (!this.containsNode(start) || !this.containsNode(end))
      throw new NoSuchElementException("the starting node or the ending node does not exist");

    PriorityQueue<SearchNode> pq = new PriorityQueue<SearchNode>();

    Node s = this.nodes.get(start); // starting node
    Node e = this.nodes.get(end); // ending node
    SearchNode ss = new SearchNode(s, 0, null); // starting node searchnode version

    Hashtable<Node, SearchNode> visited = new Hashtable<Node, SearchNode>();
    Hashtable<Node, SearchNode> unvisited = new Hashtable<Node, SearchNode>();

    // initialize the unvisited nodes
    for (Node node : this.nodes.values()) {
      SearchNode temp = new SearchNode(node, Double.MAX_VALUE, null);
      unvisited.put(node, temp);
    }

    pq.add(ss); // adding the starting node to the priority queue

    while (!pq.isEmpty()) {
      SearchNode st = pq.peek(); // start node
      pq.remove();

      if (visited.get(st.node) != null) // checking whether the node is visited
        continue;

      for (Edge edge : st.node.edgesLeaving) {
        SearchNode after;
        if (visited.get(edge.successor) != null) // checking whether the node is visited
          continue;

        after = unvisited.get(edge.successor); // the neighbor node for start node
        if (after.cost > st.cost + edge.data.doubleValue()) { // checking a shorter path between
                                                              // starting node and current node
          after.cost = st.cost + edge.data.doubleValue();
          after.predecessor = st;
          // updating the searchnode in unvisited hashtable
          unvisited.remove(after.node);
          unvisited.put(after.node, after);
          pq.add(after);
        }
      }
      visited.put(st.node, st);
    }

    if (visited.get(e) == null)
      throw new NoSuchElementException("the path does not exist");

    return visited.get(e);
  }

  /**
   * Returns the list of data values from nodes along the shortest path from the node with the
   * provided start value through the node with the provided end value. This list of data values
   * starts with the start value, ends with the end value, and contains intermediary values in the
   * order they are encountered while traversing this shorteset path. This method uses Dijkstra's
   * shortest path algorithm to find this solution.
   *
   * @param start the data item in the starting node for the path
   * @param end   the data item in the destination node for the path
   * @throws NoSuchElementException when no path from start to end is found or when either start or
   *                                end data do not correspond to a graph node
   * @return list of data item from node along this shortest path
   */
  public List<NodeType> shortestPathData(NodeType start, NodeType end)
      throws NoSuchElementException {
    SearchNode e = this.computeShortestPath(start, end);

    List<NodeType> temp = new ArrayList<NodeType>();

    while (e != null) {
      temp.add(e.node.data); // reversely adding the nodes to temp array
      e = e.predecessor;

    }
    Collections.reverse(temp);
    return temp;
  }

  /**
   * Returns the cost of the path (sum over edge weights) of the shortest path freom the node
   * containing the start data to the node containing the end data. This method uses Dijkstra's
   * shortest path algorithm to find this solution.
   *
   * @param start the data item in the starting node for the path
   * @param end   the data item in the destination node for the path
   * @throws NoSuchElementException when no path from start to end is found or when either start or
   *                                end data do not correspond to a graph node
   * @return the cost of the shortest path between these nodes
   */
  public double shortestPathCost(NodeType start, NodeType end) throws NoSuchElementException {
    double cost = this.computeShortestPath(start, end).cost;
    return cost;
  }

 }
