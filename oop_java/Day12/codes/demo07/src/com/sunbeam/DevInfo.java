package com.sunbeam;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.CONSTRUCTOR})
public @interface DevInfo {
	String value( );  // default attribute 
	String company( ) default "Sunbeam Info";  
	String designation( ) default "Sw Dev"; 
}
