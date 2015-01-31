package com.mta.claudia.exam;
//animal abstract to mange the memebers of the animals
public abstract class AbsAnimal implements Animal{
	
	//members
	protected String name;
	protected int age;
	protected float weight;
	
	//ctor 
	public AbsAnimal(String name,int age,float weight){
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
}
