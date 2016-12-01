import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	private Weather weather;
	private int capacity;
	private int DEFAULT_CAPACITY = 1;
	
	public Airport(Weather weather) {
		this.weather 	= weather;
		this.hanger 	= new ArrayList<Plane>();
		this.capacity 	= DEFAULT_CAPACITY;
 	}
	
	public Airport(Weather weather, int capacity) {
		this.weather	 = weather;
		this.hanger		 = new ArrayList<Plane>();
		this.capacity 	 = capacity;
 	}
	
	public List<Plane> getHanger() {
		return hanger;
	}

	public void instructToLand(Plane plane) throws PlaneException, AirportException{
		checkCanLand();
		plane.land();
		hanger.add(plane);
	}

	public void instructToDepart(Plane plane) throws PlaneException, AirportException {
		checkCanDepart(plane);
		plane.depart();
		hanger.remove(plane);
	}
	
	private void checkCanLand() throws AirportException{
		if ( weather.isStormy() ) { 
			throw new AirportException("Landing denied. Weather is stormy!"); 
		}
		if (hanger.size() >= capacity) {
			throw new AirportException("Landing denied. Airport Full!");
		}
	}
	
	private void checkCanDepart(Plane plane) throws AirportException{
		if ( weather.isStormy() ) { 
			throw new AirportException("Departure denied. Weather is stormy!"); 
		}
		if (!hanger.contains(plane)){
			throw new AirportException("Departure cannot happen. Plane is not at airport!"); 
		}
	}
}
