package com.sunbeam;
interface A{
	void f1( ); 
	void f3( ); 
}
interface B{
	void f2( ); 
	void f3( ); 
}	
//Multiple Interface Implementation Inheritance => OK
class C implements A,B{

	@Override
	public void f2() {
		System.out.println("C.f2()");
	}

	@Override
	public void f1() {
		System.out.println("C.f1()");
	}

	@Override
	public void f3() {
		System.out.println("C.f3()");
	}
	
}
public class Program {

	public static void main(String[] args) {
		A a = new C(); // polymorphic declaration  
		a.f1();
		a.f3();
		
		B b = new C(); 
		b.f2();
		b.f3(); 

	}

}
