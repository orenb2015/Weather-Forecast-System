import static org.junit.Assert.*;

import org.junit.Test;

import weather.Location;
import weather.OpenWeatherMapDataService;
import weather.WeatherData;
import weather.WeatherDataServiceException;


public class OpenWeatherMapDataServiceTests {

	@Test
	public void jerusalemTest() throws Exception {
		OpenWeatherMapDataService service = new OpenWeatherMapDataService();
		WeatherData data = service.getWeatherData(new Location("281184"));
		assertEquals("Jerusalem", data.getCityName());
		assertEquals(281184, data.getCityID());
		assertEquals(31.77, data.getCoordLat(), 0.1);
		assertEquals(35.22, data.getCoordLon(), 0.1);
		assertEquals("IL", data.getCountryCode());
	}
	
	@Test(expected=Exception.class)
	public void unknownCityTest() throws Exception {
		OpenWeatherMapDataService service = new OpenWeatherMapDataService();
		service.getWeatherData(new Location("999999999"));
	}
}
