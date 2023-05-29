// --==CS400 File Header Information ==--
// Name: Viola Vinatzer
// Email: vinatzer@wisc.edu
// Group and Team: DX red
// Group TA: April Roszkowski
// Lecturer: Florian Heimerl
// Notes to Grader: None

/**
 * This class represents an airport with
 * its size, name, and name abbreviation
 */
public class AirportDW implements AirportInterface, Comparable<AirportDW> {

  private String name; // Airport name
  private String abbreviation; // Abbreviation of name
  private int size; // Size of airport

  /**
   * Constructor
   *
   * @param name - name of airport
   * @param abbreviation - abbreviation of name
   * @param size - size of airport
   */
  public AirportDW(String name, String abbreviation, int size){
    this.name = name;
    this.abbreviation = abbreviation;
    this.size = size;
  }

  /**
   * Getter for size
   *
   * @return size - size of airport
   */
  @Override
  public int getSize(){
    return size;
  }

  /**
   * Getter for name
   *
   * @return name - name of airport
   */
  @Override
  public String getName(){
    return name;
  }

  /**
   * Getter for name abbreviaton
   *
   * @return abbreviation - name abbreviatoin
   */
  @Override
  public String getAbrName(){
    return abbreviation;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (o.getClass() != this.getClass())
      return false;
    final AirportDW other = (AirportDW) o;
    if (other.getName().equals(this.getName()) && other.getAbrName().equals(this.getAbrName()))
      return true;
    return false;

  }
  @Override 

  public int hashCode() {
    return this.getName().hashCode()+ this.getAbrName().hashCode(); 
  }
  @Override
  public int compareTo(AirportDW o) {
    if(this.getSize()> o.getSize()) {
      return 1; 
    }
    else if(this.getSize()< o.getSize()) {
      return -1; 
    }
    else {
      return 0; 
    } 
  }
}
