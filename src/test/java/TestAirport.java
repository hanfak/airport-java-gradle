import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

public class TestAirport {
	 @Mock
	 Plane plane;
	
	 @Test
	 public void canCreateObject() {
		 new Airport();
	 }
	 
	 @Test
	 public void testInstructToLandExists() {
		 Airport airport = new Airport();
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void testStorePlaneInHangerWhenLanded() {
		 Airport airport = new Airport();
		 airport.instructToLand(plane);
		 List<Plane> storedPlane = airport.getHanger();
//		 System.out.println(storedPlane);
		 assertEquals(storedPlane.get(0), plane);
	 }
}
