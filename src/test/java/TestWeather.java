import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class TestWeather {
	 private Weather weather;
	 private Weather mockWeather;
	 
	 @Before
	 public void setUp() throws Exception {
		 weather = new Weather();
		 mockWeather = spy(new Weather());
	 }
	 
	 @Test
	 public void returnsNonStormyWeather() {
		 when(mockWeather.randomNumber()).thenReturn(1);
		 assertEquals(false, weather.isStormy()); 
	 }
	 
	 @Test
	 public void returnsStormyWeather() {
		 when(mockWeather.randomNumber()).thenReturn(9);
		 assertEquals(true, mockWeather.isStormy()); 
	 }
}
