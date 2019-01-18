package egsc.gsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egsc.categories.GasProperty;
import egsc.conversion.GasStateOutputConverter;
import egsc.gasstate.GasState;
import egsc.gasstate.GasStateCalculator;
import egsc.io.GasStateInput;
import egsc.io.GasStateOutput;
import egsc.measurements.Density;
import egsc.measurements.Energy;
import egsc.measurements.Entropy;
import egsc.measurements.Pressure;
import egsc.measurements.Temperature;

@Service
public class GasStateCalculationService {

	@Autowired
	private GasStateOutputConverter outputConverter;

	@Autowired
	private GasStateCalculator calculator;

	public GasStateOutput calculateGasState(GasStateInput input) {
		GasProperty property1 = determineInputType(input.getFirstInputType());
		GasProperty property2 = determineInputType(input.getSecondInputType());

		GasState gasState = null;

		if (pressureAndTemperature(property1, property2)) {
			Pressure p;
			Temperature t;
			if (property1 == GasProperty.PRESSURE) {
				p = Pressure.fromPascals(input.getFirstInputValue());
				t = Temperature.fromKelvin(input.getSecondInputValue());
			} else {
				p = Pressure.fromPascals(input.getSecondInputValue());
				t = Temperature.fromKelvin(input.getFirstInputValue());
			}
			gasState = calculator.calculateGasState(p, t);

		} else if (pressureAndEntropy(property1, property2)) {
			Pressure p;
			Entropy s;
			if (property1 == GasProperty.PRESSURE) {
				p = Pressure.fromPascals(input.getFirstInputValue());
				s = Entropy.fromJoulesPerKelvin(input.getSecondInputValue());
			} else {
				p = Pressure.fromPascals(input.getSecondInputValue());
				s = Entropy.fromJoulesPerKelvin(input.getFirstInputValue());
			}
			gasState = calculator.calculateGasState(p, s);

		} else if (energyAndDensity(property1, property2)) {
			Energy e;
			Density d;
			if (property1 == GasProperty.ENERGY) {
				e = Energy.fromJoules(input.getFirstInputValue());
				d = Density.fromKgPerMeterCubed(input.getSecondInputValue());
			} else {
				e = Energy.fromJoules(input.getSecondInputValue());
				d = Density.fromKgPerMeterCubed(input.getFirstInputValue());
			}
			gasState = calculator.calculateGasState(e, d);
		} else if (pressureAndDensity(property1, property2)) {
			Pressure p;
			Density d;
			if (property1 == GasProperty.PRESSURE) {
				p = Pressure.fromPascals(input.getFirstInputValue());
				d = Density.fromKgPerMeterCubed(input.getSecondInputValue());
			} else {
				p = Pressure.fromPascals(input.getSecondInputValue());
				d = Density.fromKgPerMeterCubed(input.getFirstInputValue());
			}
			gasState = calculator.calculateGasState(p, d);
		} else if (entropyAndEnthalpy(property1, property2)) {
			Entropy s;
			Energy h;
			if (property1 == GasProperty.ENTROPY) {
				s = Entropy.fromJoulesPerKelvin(input.getFirstInputValue());
				h = Energy.fromJoules(input.getSecondInputValue());
			} else {
				s = Entropy.fromJoulesPerKelvin(input.getSecondInputValue());
				h = Energy.fromJoules(input.getFirstInputValue());
			}
			gasState = calculator.calculateGasState(s, h);

		}

		return outputConverter.convert(gasState);

	}

	protected boolean gasPropertyTest(GasProperty firstProperty, GasProperty secondProperty,
			GasProperty expectedProperty1, GasProperty expectedProperty2) {
		return (firstProperty == expectedProperty1 || firstProperty == expectedProperty2)
				&& (secondProperty == expectedProperty1 || secondProperty == expectedProperty2)
				&& (firstProperty != secondProperty);
	}

	private boolean pressureAndTemperature(GasProperty property1, GasProperty property2) {
		return gasPropertyTest(property1, property2, GasProperty.PRESSURE, GasProperty.TEMPERATURE);
	}

	private boolean pressureAndEntropy(GasProperty property1, GasProperty property2) {
		return gasPropertyTest(property1, property2, GasProperty.PRESSURE, GasProperty.ENTROPY);
	}

	private boolean energyAndDensity(GasProperty property1, GasProperty property2) {
		return gasPropertyTest(property1, property2, GasProperty.ENERGY, GasProperty.DENSITY);
	}

	private boolean pressureAndDensity(GasProperty property1, GasProperty property2) {
		return gasPropertyTest(property1, property2, GasProperty.PRESSURE, GasProperty.DENSITY);
	}

	private boolean entropyAndEnthalpy(GasProperty property1, GasProperty property2) {
		return gasPropertyTest(property1, property2, GasProperty.ENTROPY, GasProperty.ENTHALPY);
	}

	private GasProperty determineInputType(String inputName) {
		GasProperty property = GasProperty.valueOf(inputName);
		return property;
	}

}
