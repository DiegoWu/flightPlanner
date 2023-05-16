
import java.util.List;

public interface FlightPathBackendInterface {
  // public FligthPathBackend();
  public void loadMap(String filepath);
  public List<AirportInterface> getAllAirports();
  public List<AirportInterface> shortestPaths(AirportInterface start, AirportInterface end);
  public int arrivalTime(AirportInterface start, AirportInterface end);
  public boolean directFlight(AirportInterface start, AirportInterface end); 
}

