
public class Plane {
	private Boolean atAirportStatus;
	
	public Plane() {
		atAirportStatus = false;
	}
	
	public void land() throws PlaneException {
		if (atAirportStatus==true) {
			throw new PlaneException("Plane already landed!");
		}
		atAirportStatus = true;
	}
	
	public Boolean atAirport() {
		return atAirportStatus;
	}
}
