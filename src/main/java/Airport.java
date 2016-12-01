import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	private Weather weather;
	private int DEFAULT_CAPACITY = 1;
	
	public Airport(Weather weather){
		this.weather = weather;
		this.hanger =  new ArrayList<Plane>();
 	}
	
	public List<Plane> getHanger() {
		return hanger;
	}

	public void instructToLand(Plane plane) throws PlaneException, AirportException{
		checkPlaneCanLand();
		plane.land();
		hanger.add(plane);
	}

	public void instructToDepart(Plane plane) throws PlaneException, AirportException {
		if ( weather.isStormy() ) { 
			throw new AirportException("Departure denied. Weather is stormy!"); 
		}
		plane.depart();
		hanger.remove(plane);
	}
	
	private void checkPlaneCanLand() throws AirportException{
		if ( weather.isStormy() ) { 
			throw new AirportException("Landing denied. Weather is stormy!"); 
		}
		if (hanger.size() >= DEFAULT_CAPACITY) {
			throw new AirportException("Landing denied. Airport Full!");
		}
	}
}
