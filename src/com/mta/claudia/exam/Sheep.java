package com.mta.claudia.exam;

public class Sheep extends AbsAnimalMilk{

	//c'tor
	public Sheep(String name,int age,float weight,float milk) {
		super(name,age,weight,milk);
	}
	
	//c'tor
	public Sheep(String name,int age,float weight,float milk,String farmName) {
		super(name,age,weight,milk,farmName);
	}
	
	public void walk(){
		System.out.println("Sheep Walks");
	}
	
	public void eat(){
		System.out.println("Sheep Eats");
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

}
