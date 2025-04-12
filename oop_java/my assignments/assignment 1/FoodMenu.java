import java.util.Scanner;

public class FoodMenu {
	int dosa;
	int samosa;
	int idli;
	int pavBhaji;
	int sum;

	public FoodMenu() {
		this.dosa = 50;
		this.samosa = 10;
		this.idli = 40;
		this.pavBhaji = 60;
		this.sum = 0;
	}
		
	void displayMenu() {
			System.out.println("=========== Our Offerings ==========");
			System.out.println("| 1. Dosa = 50\n| 2. Samosa = 10\n| 3. Idli = 40\n| 4. PavBhaiji = 60");
			System.out.println("====================================");
	}
	void generateBill() {
		System.out.println("Your bill is > "+ sum);
	}
	
	void billing() {
		
		Scanner sc = new Scanner(System.in);
		while(!sc.equals("Generate Bill")) {
		System.out.println("Enter what you want (1/2/3/4), type 'Generate Bill' to get final amount:/nENTER here > ");
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			this.sum = this.sum+this.dosa;
			break;
		case "2":
			this.sum = this.sum+this.samosa;
			break;
		case "3":
			this.sum = this.sum+this.idli;
			break;
		case "4":
			this.sum = this.sum+this.dosa;
			break;
		case "Generate Bill":
			this.generateBill();
			break;
			
		default:
			break;
		}
		}
	}
	
	public static void main(String[] args) {
			FoodMenu customer = new FoodMenu();
			customer.displayMenu();
			customer.billing();
	}

}
