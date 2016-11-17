import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPlane {
	 @Test
	 public void canCreateObject() {
		 new Plane();
	 }
	 
	 @Test
	 public void planeInAirByDefault() {
		 Plane plane = new Plane();
		 assertEquals(false, plane.atAirport());
	 }
	 
	 @Test
	 public void planeAtAirportWhenLanded() {
		 Plane plane = new Plane();
		 plane.land();
		 assertEquals(true, plane.atAirport());
	 }
	 
//	 plane cannot land if atAirport
}
