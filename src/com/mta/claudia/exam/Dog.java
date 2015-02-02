package com.mta.claudia.exam;

public final class Dog extends AbsAnimal{

	public Dog(String name,int age,float weight) {
		super(name,age,weight);
	}
	
	public Dog(String name,int age,float weight,String farmName) {
		super(name,age,weight,farmName);
	}
	
	public void walk(){
		System.out.println("Dog Walks");
	}
	
	public void eat(){
		System.out.println("Dog Eats");
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}
}
