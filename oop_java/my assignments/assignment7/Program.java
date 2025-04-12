package assignment7;

import java.util.Scanner;



public class Program {

	public static void main(String[] args) {
		System.out.println("init");
		try {
		StringMaker str = new StringMaker();
		str.setStr("asfkasjflks awesome , ahahahha wtf");
		System.out.println("All good");
		}
		catch (ExceptionLineTooLong e ){
			e.getMessage();
		}
	}

}
