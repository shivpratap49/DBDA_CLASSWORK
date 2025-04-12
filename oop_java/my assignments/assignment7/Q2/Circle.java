package assignment7.Q2;


public class Circle {
	
	private double myX;
	private double myY;
	private double myDiameter;
	
	public Circle() {
		this(0,0,100);
	}
	
	public Circle(double myX, double myY, double myDiameter) {
		super();
		this.myX = myX;
		this.myY = myY;
		this.myDiameter = myDiameter;
	}

	public double getMyX() {
		return myX;
	}

	public void setMyX(double myX) {
		this.myX = myX;
	}

	public double getMyY() {
		return myY;
	}

	public void setMyY(double myY) {
		this.myY = myY;
	}

	public double getMyDiameter() {
		return myDiameter;
	}

	public void setMyDiameter(double myDiameter) throws NegativeDiameterException {
		if(myDiameter < 0)
			throw new NegativeDiameterException("Invalid Diameter",myDiameter);
		this.myDiameter = myDiameter;
	}

	public static void main(String[] args) {
			
	}

}
