package measurements;

public class Entropy {

	private final double entropyInJoulesPerKelvin;
	
	private Entropy(double joulesPerKelvin) { 
		this.entropyInJoulesPerKelvin = joulesPerKelvin;
	}
	
	public static Entropy fromJoulesPerKelvin(double joulesPerKelvin) { 
		return new Entropy(joulesPerKelvin);
	}
	
	
	@Override
	public String toString() { 
		return entropyInJoulesPerKelvin + " j/K";
	}
	
	public double inJoulesPerKelvin() { 
		return entropyInJoulesPerKelvin;
	}
}
