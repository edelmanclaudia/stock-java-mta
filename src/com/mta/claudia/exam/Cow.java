package com.mta.claudia.exam;

public final class Cow extends AbsAnimalMilk{

	public Cow(String name,int age,float weight,float milk) {
		super(name,age,weight,milk);
	}

	public Cow(String name,int age,float weight,float milk,String farmName) {
		super(name,age,weight,milk,farmName);
	}
	
	public Cow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void walk(){
		System.out.println("Cow Walks");
	}
	
	public void eat(){
		System.out.println("Cow Eats");
	}

	public void f() {
		// TODO Auto-generated method stub
		
	}
}
