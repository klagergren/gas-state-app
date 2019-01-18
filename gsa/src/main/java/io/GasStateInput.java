package io;

public class GasStateInput {

	private String firstInputType;
	private Double firstInputValue;
	private String secondInputType;
	private Double secondInputValue;

	public GasStateInput() {

	}

	public GasStateInput(String firstInputType, Double firstInputValue, String secondInputType,
			Double secondInputValue) {

		this.firstInputType = firstInputType;
		this.firstInputValue = firstInputValue;
		this.secondInputType = secondInputType;
		this.secondInputValue = secondInputValue;
	}

	public String getFirstInputType() {
		return firstInputType;
	}

	public void setFirstInputType(String firstInputType) {
		this.firstInputType = firstInputType;
	}

	public Double getFirstInputValue() {
		return firstInputValue;
	}

	public void setFirstInputValue(Double firstInputValue) {
		this.firstInputValue = firstInputValue;
	}

	public String getSecondInputType() {
		return secondInputType;
	}

	public void setSecondInputType(String secondInputType) {
		this.secondInputType = secondInputType;
	}

	public Double getSecondInputValue() {
		return secondInputValue;
	}

	public void setSecondInputValue(Double secondInputValue) {
		this.secondInputValue = secondInputValue;
	}

}
