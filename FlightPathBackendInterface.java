
import java.util.List;

public interface FlightPathBackendInterface {
	// public FligthPathBackend(DijkstraWithMinTransferInterface dijkstraGraph, FileReaderInterface reader);
	public void loadMap(String filepath) throws FileNotFoundException;
	public List<AirportInterface> getAllAirports();
	public List<AirportInterface> shortestPath(AirportInterface start, AirportInterface end) throws NoSuchElementException;
	public int arrivalTime(AirportInterface start, AirportInterface end) throws NoSuchElementException;
	public boolean directFlight(AirportInterface start, AirportInterface end); 
}

