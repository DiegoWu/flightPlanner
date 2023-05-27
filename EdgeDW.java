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
public class EdgeDW implements EdgeInterface{

	private AirportInterface predecessor; // Airport of predecessor node
	private AirportInterface successor;  // Airport of successor node
	private int edgeWeight; // Weight of edge

	/**
	 * Constructor
	 *
	 * @param a1 - predecessor airport node
	 * @param a2 - successor airport node
	 * @param weight - weight of edge
	 */
	public EdgeDW(AirportInterface a1, AirportInterface a2, int weight){
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
	public AirportInterface getPredecessor(){
		return predecessor;
	}

	/**
	 * Getter for successor
	 *
	 * @return sucessor - successor Airport node
	 */
	@Override
	public AirportInterface getSuccessor(){
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
  @Override
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (o.getClass() != this.getClass())
      return false;
    final EdgeDW other = (EdgeDW) o;
    if (other.getPredecessor().equals(this.getPredecessor())
        && other.getSuccessor().equals(this.getSuccessor())
        && other.getWeight() == this.getWeight())
      return true;

    return false;

  }
}
