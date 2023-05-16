
public class AirportAE implements AirportInterface {
	private int size;
	private String name;
	private String abbreviation;
	
	public AirportAE(String name, String abbreviation, int size) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.size = size;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getAbrName() {
		// TODO Auto-generated method stub
		return abbreviation;
	}

}
