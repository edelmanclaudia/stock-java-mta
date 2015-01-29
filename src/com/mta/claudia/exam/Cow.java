package com.mta.claudia.exam;

public class Cow extends AbsAnimalMilk{

	public Cow(String name,int age,float weight,float milk) {
		super(name,age,weight,milk);
	}

	public void walk(){
		System.out.println("Cow Walks");
	}
	
	public void eat(){
		System.out.println("Cow Eats");
	}
}
