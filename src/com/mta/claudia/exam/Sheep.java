package com.mta.claudia.exam;

public class Sheep extends AbsAnimalMilk{
	
	public Sheep(String name,int age,float weight,float milk) {
		super(name,age,weight,milk);
	}

	public void walk(){
		System.out.println("Sheep Walks");
	}
	
	public void eat(){
		System.out.println("Sheep Eats");
	}

}
