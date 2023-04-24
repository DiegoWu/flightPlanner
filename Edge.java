// --== CS400 File Header Information ==--
// Name: Viola Vinatzer
// Email: vinatzer@wisc.edu
// Group and Team: DX red
// Group TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: None

/**
 * This class represents an edge in a graph,
 * including it's predecessor, successor,
 * and weight
 */
public class Edge implements EdgeInterface{

	private Airport predecessor; // Airport of predecessor node
	private Airport successor;  // Airport of successor node
	private int edgeWeight; // Weight of edge

	/**
	 * Constructor
	 *
	 * @param a1 - predecessor airport node
	 * @param a2 - successor airport node
	 * @param weight - weight of edge
	 */
	public Edge(Airport a1, Airport a2, int weight){
		predecessor = a1;
		successor = a2;
		edgeWeight = weight;
	}

	/**
	 * Getter for predecessor
	 *
	 * @return predecessor - predecessor Airport node
	 */
	@Override
	public Airport getPredecessor(){
		return predecessor;
	}

	/**
	 * Getter for successor
	 *
	 * @return sucessor - successor Airport node
	 */
	@Override
	public Airport getSuccessor(){
		return successor;
	}

	/**
	 * Getter for edgeWeight
	 *
	 * @return edgeWeight - weight of edge
	 */
	@Override
	public int getWeight(){
		return edgeWeight;
	}

}
