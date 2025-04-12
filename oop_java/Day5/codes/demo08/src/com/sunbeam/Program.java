package com.sunbeam;
interface Printable{ //ISI 
	/*public static final*/int num = 10;  
	/*public abstract*/void print( ); 
}
//Interface Implementation Inheritance 
class Test implements Printable{ // Service provider

	@Override
	public void print() {
		System.out.println("num : "+Printable.num);
	}
	
}
public  class Program {
	
	//service consumer
	public static void main(String[] args) {
		Printable p = new Test(); //polymorphic declaration   
		p.print();

	}

}
