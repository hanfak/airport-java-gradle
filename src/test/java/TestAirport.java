import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestAirport {
	 private Airport airport;
	 private Plane plane = mock(Plane.class);
	 
	 @Before
	 public void setUp() throws Exception {
		 airport = 	new Airport();
	 }
	
	 @Test
	 public void canCreateObject() {
		 new Airport();
	 }
	 
	 @Test
	 public void InstructToLandExists() throws PlaneException{
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void StorePlaneInHangerWhenLanded() throws PlaneException{
		 airport.instructToLand(plane);

		 assertEquals(airport.getHanger().get(0), plane);
	 }
	 
	 @Test
	 public void InstructToLandCallsLandOnPlane() throws PlaneException {
		 airport.instructToLand(plane);
		 verify(plane).land();
	 }
	 
	 @Test
	 public void InstructToDepartExists() throws PlaneException{
		 airport.instructToDepart(plane);
	 }
	 
	 @Test
	 public void RemovePlaneFromHangerWhenDeparted() throws PlaneException {
		 airport.instructToLand(plane);
		 airport.instructToDepart(plane);
		 
		 assertFalse(airport.getHanger().contains(plane));
	 }
	 
	 @Test
	 public void InstructToDepartCallsDepartOnPlane() throws PlaneException {
		 airport.instructToDepart(plane);
		 verify(plane).depart();
	 }
	 
	 
}
