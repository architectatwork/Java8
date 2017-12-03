package com.desibuds.java8.features;


interface Ii{
	default void printMe() {
		System.out.println("Print I");
	}
}

interface Ji{
	default void printMe() {
		System.out.println("Print J");
	}
}

/**
 * 
 * @author shobansriram
 *You get the following compilation error if you try to overwrite methods in object
 *
 *A default method cannot override a method from java.lang.Object 
 *
 *<pre>
 *interface Ki{
 *	default void hashCode() {
 *		System.out.println("Print J");
 *	}
 *}
 *</pre>
 *
 */

class Cc{
	public void printMe() {
		System.out.println("Print K");
	}
}	 

/**
 * Main class to test Interfaces in Java 8
 * 
 * 
 * @author shobansriram
 *
 */
public class TestInterfaces {

	
	public static void main(String args[]) {
	
	/**
	 * @author shoban sriram
	 * 	Scenario 1: Class A extends K and implements I or J or I and J
	 * 	Priority is for class method
	 * 
	 */
	class A extends Cc implements Ii{
		public void printMe() {
			super.printMe();
		}
	}
	A a = new A();
	a.printMe();
	
	
	/**
	 * @author shoban sriram
	 * Scenario 2: Class B implements I and J
	 * 
	 * Because both the interfaces have default showMe() method you need to override method and specify which method 
	 * you want to use
	 * 
	 */
	
	class B implements Ii,Ji{

		@Override
		public void printMe() {
			// TODO Auto-generated method stub
			Ii.super.printMe();
		}
		
	}
	B b = new B();
	b.printMe();
	
	
	}	
}
