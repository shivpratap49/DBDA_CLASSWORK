package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

@Deprecated
class OldClass{
	//version ---v1.0 
	@Deprecated
	public void oldMethod() {
		
	}
	//version ---v2.0
	public void newMethod() {
		
	}
}

public class Program {
	
	/* 
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings({ "unused", "rawtypes" })
		List list = new ArrayList(); 
		String str = "Hello"; 

	}
	*/
	public static void main(String[] args) {
		OldClass obj = new OldClass(); 
		obj.oldMethod();
	}

}
