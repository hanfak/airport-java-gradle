import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestPlane {
	 @Test
	 public void canCreateObject() {
		 new Plane();
	 }
	 
	 @Test
	 public void planeInAirDefault() {
		 Plane plane = new Plane();
		 assertEquals(false, plane.atAirport());
	 }
}
