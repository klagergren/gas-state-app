package measurements;

public class Temperature {
	
	private static final double KELVIN_CELSIUS_OFFSET = 273;

	private final double temperatureInKelvin;

	// private constructor
	private Temperature(double kelvin) {
		this.temperatureInKelvin = kelvin;
	}

	public static Temperature fromKelvin(double kelvin) {
		return new Temperature(kelvin);
	}
	
	public static Temperature fromCelsius(double celsius) { 
		double kelvin = celsius +  KELVIN_CELSIUS_OFFSET;
		return new Temperature(kelvin);
	}
	
	public Temperature times(double factor) { 
		return new Temperature(temperatureInKelvin*factor);
	}
	
	public double dividedBy(Temperature temp2) { 
		return temperatureInKelvin / temp2.temperatureInKelvin;
	}
	
	@Override
	public String toString() { 
		return temperatureInKelvin + " K";
	}

	public double inKelvin() {
		return temperatureInKelvin;
	}
	
	public double inCelsius() { 
		return temperatureInKelvin + KELVIN_CELSIUS_OFFSET;
	}

}
