package testutils;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gasstate.GasState;
import gasstate.GasStateCalculator;
import measurements.Density;
import measurements.Energy;
import measurements.Pressure;
import measurements.Temperature;

public class BasicTest {

	private final double tolerance = 1E-6;

	@Mock
	GasStateCalculator eqair;

	Energy energy;
	Density density;

	@Mock
	GasState gasState;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

		Mockito.when(eqair.calculateGasState(energy, density)).thenReturn(gasState);
	}

	protected void assertDoublesEqual(double expected, double calculated) {
		assertEquals(expected, calculated, tolerance);
	}

	@Test
	public void test1() {
		assertEquals(gasState, eqair.calculateGasState(energy, density));
	}
	
	@Test
	public void stupidTest() { 
		GasStateCalculator eqair2 = new GasStateCalculator();
		
		GasState state = eqair2.calculateGasState(Pressure.fromAtmospheres(1), Temperature.fromKelvin(273));
		Density density = state.getFluidDensity();
		double val = density.inKgPerMeterCubed();
		System.out.println(val);
		System.out.println(state.getSoundSpeed().inMetersPerSecond());
	}

}
