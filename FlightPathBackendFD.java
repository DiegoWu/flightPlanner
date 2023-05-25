
import java.util.List;
import java.util.NoSuchElementException;
public class FlightPathBackendFD implements FlightPathBackendInterface {

  @Override
  public void LoadMap(String filepath) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<AirportInterface> getAllAirports() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<AirportInterface> shortestPaths(AirportInterface start, AirportInterface end) {
    // TODO Auto-generated method stub
    return null;
  }

 

  @Override
  public int arrivalTime(AirportInterface start, AirportInterface end)throws NoSuchElementException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean directFlight(AirportInterface start, AirportInterface end) {
    // TODO Auto-generated method stub
    return false;
  }
  
}
