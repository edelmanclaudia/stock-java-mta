package com.mta.claudia.exam;

public class Hen extends AbsAnimal{
	
	protected int numOfEggs;
	
	public Hen(String name,int age,float weight,int numOfEggs) {
		super(name,age,weight);
		this.numOfEggs = numOfEggs;
	}
	
	public Hen(String name,int age,float weight,int numOfEggs,String farmName) {
		super(name,age,weight,farmName);
		this.numOfEggs = numOfEggs;
	}
	
	public void walk(){
		System.out.println("Hen Walks");
	}
	
	public void eat(){
		System.out.println("Hen Eats");
	}

	@Override
	public void f() {
		// TODO Auto-generated method stub
		
	}

}
