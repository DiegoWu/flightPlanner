
import java.util.List;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public interface FlightPathBackendInterface {
	// public FligthPathBackend(DijkstraWithMinTransferInterface dijkstraGraph, FileReaderInterface reader);
	public void LoadMap(String filepath) throws FileNotFoundException;
	public List<AirportInterface> getAllAirports();
	public List<AirportInterface> shortestPaths(AirportInterface start, AirportInterface end) throws NoSuchElementException;
	public int arrivalTime(AirportInterface start, AirportInterface end) throws NoSuchElementException;
	public boolean directFlight(AirportInterface start, AirportInterface end); 
}

