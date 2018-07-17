package measurements;

import org.junit.Test;

import testutils.BasicTest;

public class SpeedTest extends BasicTest {

	@Test
	public void testMinus() {
		Speed v1 = Speed.fromMetersPerSecond(5.0);
		Speed v2 = Speed.fromMetersPerSecond(3.0);
		
		Speed difference = v1.minus(v2);
		Speed expected = Speed.fromMetersPerSecond(2.0);
		
		assertDoublesEqual(expected.inMetersPerSecond(), difference.inMetersPerSecond());
	}

}
