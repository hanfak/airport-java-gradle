import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestPlane {
	 private Plane plane;
	 
	 @Before
	 public void setUp() throws Exception {
		 plane = new Plane();
	 }
	 
	 @Rule
     public ExpectedException thrown = ExpectedException.none();
	 
	 @Test
	 public void canCreateObject() {
		 new Plane();
	 }
	 
	 @Test
	 public void planeInAirByDefault() {
		 assertEquals(false, plane.atAirport()); 
	 }
	 
	 @Test
	 public void planeAtAirportWhenLanded()  {
		 try { plane.land(); } catch (PlaneException e) {}
		 assertEquals(true, plane.atAirport());
	 }

	 @Test(expected = PlaneException.class) 
	 public void throwsErrorlandingWhenAtAirport() throws PlaneException {
		 plane.land();
		 plane.land();    
	 }
	 
	 @Test
	 public void planeNotAtAirportWhenDeparted() throws PlaneException  {
		 try { plane.depart(); } catch (PlaneException e) {}
		 assertEquals(false, plane.atAirport());
	 }
	 
	 @Test(expected = PlaneException.class) 
	 public void throwsErrorDepartWhenNotAtAirport() throws PlaneException {
		 plane.depart();
	 }
}
