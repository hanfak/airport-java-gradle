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
    public void UserStory1() throws PlaneException, AirportException{
        Plane plane = new Plane();
    	Weather mockWeather = mock(Weather.class);
    	Airport airport = new Airport(mockWeather);
    	when(mockWeather.isStormy()).thenReturn(false);
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
    public void UserStory3() throws PlaneException, AirportException {
    	Plane plane = new Plane();
    	Weather mockWeather = mock(Weather.class);
    	Airport airport = new Airport(mockWeather);
    	when(mockWeather.isStormy()).thenReturn(false);
    	airport.instructToLand(plane);
    	when(mockWeather.isStormy()).thenReturn(true);
    	try { airport.instructToDepart(plane); } catch (AirportException e) {}
    	assertTrue(airport.getHanger().contains(plane));
    	assertTrue(plane.atAirport());
    }
    
    /* As an air traffic controller 
    To ensure safety 
    I want to prevent landing when weather is stormy */
    @Test
    public void UserStory4() throws PlaneException {
    	Plane plane = new Plane();
    	Weather mockWeather = mock(Weather.class);
    	Airport airport = new Airport(mockWeather);
    	when(mockWeather.isStormy()).thenReturn(true);
    	try { airport.instructToLand(plane); } catch (AirportException e) {}
    	assertFalse(airport.getHanger().contains(plane));
    	assertEquals(airport.getHanger().size(), 0);
    	assertFalse(plane.atAirport());
    }
    
    /*As an air traffic controller 
    To ensure safety 
    I want to prevent landing when the airport is full */
//    @Test
//    public void UserStory5() throws PlaneException, AirportException {
//    	Plane plane1 = new Plane();
//    	Plane plane2 = new Plane();
//    	Weather mockWeather = mock(Weather.class);
//    	Airport airport = new Airport(mockWeather);
//    	when(mockWeather.isStormy()).thenReturn(false);
//    	airport.instructToLand(plane1);
//    	try { airport.instructToLand(plane2); } catch (AirportException e) {}
//    	assertFalse(airport.getHanger().contains(plane2));
//    	assertTrue(airport.getHanger().contains(plane1));
//    	assertEquals(airport.getHanger().size(), 1);
//    	assertTrue(plane1.atAirport());
//    	assertFalse(plane2.atAirport());
//    }
    
    
}
