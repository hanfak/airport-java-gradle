import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	private Weather weather;
	
	public Airport(Weather weather){
		this.weather = weather;
		hanger =  new ArrayList<Plane>();
 	}
	
	public List<Plane> getHanger() {
		return hanger;
	}
	
	public void instructToLand(Plane plane) throws PlaneException, AirportException{
		if ( weather.isStormy() ) { 
			throw new AirportException("Landing denied. Weather is stormy!"); 
		}
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
}
