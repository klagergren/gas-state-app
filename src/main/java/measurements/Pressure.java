package measurements;

public class Pressure {
	
	private static final double PASCALS_PER_PSI = 6894.76;
	private static final double PASCALS_PER_ATMOSPHERE = 101325;
	
	private final double pressureInPascals;
	
	private Pressure(double pascals) { 
		this.pressureInPascals = pascals;
	}
	
	public static Pressure fromPascals(double pascals) {
		return new Pressure(pascals);
	}
	
	public static Pressure fromPoundsPerSquareInch(double psi) { 
		return new Pressure(psi*PASCALS_PER_PSI);
	}
	
	public static Pressure fromAtmospheres(double atm) { 
		return new Pressure(atm * PASCALS_PER_ATMOSPHERE);
	}
	
	public Pressure times(double factor) { 
		return new Pressure(pressureInPascals * factor);
	}
	
	public double dividedBy(Pressure pressure2) { 
		return pressureInPascals / pressure2.pressureInPascals;
	}
	
	public boolean greaterThan(Pressure otherPressure) { 
		return otherPressure == null || pressureInPascals > otherPressure.pressureInPascals;
	}
	
	
	@Override
	public String toString() { 
		return pressureInPascals + " pascals";
	}
	
	public double inPascals() { 
		return pressureInPascals;
	}
	
	public double inAtmospheres() { 
		return pressureInPascals / PASCALS_PER_ATMOSPHERE;
	}

}
