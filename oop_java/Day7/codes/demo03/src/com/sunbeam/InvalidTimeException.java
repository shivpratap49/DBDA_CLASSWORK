package com.sunbeam;

public class InvalidTimeException extends Exception {
	private String invalidField;
	private int invalidValue;
	public InvalidTimeException(String invalidField, int invalidValue) {
		this.invalidField = invalidField;
		this.invalidValue = invalidValue;
	}
	public String getInvalidField() {
		return invalidField;
	}
	public void setInvalidField(String invalidField) {
		this.invalidField = invalidField;
	}
	public int getInvalidValue() {
		return invalidValue;
	}
	public void setInvalidValue(int invalidValue) {
		this.invalidValue = invalidValue;
	}
	
	@Override
	public String getMessage() {
		return String.format("Invalid %s = %d", invalidField, invalidValue);
	}
	
	@Override
	public String toString() {
		return "InvalidTimeException [invalidField=" + invalidField + ", invalidValue=" + invalidValue + "]";
	}
}
