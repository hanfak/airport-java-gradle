import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestAirport {
	 private Airport airport;
	 private Plane plane = mock(Plane.class);
	 private Weather mockWeather = mock(Weather.class);
	 
	 @Rule
     public ExpectedException thrown = ExpectedException.none();
	 
	 @Before
	 public void setUp() throws Exception {
		 airport = 	new Airport(mockWeather);
	 }
	
	 @Test
	 public void canCreateObject() {
		 new Airport(mockWeather);
	 }
	 
	 @Test
	 public void InstructToLandExists() throws PlaneException, AirportException{
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void StorePlaneInHangerWhenLanded() throws PlaneException, AirportException{
		 airport.instructToLand(plane);

		 assertEquals(airport.getHanger().get(0), plane);
	 }
	 
	 @Test
	 public void InstructToLandCallsLandOnPlane() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 verify(plane).land();
	 }
	 
	 @Test
	 public void InstructToDepartExists() throws PlaneException, AirportException{
		 airport.instructToDepart(plane);
	 }
	 
	 @Test
	 public void RemovePlaneFromHangerWhenDeparted() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 airport.instructToDepart(plane);
		 
		 assertFalse(airport.getHanger().contains(plane));
	 }
	 
	 @Test
	 public void InstructToDepartCallsDepartOnPlane() throws PlaneException, AirportException {
		 airport.instructToDepart(plane);
		 verify(plane).depart();
	 }
	 
	 @Test
	 public void InstructToDepartCallsIsStormyOnPlane() throws PlaneException, AirportException {
		 airport.instructToDepart(plane);
		 verify(mockWeather).isStormy();
	 }
	 
	 @Test
	 public void throwsErrorWhenDepartingInStorm1() throws AirportException, PlaneException{
		 when(mockWeather.isStormy()).thenReturn(true);
		 
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Departure denied. Weather is stormy!");
	     airport.instructToDepart(plane);
	 }
	 
	 @Test
	 public void InstructToLandCallsIsStormyOnPlane() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 verify(mockWeather).isStormy();
	 }
	 
	 @Test
	 public void throwsErrorWhenLandingInStorm1() throws AirportException, PlaneException{
		 when(mockWeather.isStormy()).thenReturn(true);
		 
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Landing denied. Weather is stormy!");
	     airport.instructToLand(plane);
	 }
}
