package assignment7;

public class ExceptionLineTooLong extends Exception{

	private String invalidFiled;
	private int invalidValue;
	public ExceptionLineTooLong(String invalidFiled, int invalidValue) {
		super();
		this.invalidFiled = invalidFiled;
		this.invalidValue = invalidValue;
	}
	public String getInvalidFiled() {
		return invalidFiled;
	}
	public void setInvalidFiled(String invalidFiled) {
		this.invalidFiled = invalidFiled;
	}
	public int getInvalidValue() {
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
