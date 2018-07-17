package measurements;

public class Energy {

	private final double energyInJoules;

	// Private Constructor
	private Energy(double energyInJoules) {
		this.energyInJoules = energyInJoules;
	}

	public static Energy fromJoules(double joules) {
		return new Energy(joules);
	}
	
	@Override
	public String toString() { 
		return energyInJoules + " joules";
	}

	public double inJoules() {
		return energyInJoules;
	}

}
