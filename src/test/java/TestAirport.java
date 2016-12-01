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
	 public void instructToLandExists() throws PlaneException, AirportException{
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void storePlaneInHangerWhenLanded() throws PlaneException, AirportException{
		 airport.instructToLand(plane);

		 assertEquals(airport.getHanger().get(0), plane);
	 }
	 
	 @Test
	 public void instructToLandCallsLandOnPlane() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 verify(plane).land();
	 }
	 
	 @Test
	 public void instructToLandCallsIsStormy() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 verify(mockWeather).isStormy();
	 }
	 
	 @Test
	 public void throwsErrorWhenLandingInStorm() throws AirportException, PlaneException{
		 when(mockWeather.isStormy()).thenReturn(true);
		 
		 thrown.expect(AirportException.class);
		 thrown.expectMessage("Landing denied. Weather is stormy!");
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void nstructToDepartExists() throws PlaneException{
		 try {
			airport.instructToDepart(plane);
		} catch (AirportException e) {}
	 }
	 
	 @Test
	 public void removePlaneFromHangerWhenDeparted() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 airport.instructToDepart(plane);
		 
		 assertFalse(airport.getHanger().contains(plane));
	 }
	 
	 @Test
	 public void instructToDepartCallsDepartOnPlane() throws PlaneException, AirportException {
		 airport.instructToLand(plane);
		 airport.instructToDepart(plane);
		 verify(plane).depart();
	 }
	 
	 @Test
	 public void instructToDepartCallsIsStormy() throws PlaneException{
		 when(mockWeather.isStormy()).thenReturn(true);
		 try {
			airport.instructToDepart(plane);
		} catch (AirportException e) {}
		 verify(mockWeather).isStormy();
	 }
	 
	 @Test
	 public void throwsErrorWhenDepartingInStorm() throws AirportException, PlaneException{
		 when(mockWeather.isStormy()).thenReturn(false);
		 airport.instructToLand(plane);
		 when(mockWeather.isStormy()).thenReturn(true);
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Departure denied. Weather is stormy!");
	     airport.instructToDepart(plane);
	 }
	 
	 @Test
	 public void throwsErrorIfDepartWhenNotAirport() throws AirportException, PlaneException{
		 when(mockWeather.isStormy()).thenReturn(false);
		 
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Departure cannot happen. Plane is not at airport!");
	     airport.instructToDepart(plane);
	 }
	 
	 @Test
	 public void throwsErrorWhenPlaneLandsInFullAirport() throws AirportException, PlaneException {
		 when(mockWeather.isStormy()).thenReturn(false);
		 airport.instructToLand(plane);
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Landing denied. Airport Full!");
		 airport.instructToLand(plane);
	 }
	 
	 @Test
	 public void throwsErrorWhenPlaneLandsInFullAirportWithVariedCapacity() throws AirportException, PlaneException {
		 when(mockWeather.isStormy()).thenReturn(false);
		 airport = 	new Airport(mockWeather, 20);
		 for (int i = 0; i < 20; i++) {
			 airport.instructToLand(plane);
		 }
		 thrown.expect(AirportException.class);
	     thrown.expectMessage("Landing denied. Airport Full!");
		 airport.instructToLand(plane);
	 }
}
