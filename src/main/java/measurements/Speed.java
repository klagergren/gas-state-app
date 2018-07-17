package measurements;

public class Speed {

	private final double speedInMetersPerSecond;

	// private constructor
	private Speed(double metersPerSecond) {
		this.speedInMetersPerSecond = metersPerSecond;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Speed) {
			Speed speed2 = (Speed) obj;
			return Math.abs(speedInMetersPerSecond - speed2.speedInMetersPerSecond) < 1E-6;
		}
		return false;
	}

	public static Speed fromMetersPerSecond(double metersPerSecond) {
		return new Speed(metersPerSecond);
	}

	public Speed times(Number factor) {
		return new Speed(speedInMetersPerSecond * factor.doubleValue());
	}

	public Speed minus(Speed other) {
		return Speed.fromMetersPerSecond(speedInMetersPerSecond - other.speedInMetersPerSecond);
	}

	public double dividedBy(Speed speed) {
		return speedInMetersPerSecond / speed.speedInMetersPerSecond;
	}

	@Override
	public String toString() {
		return speedInMetersPerSecond + " m/s";
	}

	public double inMetersPerSecond() {
		return speedInMetersPerSecond;
	}

}
