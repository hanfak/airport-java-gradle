import static org.junit.Assert.*;

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
        Airport airport = new Airport();
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
    	Airport airport = new Airport();
    	airport.instructToLand(plane);
    	airport.instructToDepart(plane);
    	assertFalse(airport.getHanger().contains(plane));
    	assertFalse(plane.atAirport());
    }
    
    /*As an air traffic controller 
    To ensure safety 
    I want to prevent takeoff when weather is stormy*/
//    @Test
//    public void UserStory3() throws PlaneException {
//    	Plane plane = new Plane();
//    	Airport airport = new Airport();
//    	airport.instructToLand(plane);
//    	airport.instructToDepart(plane);
//    	assertTrue(airport.getHanger().contains(plane));
//    	assertTrue(plane.atAirport());
//    }
}
