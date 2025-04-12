package assignment6.com.app.fruits;

public class Fruit {

	String color;
	double weight;
	String name;
	boolean isFresh;
	
	public Fruit() {
		this("",0,"");
	}
	
	public Fruit(String color, double weight, String name) {
		this.color = color;
		this.weight = weight;
		this.name = name;
		this.isFresh = true;
	}

	@Override
	public String toString() {
		return "Fruit [color=" + color + ", weight=" + weight + ", name=" + name + ", isFresh=" + isFresh + "]";
	}

	public String taste(String name) {
		if (this.name == "Apple")
				return "sweet n sour";
		else if (this.name == "Mango")
			return "sweet";
		else if (this.name == "Orange")
			return "sour";
		else
			return "no specific taste";
	}
	
	public static void main(String[] args) {
		

	}

}
