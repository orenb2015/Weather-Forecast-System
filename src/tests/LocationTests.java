import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.Location;

public class LocationTests {

	@Test
	public void checkSetAndGet() throws Exception {
		Location loc = new Location("555");
		assertEquals("555", loc.getId());
	}
}
