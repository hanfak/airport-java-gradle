
public class Plane {
	private Boolean atLandedStatus;
	
	public Plane() {
		atLandedStatus = false;
	}
	
	public void land() throws PlaneException {
		if (atLandedStatus==true) {
			throw new PlaneException("Plane already landed!");
		} 
		atLandedStatus = true;
	}
	
	public void depart() throws PlaneException {
		if (atLandedStatus==false) {
			throw new PlaneException("Plane still in air: land plane first to depart!");
		}
		atLandedStatus = false;
	}
	
	public Boolean hasLanded() {
		return atLandedStatus;
	}
}
