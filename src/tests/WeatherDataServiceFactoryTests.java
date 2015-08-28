import static org.junit.Assert.*;

import org.junit.Test;

import weather.IWeatherDataService;
import weather.WeatherDataServiceFactory;

public class WeatherDataServiceFactoryTests {

	@Test
	public void isSingleton() throws Exception {
		IWeatherDataService openWeatherDataService1 = WeatherDataServiceFactory.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
		IWeatherDataService openWeatherDataService2 = WeatherDataServiceFactory.getWeatherDataService(WeatherDataServiceFactory.OPEN_WEATHER_MAP);
		assertEquals(openWeatherDataService1, openWeatherDataService2);
	}

}
