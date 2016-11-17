import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestAirport {
	 private Airport airport;
	 Plane plane = mock(Plane.class);
	 
	 @Before
	 public void setUp() throws Exception {
		 airport = 	new Airport();
	 }
	
	 @Test
	 public void canCreateObject() {
		 new Airport();
	 }
	 
	 @Test
	 public void testInstructToLandExists() throws PlaneException{
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void testStorePlaneInHangerWhenLanded() throws PlaneException{
		 airport.instructToLand(plane);
		 List<Plane> storedPlane = airport.getHanger();
		 assertEquals(storedPlane.get(0), plane);
	 }
	 
	 @Test
	 public void testInstructToLandCallsLandOnPlane() throws PlaneException {
		 airport.instructToLand(plane);
		 verify(plane).land();
	 }
}
