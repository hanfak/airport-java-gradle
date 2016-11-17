import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TestAirport {
	 Plane plane = mock(Plane.class);
	
	 @Test
	 public void canCreateObject() {
		 new Airport();
	 }
	 
	 @Test
	 public void testInstructToLandExists() throws PlaneException{
		 Airport airport = new Airport();
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void testStorePlaneInHangerWhenLanded() throws PlaneException{
		 Airport airport = new Airport();
		 airport.instructToLand(plane);
		 List<Plane> storedPlane = airport.getHanger();
		 assertEquals(storedPlane.get(0), plane);
	 }
	 
	 @Test
	 public void testInstructToLandCallsLandOnPlane() throws PlaneException {
		 Airport airport = new Airport();
		 airport.instructToLand(plane);
		 verify(plane).land();
	 }
}
