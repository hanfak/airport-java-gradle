import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	private Weather weather ;
	
	public Airport(Weather weather){
		this.weather = weather;
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
		if ( weather.isStormy() ) { 
			throw new AirportException("Take-off denied. Weather is stormy!"); 
		}
		plane.depart();
		hanger.remove(plane);
	}
	
//	public static void main(String[] args) throws PlaneException, AirportException {
//		 Airport airport = new Airport(new Weather());
//		 Plane plane = new Plane();
//		 airport.instructToLand(plane);
//		 airport.instructToDepart(plane);
//		 System.out.println(airport.getHanger());
//	}
	
}
