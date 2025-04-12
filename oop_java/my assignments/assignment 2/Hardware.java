package assginment2;
import java.util.Scanner;

class Invoice {
	private String partNumber;
	private String partDiscription;
	private int quantityPurchased;
	private double pricePerItem;
	
	public Invoice() {
		this.partNumber = "";
		this.partDiscription = "";
		this.quantityPurchased = 0;
		this.pricePerItem = 0;
	}
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {

		this.partNumber = partNumber;
	}
	public String getPartDiscription() {
		return partDiscription;
	}
	public void setPartDiscription(String partDiscription) {
		this.partDiscription = partDiscription;
	}
	public int getQuantityPurchased() {
		return quantityPurchased;
	}
	public void setQuantityPurchased(int quantityPurchased) {
		if (quantityPurchased < 0)
		this.quantityPurchased = 0;
		else
			this.quantityPurchased = quantityPurchased;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
	if(this.pricePerItem<0)
		this.pricePerItem = 0.0;
	else
		this.pricePerItem = pricePerItem;
	}
	
	void invoiceTest(){
		System.out.println("\n============= Invoice for Part number - "+getPartNumber()+" ============");
		System.out.println("Part Number :"+ getPartNumber());

		System.out.println("Part Discription  : "+ getPartDiscription());

		System.out.println("Quantity Purchased : "+ getQuantityPurchased());

		System.out.println("Price PerItem : "+ getPricePerItem());
		
		System.out.println("---------------------------------------------------");
		System.out.println("Total amount = "  + (this.quantityPurchased*getPricePerItem()));
		System.out.println("---------------------------------------------------\n");
		

	}
}

public class Hardware {
	
	static void objectCreation(int i,Invoice[] arr,Scanner  sc) {
		arr[i] = new Invoice();
		
		System.out.println("----------------- Enter Details  ---------------");
		System.out.print("Enter Part Number: ");
		String partnum = sc.next();
		arr[i].setPartNumber(partnum);
		
		System.out.print("Enter Part Discription: ");
		String partDiscription = sc.next();
		arr[i].setPartDiscription(partDiscription);
		
		System.out.print("Enter Quantity: ");
		int quantity = sc.nextInt();
		arr[i].setQuantityPurchased(quantity);

		System.out.print("Enter Price for this item: ");
		double pricePerItem = sc.nextDouble();
		arr[i].setPricePerItem(pricePerItem);
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of Items you want to buy: ");
		int numberOfProducsts = sc.nextInt();
		
		Invoice[] arr = new Invoice[numberOfProducsts];
		
		int i=0;
		int n = arr.length;
		
		
		while(n>0) {
		objectCreation(i,arr,sc);
		i++;
		n--;
		}
		
		
		// printing invoice 
		i=0;
		n=arr.length;
		while (n>0) {
			
			arr[i].invoiceTest();
			i++;
			n--;
			
		}
		System.out.println("==================================================");
		
	}

}
