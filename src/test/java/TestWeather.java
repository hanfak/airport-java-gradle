import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestWeather {
	 private Weather mockWeather;
	 
	 @Before
	 public void setUp() throws Exception {
		 mockWeather = spy(new Weather());
	 }
	 
	 @Test
	 public void returnsNonStormyWeather() {
		 when(mockWeather.randomNumber()).thenReturn(1);
		 assertEquals(false, mockWeather.isStormy()); 
	 }
	 
	 @Test
	 public void returnsStormyWeather() {
		 when(mockWeather.randomNumber()).thenReturn(9);
		 assertEquals(true, mockWeather.isStormy()); 
	 }
}
