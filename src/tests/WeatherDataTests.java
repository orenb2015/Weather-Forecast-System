import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.Test;

import weather.WeatherData;

public class WeatherDataTests {

	/**
	 * to compare doubles, we must use delta. we chose 0.1.
	 */
	@Test
	public void getAndSet() {
		WeatherData data = new WeatherData();

		data.setCityID(123);
		assertEquals(123, data.getCityID());

		data.setCityName("123");
		assertEquals("123", data.getCityName());

		data.setClouds(100);
		assertEquals(100, data.getClouds());

		data.setCoordLat(55.44);
		assertEquals(55.44, data.getCoordLat(), 0.1);

		data.setCoordLon(59.44);
		assertEquals(59.44, data.getCoordLon(), 0.1);

		data.setCountryCode("IL");
		assertEquals("IL", data.getCountryCode());

		data.setHumidity(99);
		assertEquals(99, data.getHumidity());

		data.setPressure(88);
		assertEquals(88, data.getPressure());

		data.setRain3h(74.32);
		assertEquals(74.32, data.getRain3h(), 0.1);

		data.setSnow3h(74.32);
		assertEquals(74.32, data.getSnow3h(), 0.1);

		data.setSunrise(new DateTime(8748398));
		assertEquals(new DateTime(8748398), data.getSunrise());

		data.setSunset(new DateTime(8748348));
		assertEquals(new DateTime(8748348), data.getSunset());

		data.setTemp(74.32);
		assertEquals(74.32, data.getTemp(), 0.1);

		data.setTempMax(74.53);
		assertEquals(74.53, data.getTempMax(), 0.1);

		data.setTempMin(72.53);
		assertEquals(72.53, data.getTempMin(), 0.1);

		data.setTimeOfCalculation(new DateTime(9748348));
		assertEquals(new DateTime(9748348), data.getTimeOfCalculation());

		data.setWeatherDescription("cloudy");
		assertEquals("cloudy", data.getWeatherDescription());

		data.setWeatherIcon("03n");
		assertEquals("03n", data.getWeatherIcon());

		data.setWindDeg(24.53);
		assertEquals(24.53, data.getWindDeg(), 0.1);

		data.setWindSpeed(22.53);
		assertEquals(22.53, data.getWindSpeed(), 0.1);
	}

}
