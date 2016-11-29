import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	
	public Airport(){
		hanger =  new ArrayList<Plane>();
	}
	
	public void instructToLand(Plane plane) throws PlaneException{
		plane.land();
		hanger.add(plane);
	}

	public List<Plane> getHanger() {
		return hanger;
	}

	public void instructToDepart(Plane plane) throws PlaneException, AirportException {
		if ( stormyWeather() ) { 
			throw new AirportException("Take-off denied. Weather is stormy!"); 
		}
		plane.depart();
		hanger.remove(plane);
	}
	
	protected boolean stormyWeather() {
        return Math.random() > 0.8;
    }
	
}
