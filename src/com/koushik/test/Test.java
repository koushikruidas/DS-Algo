package com.koushik.test;

public class Test { 
	 public static void main(String[] args) {
	   A a= new B();
//	   a.method2();
	 }
	}
	class A{
	 
	 public void method1()
	 {
	   System.out.println("Method1 in class A");
	 }
	}
	class B extends A{
	    public void method1()
	     {
	       System.out.println("Method1 in class B");
	     }
	    public void method2()
	     {
	       System.out.println("Method2 in class B");
	     }
	}