import java.util.ArrayList;
import java.util.List;

public class Airport {
	private List<Plane> hanger;
	
	public Airport(){
		hanger =  new ArrayList<Plane>();
	}
	
	
	
	public void instructToLand(Plane plane){
		plane.land();
		hanger.add(plane);
	}
	
	public List<Plane> getHanger() {
		return hanger;
	}
}
