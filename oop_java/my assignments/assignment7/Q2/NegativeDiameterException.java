package assignment7.Q2;

public class NegativeDiameterException extends Exception{

	private String invalidFiled;
	private double invalidValue;
	public NegativeDiameterException(String invalidFiled, double myDiameter) {
		this.invalidFiled = invalidFiled;
		this.invalidValue = myDiameter;
	}
	public String getInvalidFiled() {
		return invalidFiled;
	}
	public void setInvalidFiled(String invalidFiled) {
		this.invalidFiled = invalidFiled;
	}
	public double getInvalidValue() {
		return invalidValue;
	}
	public void setInvalidValue(int invalidValue) {
		this.invalidValue = invalidValue;
	}
	

	
	@Override
	public String toString() {
		return "InvalidTimeException [invalidFiled=" + invalidFiled + ", invalidValue=" + invalidValue + "]";
	}
	
	
}
