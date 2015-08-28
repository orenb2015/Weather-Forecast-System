import static org.junit.Assert.*;

import org.junit.Test;

import weather.WeatherDataServiceException;

public class WeatherDataServiceExceptionTests {

	@Test(expected = WeatherDataServiceException.class)
	public void validException() throws WeatherDataServiceException {
		throw new WeatherDataServiceException("something bad");
	}

	@Test
	public void checkExceptionMessage() {
		WeatherDataServiceException ex = new WeatherDataServiceException(
				"something bad");
		assertEquals("something bad", ex.getMessage());
	}
}
