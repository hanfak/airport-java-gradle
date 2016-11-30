import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
 
public class TestFeature {
	/*
	 * As an air traffic controller 
	 * So I can get passengers to a destination 
	 * I want to instruct a plane to land at an airport 
	 * 		and confirm that it has landed 
	 */
    @Test 
    public void UserStory1() throws PlaneException{
        Plane plane = new Plane();
        Airport airport = new Airport(new Weather());
        airport.instructToLand(plane);
        assertEquals(1, airport.getHanger().size());
        assertEquals(plane, airport.getHanger().get(0));
        assertEquals(true, plane.atAirport());
    }
    
    /*As an air traffic controller 
    So I can get passengers on the way to their destination 
    I want to instruct a plane to take off from an airport
     and confirm that it is no longer in the airport*/
    @Test
    public void UserStory2() throws PlaneException, AirportException {
    	Plane plane = new Plane();
    	Weather mockWeather = mock(Weather.class);
    	Airport airport = new Airport(mockWeather);
    	when(mockWeather.isStormy()).thenReturn(false);
    	airport.instructToLand(plane);
    	airport.instructToDepart(plane);
    	assertFalse(airport.getHanger().contains(plane));
    	assertFalse(plane.atAirport());
    }
    
    /*As an air traffic controller 
    To ensure safety 
    I want to prevent takeoff when weather is stormy*/
    @Test
    public void UserStory3() throws PlaneException {
    	Plane plane = new Plane();
    	Weather mockWeather = mock(Weather.class);
    	Airport airport = new Airport(mockWeather);
    	when(mockWeather.isStormy()).thenReturn(true);
    	airport.instructToLand(plane);
    	try { airport.instructToDepart(plane); } catch (AirportException e) {}
    	assertTrue(airport.getHanger().contains(plane));
    	assertTrue(plane.atAirport());
    }
}
