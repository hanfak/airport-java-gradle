
public class Plane {
	private Boolean atAirportStatus;
	
	public Plane() {
		atAirportStatus = false;
	}
	
	public void land(){
		atAirportStatus = true;
	}
	
	public Boolean atAirport() {
		return atAirportStatus;
	}
}
