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
public class Airport implements AirportInterface{

	private int name; // Airport name
	private int abbreviation; // Abbreviation of name
	private int size; // Size of airport

	/**
	 * Constructor
	 *
	 * @param name - name of airport
	 * @param abbreviation - abbreviation of name
	 * @param size - size of airport
	 */
	public Airport(String name, String abbreviation, int size){
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
	public int getName(){
		return name;
	}

	/**
	 * Getter for name abbreviaton
	 *
	 * @return abbreviation - name abbreviatoin
	 */
	@Override
	public int getAbrName(){
		return abbreviation;
	}


}
