
public interface EdgeInterface {
  // public EdgeInterface(Airport a1, Airport a2, int weight);
  public AirportFD getPredecessor();
  public AirportFD getSuccessor();
  public int getWeight();
}
