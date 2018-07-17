package measurements;

public class Density {
	
	private final double densityInKgPerMetersCubed;
	
	private Density( double kgPerMetersCubed) { 
		this.densityInKgPerMetersCubed = kgPerMetersCubed;
	}
	
	public static Density fromKgPerMeterCubed(double kgPerMeterCubed) { 
		return new Density(kgPerMeterCubed);
	}
	
	@Override
	public String toString() { 
		return densityInKgPerMetersCubed + " kg/m^3";
	}
	
	public double inKgPerMeterCubed() { 
		return densityInKgPerMetersCubed;
	}
	
	public Density times(Number factor) { 
		return new Density(factor.doubleValue() * densityInKgPerMetersCubed);
	}
}
