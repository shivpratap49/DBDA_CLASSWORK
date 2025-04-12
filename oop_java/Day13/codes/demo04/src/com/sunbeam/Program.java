package com.sunbeam;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		writeMovies( ); 

	}

	private static void writeMovies() {
		List<Movie> list = new ArrayList<>();
		list.add(new Movie(1, "Star Wars", 7.5));
		list.add(new Movie(2, "Godfather", 8.0));
		list.add(new Movie(3, "Hidden Figures", 7.0));
		list.add(new Movie(4, "Bruce Almighty", 6.5));
		list.add(new Movie(5, "Forest Gump", 8.5));
		
		try(FileOutputStream fout = new FileOutputStream("Movies.txt")){
			try(PrintStream pout = new PrintStream(fout)){
				for (Movie m : list) {
					pout.printf("%-18d%-20s%.1f\n",m.getId(),m.getTitle(),m.getRating()); 
				}
			}
			System.out.println("Movies saved..");
		}//fout.close(); 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
