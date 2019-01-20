package measurements;

public class Angle {

	private static final double DEGREES_PER_RADIAN = 180.0 / Math.PI;

	private final double angleInRadians;

	private Angle(double radians) {
		this.angleInRadians = radians;
	}

	public static Angle fromRadians(double radians) {
		return new Angle(radians);
	}

	public static Angle fromDegrees(double degrees) {
		return new Angle(degrees / DEGREES_PER_RADIAN);
	}

	public double dividedBy(Angle angle2) {
		return angleInRadians / angle2.angleInRadians;
	}
	
	public Angle plus(Angle angle) { 
		return Angle.fromRadians(angleInRadians + angle.angleInRadians);
	}

	public boolean isLessThan(Angle otherAngle) {
		return angleInRadians < otherAngle.angleInRadians;
	}

	@Override
	public String toString() {
		return angleInRadians * DEGREES_PER_RADIAN + " degrees";
	}

	public double inRadians() {
		return angleInRadians;
	}

	public double inDegrees() {
		return angleInRadians * DEGREES_PER_RADIAN;
	}

}
