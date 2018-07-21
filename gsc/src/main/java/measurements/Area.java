package measurements;

public class Area {

	private final double areaInMetersSquared;

	private Area(double metersSquared) {
		this.areaInMetersSquared = metersSquared;
	}

	// Static builders
	public static Area fromMetersSquared(double metersSquared) {
		return new Area(metersSquared);
	}

	public static Area fromCentimetersSquared(double centimetersSquared) {
		return new Area(centimetersSquared / Distance.CENTIMETERS_PER_METER / Distance.CENTIMETERS_PER_METER);
	}
	
	//Utilities
	public double dividedBy(Area area) { 
		return areaInMetersSquared / area.areaInMetersSquared;
	}

	// Getters
	public double inMetersSquared() {
		return areaInMetersSquared;
	}

}
