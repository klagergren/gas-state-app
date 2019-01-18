package conversion;

import org.springframework.stereotype.Component;

import gasstate.GasState;
import io.GasStateOutput;

@Component
public class GasStateOutputConverter {
	
	public GasStateOutput convert(GasState gasState) 
	{
		GasStateOutput output = new GasStateOutput();
		output.setDensity(gasState.getFluidDensity().inKgPerMeterCubed());
		output.setEnthalpy(gasState.getEnthalpy().inJoules());
		output.setEntropy(gasState.getFluidEntropy().inJoulesPerKelvin());
		output.setInternalEnergy(gasState.getInternalEnergy().inJoules());
		output.setPressure(gasState.getFluidPressure().inPascals());
		output.setSoundSpeed(gasState.getSoundSpeed().inMetersPerSecond());
		output.setTemperature(gasState.getTemperature().inKelvin());
		
		return output;
	}
}
