package gasstate;

import measurements.Density;
import measurements.Energy;
import measurements.Entropy;
import measurements.Pressure;
import measurements.Speed;
import measurements.Temperature;
import gasstate.GasStateEqairCalculator;

public class GasState {

	private Temperature temperature;
	private Energy internalEnergy;
	private Energy enthalpy;
	private Speed soundSpeed;
	private Density fluidDensity;
	private Pressure fluidPressure;
	private Entropy fluidEntropy;
	
	
	public GasState(GasStateEqairCalculator eqairCalculator) { 
		this.temperature = Temperature.fromKelvin(eqairCalculator.t);
		this.internalEnergy = Energy.fromJoules(eqairCalculator.e);
		this.enthalpy = Energy.fromJoules(eqairCalculator.h);
		this.soundSpeed = Speed.fromMetersPerSecond(eqairCalculator.a);
		this.fluidDensity = Density.fromKgPerMeterCubed(eqairCalculator.r);
		this.fluidPressure = Pressure.fromPascals(eqairCalculator.p);
		this.fluidEntropy = Entropy.fromJoulesPerKelvin(eqairCalculator.s);
	}

	// Getters and setters
	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Energy getInternalEnergy() {
		return internalEnergy;
	}

	public void setInternalEnergy(Energy internalEnergy) {
		this.internalEnergy = internalEnergy;
	}

	public Energy getEnthalpy() {
		return enthalpy;
	}

	public void setEnthalpy(Energy enthalpy) {
		this.enthalpy = enthalpy;
	}

	public Speed getSoundSpeed() {
		return soundSpeed;
	}

	public void setSoundSpeed(Speed soundSpeed) {
		this.soundSpeed = soundSpeed;
	}

	public Density getFluidDensity() {
		return fluidDensity;
	}

	public void setFluidDensity(Density fluidDensity) {
		this.fluidDensity = fluidDensity;
	}

	public Pressure getFluidPressure() {
		return fluidPressure;
	}

	public void setFluidPressure(Pressure fluidPressure) {
		this.fluidPressure = fluidPressure;
	}

	public Entropy getFluidEntropy() {
		return fluidEntropy;
	}

	public void setFluidEntropy(Entropy fluidEntropy) {
		this.fluidEntropy = fluidEntropy;
	}

}
