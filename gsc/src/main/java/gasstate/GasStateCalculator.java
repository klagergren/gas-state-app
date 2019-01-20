package gasstate;

import measurements.Density;
import measurements.Energy;
import measurements.Entropy;
import measurements.Pressure;
import measurements.Temperature;

public class GasStateCalculator {
	
	
	public GasState calculateGasState(Pressure pressure, Temperature temperature) { 
		GasStateEqairCalculator eqairCalculator = new GasStateEqairCalculator();
		eqairCalculator.p = pressure.inPascals();
		eqairCalculator.t = temperature.inKelvin();
		eqairCalculator.error = false;
		eqairCalculator.r_pt();
		eqairCalculator.h_pr();
		eqairCalculator.e = eqairCalculator.h - eqairCalculator.p / eqairCalculator.r;
		eqairCalculator.s_re();
		eqairCalculator.a_ps();
		
		GasState gasState = new GasState(eqairCalculator);
		return gasState;
	}
	
//	public GasState calculateGasState(Temperature temperature, Pressure pressure)
//	{
//		return calculateGasState(pressure, temperature);
//	}
	
	public GasState calculateGasState(Pressure pressure, Entropy entropy) { 
		GasStateEqairCalculator eqairCalculator = new GasStateEqairCalculator();
		eqairCalculator.p = pressure.inPascals();
		eqairCalculator.s = entropy.inJoulesPerKelvin();
		eqairCalculator.error = false;
		
		eqairCalculator.r_ps();
		eqairCalculator.e_ps();
		eqairCalculator.a_ps();
		eqairCalculator.h = eqairCalculator.e + eqairCalculator.p/eqairCalculator.r;
		eqairCalculator.t_pr();
		GasState gasState = new GasState(eqairCalculator);
		return gasState;
	}
	
//	public GasState calculateGasState(Entropy entropy, Pressure pressure)
//	{
//		return calculateGasState(pressure, entropy);
//	}
	
	public GasState calculateGasState(Energy energy, Density density) { 
		GasStateEqairCalculator eqairCalculator = new GasStateEqairCalculator();
		eqairCalculator.e=energy.inJoules();
		eqairCalculator.r = density.inKgPerMeterCubed();
		eqairCalculator.error = false;
		
		eqairCalculator.s_re();
		eqairCalculator.pa_er(0);
		eqairCalculator.a_ps();
		eqairCalculator.h = eqairCalculator.e + eqairCalculator.p/eqairCalculator.r;
		eqairCalculator.t_pr();
		
		GasState gasState = new GasState(eqairCalculator);
		return gasState;
	}
	
//	public GasState calculateGasState(Density density, Energy energy)
//	{
//		return calculateGasState(energy, density);
//	}
	
	public GasState calculateGasState(Pressure pressure, Density density) { 
		GasStateEqairCalculator eqairCalculator = new GasStateEqairCalculator();
		eqairCalculator.p = pressure.inPascals();
		eqairCalculator.r = density.inKgPerMeterCubed();
		eqairCalculator.error = false;
		
		eqairCalculator.h_pr();
		eqairCalculator.t_pr();
		eqairCalculator.e = eqairCalculator.h - eqairCalculator.p/eqairCalculator.r;
		eqairCalculator.s_re();
		eqairCalculator.a_ps();
		
		GasState gasState = new GasState(eqairCalculator);
		return gasState;
	}
	
//	public GasState calculateGasState(Density density, Pressure pressure)
//	{
//		return calculateGasState(pressure, density);
//	}
//	
	public GasState calculateGasState(Entropy entropy, Energy enthalpy) { 
		GasStateEqairCalculator eqairCalculator = new GasStateEqairCalculator();
		eqairCalculator.s = entropy.inJoulesPerKelvin();
		eqairCalculator.h = enthalpy.inJoules();
		eqairCalculator.error = false;
		
		eqairCalculator.per_hs();
		eqairCalculator.a_ps();
		eqairCalculator.t_pr();
		
		GasState gasState = new GasState(eqairCalculator);
		return gasState;
	}
	
//	public GasState calculateGasState(Energy enthalpy, Entropy entropy)
//	{
//		return calculateGasState(entropy, enthalpy);
//	}

}
