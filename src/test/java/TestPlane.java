import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestPlane {
	 @Rule
     public ExpectedException thrown = ExpectedException.none();
	 
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
		 try {
			plane.land();
		 } catch (PlaneException e) {
			
		 }
		 assertEquals(true, plane.atAirport());
	 }
	 
//	 @Test
//	 public void throwsErrorlandingWhenAtAirport() throws PlaneException {
//		 Plane plane = new Plane();
//		 plane.land();
//		 
//		 thrown.expect(PlaneException.class);
//		 thrown.expectMessage("Plane already landed!");
//		 plane.land();
//	 }
	 
	 @Test(expected = PlaneException.class) 
	 public void throwsErrorlandingWhenAtAirport() throws PlaneException {
		 Plane plane = new Plane();
		 plane.land();
		 plane.land();    
	 }
}
