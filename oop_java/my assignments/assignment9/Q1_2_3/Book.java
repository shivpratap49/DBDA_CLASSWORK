package assignment9.Q1_2_3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

enum Category{
	ADVENTURE,
	FUN,
	LOVE
}

public class Book {
	
	String isbn;
	String cat;
	double price;
	Date publishDate;
	String authorName;
	int quantity;
	
	
	

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", cat=" + cat + ", price=" + price + ", publishDate=" + publishDate
				+ ", authorName=" + authorName + ", quantity=" + quantity + "]";
	}



	public Book(String isbn, String cat, double price,  String authorName, int quantity) {
		
		this.isbn = isbn;
		this.cat = cat;
		this.price = price;
		this.publishDate = new Date();
		this.authorName = authorName;
		this.quantity = quantity;
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String isbn;
		String cat;
		double price;
		String authorName;
		int quantity;
		
		HashSet<Book> books = new HashSet<>();
		
		
		System.out.println("-------------------");
			int i=0;
			while(i<2) {
				System.out.print("Enter Book ["+(i+1)+"] isbn -> ");
				isbn = sc.next();
				System.out.print("Categories :- ");
				for (Category ele: Category.values()) {
					System.out.print(ele+" / ");
				}
				
				System.out.println();
				System.out.print("Enter Book ["+(i+1)+"] category -> ");
				cat = sc.next();
				
				System.out.print("Enter Book ["+(i+1)+"] Price -> ");
				price = sc.nextDouble();
				

				System.out.print("Enter Book ["+(i+1)+"] Author Name -> ");
				authorName = sc.next();

				System.out.print("Enter Book ["+(i+1)+"] Quantity -> ");
				quantity = sc.nextInt();
				
				books.add(new Book(isbn, cat, price, authorName, quantity));
				
				System.out.println("Element added.");
				System.out.println("-------------------");
				i++;
			}
			
			System.out.println("Books details in HastSet.");
			books.forEach(e->System.out.println(e));
			
			System.out.println();
			

			System.out.println("Books details in LinkedHastSet.");
			LinkedHashSet<Book> linkedBook = new LinkedHashSet<>(books);
			linkedBook.forEach(e->System.out.println(e));
			
			
			System.out.println("----Sorting by publish date----");
			
	        ArrayList<Book> bookList = new ArrayList<>(linkedBook);

	        bookList.sort(new PublishComparator());
	        
	        System.out.println("\nBooks sorted by Publish Date:");
	        for (Book book : bookList) {
	            System.out.println(book);
	        }
			
		
	}

	static class PublishComparator implements Comparator<Book> {
	    @Override
	    public int compare(Book b1, Book b2) {
	        return b1.publishDate.compareTo(b2.publishDate);
	    }
	}
	

}
