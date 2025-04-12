package com.sunbeam;

abstract class A{
	public final void f1() {	//Logically 100% complete
		System.out.println("A.f1");
	}
	public void f2( ) {//Logically partial complete
		System.out.println("A.f2");
	}
	public abstract void f3( );	//Logically 100% incomplete
		
}
class B extends A{
	public final void f2( ) {
		System.out.println("B.f2");
	}
	@Override
	public void f3() {
		System.out.println("B.f3");
	}
}
final class C extends B{
	@Override
	public final void f3() {
		System.out.println("C.f3");
	}
}
public class Program {
	public static void main(String[] args) {
		C c = new C( );
		c.f1();
		c.f2();
		c.f3();
	}
}

