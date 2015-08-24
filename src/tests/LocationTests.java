import static org.junit.Assert.*;

import org.junit.Test;

import finaljavaproject.Location;


public class LocationTests {

	@Test
	public void test1() throws Exception {
		Location loc = new Location(555);
		assertEquals(555, loc.getId());
	}
}
