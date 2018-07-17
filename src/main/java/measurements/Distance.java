package measurements;

public class Distance {
	
	public static final double CENTIMETERS_PER_METER = 100.0;

	private final double distanceInMeters;

	private Distance(double meters) {
		this.distanceInMeters = meters;
	}

	// Static builders
	public static Distance fromMeters(double meters) {
		return new Distance(meters);
	}
	
	// Utility methods

	// Getters
	public double inMeters() {
		return distanceInMeters;
	}

}
