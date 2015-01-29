package com.mta.claudia.exam;

public abstract class AbsAnimalMilk extends AbsAnimal{
	
	protected float milk;

	public float getMilk(){
		return this.milk;
	}
	
	public void setMilk(float milk){
		this.milk = milk;
	}
	
	public AbsAnimalMilk(String name,int age,float weight,float milk) {
		super(name,age,weight);
		this.milk = milk;
	}
}
