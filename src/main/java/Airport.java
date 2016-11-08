import java.util.ArrayList;
import java.util.List;

public class Airport {
//	private Plane[] hanger;
	private List<Plane> hanger;
	
	public Airport(){
		hanger =  new ArrayList<Plane>();
	}
	
	
	
	public void instructToLand(Plane plane){
		hanger.add(plane);
	}
	
	public List<Plane> getHanger() {
		return hanger;
	}
}
