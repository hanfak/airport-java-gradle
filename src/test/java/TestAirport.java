import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.Mock;

public class TestAirport {
	 @Mock
	 Plane plane;
	
	 @Test
	 public void canCreateObject() {
		 new Airport(plane);
	 }
	 
	 
}
