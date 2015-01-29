package com.mta.claudia.exam;

public class Hen extends AbsAnimal{
	
	protected int numOfEggs;
	
	public int getNumOfEggs(){
		return this.numOfEggs;
	}
	
	public void setNumOfEggs(int num){
		this.numOfEggs = num;
	}
	
	public Hen(String name,int age,float weight,int getNumOfEggs) {
		super(name,age,weight);
		this.numOfEggs = getNumOfEggs;
	}
	
	public void walk(){
		System.out.println("Hen Walks");
	}
	
	public void eat(){
		System.out.println("Hen Eats");
	}

}
