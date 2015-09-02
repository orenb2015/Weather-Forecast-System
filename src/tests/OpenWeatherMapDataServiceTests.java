import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.Location;
import weather.OpenWeatherMapDataService;
import weather.WeatherData;
import weather.WeatherDataServiceException;

public class OpenWeatherMapDataServiceTests {

	@Test
	public void jerusalemTest() throws Exception {
		OpenWeatherMapDataService service = new OpenWeatherMapDataService();
		// get jerusalem json
		WeatherData data = service.getWeatherData(new Location("281184"));

		// check only the variables that are not dependant on time of checking.
		assertEquals("Jerusalem", data.getCityName());
		assertEquals(281184, data.getCityID());
		assertEquals(31.77, data.getCoordLat(), 0.1);
		assertEquals(35.22, data.getCoordLon(), 0.1);
		assertEquals("IL", data.getCountryCode());
	}

	@Test
	public void unknownCityTest() {
		try {
			OpenWeatherMapDataService service = new OpenWeatherMapDataService();
			service.getWeatherData(new Location("999999999"));
		} catch (WeatherDataServiceException ex) {
			return;
		}

		assertEquals(true, false);
	}
}
