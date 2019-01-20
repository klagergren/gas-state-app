package categories;

public enum GasProperty {
	// @formatter:off
	TEMPERATURE("Temperature"),
	PRESSURE("Pressure"),
	DENSITY("Density"),
	ENTROPY("Entropy"),
	ENTHALPY("Enthalpy"),
	SPEED("Speed"),
	ENERGY("Energy"),
	MACH_NUMBER("Mach Number"),
	OTHER("Other");
	// @formatter:on
	
	private String name;
	
	private GasProperty(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
}
