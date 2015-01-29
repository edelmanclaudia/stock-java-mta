package com.mta.claudia.exam;

public class Dog extends AbsAnimal {

	public Dog(String name,int age,float weight) {
		super(name,age,weight);
	}
	
	public void walk(){
		System.out.println("Dog Walks");
	}
	
	public void eat(){
		System.out.println("Dog Eats");
	}
}
