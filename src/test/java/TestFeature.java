import static org.junit.Assert.assertEquals;
import org.junit.Test;
 
public class TestFeature {
	/*
	 * As an air traffic controller 
	 * So I can get passengers to a destination 
	 * I want to instruct a plane to land at an airport 
	 * 		and confirm that it has landed 
	 */
    @Test 
    public void testUserStory1() {
        Plane plane = new Plane();
        Airport airport = new Airport();
        airport.instructToLand(plane);
        assertEquals(1, airport.getHanger().size());
        assertEquals(plane, airport.getHanger().get(0));
//        assertEquals(true, plane.atAirport());
    }
}
