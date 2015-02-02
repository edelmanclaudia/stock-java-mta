package com.mta.claudia.exam;
//animal abstract to mange the memebers of the animals
public abstract class AbsAnimal implements Animal{

	//members
	protected static String farmName;
	protected String name;
	protected int age;
	protected float weight;

	public void renameFarmName(String newName) {
		this.farmName = newName;
	}
	
	public abstract void f();

	//ctor 
	public AbsAnimal(String name,int age,float weight,String farmName){
		AbsAnimal.farmName = farmName;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	//ctor 
	public AbsAnimal(String name,int age,float weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	public AbsAnimal() {
		
	}
}
