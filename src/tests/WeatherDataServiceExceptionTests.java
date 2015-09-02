import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.WeatherDataServiceException;

public class WeatherDataServiceExceptionTests {
	@Test
	public void checkExceptionMessage() {
		WeatherDataServiceException ex = new WeatherDataServiceException(
				"something bad");
		assertEquals("something bad", ex.getMessage());
	}
}
