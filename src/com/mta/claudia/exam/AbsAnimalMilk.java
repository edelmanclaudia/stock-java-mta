package com.mta.claudia.exam;

public abstract class AbsAnimalMilk extends AbsAnimal{
	
	//members
	protected float milk;

	//c'tor
	public AbsAnimalMilk(String name,int age,float weight,float milk) {
		super(name,age,weight);
		this.milk = milk;
	}
	
	public AbsAnimalMilk(String name,int age,float weight,float milk,String farmName) {
		super(name,age,weight,farmName);
		this.milk = milk;
	}

	public AbsAnimalMilk() {
		super();
		// TODO Auto-generated constructor stub
	}

}
