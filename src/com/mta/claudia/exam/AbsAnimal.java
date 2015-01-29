package com.mta.claudia.exam;
//animal abstract to mange the memebers of the animals
public abstract class AbsAnimal implements Animal{
	
	//members
	protected String name;
	protected int age;
	protected float weight;
	
	//getters
	public String getName(){
		return this.name;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public float getWeight(){
		return this.weight;
	}
	
	//setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public void setWeight(float weight){
		this.weight = weight;
	}
	/*	
	public AbsAnimal(){
		this.name = " ";
		this.age = 0;
		this.weight = 0;
	}*/

	public AbsAnimal(String name,int age,float weight){
		this.setName(name);
		this.setAge(age);
		this.setWeight(weight);
	}
	
	/*public AbsAnimal(AbsAnimal a){
		setName(a.name);
		setAge(a.age);
		setWeight(a.weight);
	}*/
	

}
