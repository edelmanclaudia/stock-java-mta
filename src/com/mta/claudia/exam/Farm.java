package com.mta.claudia.exam;

public class Farm {

	public final static int SIZE = 5;

	private float sum;

	static AbsAnimal[] animalArray = new AbsAnimal[SIZE];

	public static void createAnArrayOfAnimal(){
 
		animalArray[0] = new Cow("milka",2,2,2);
		animalArray[1] = new Dog ("jo",2,2);
		animalArray[2] = new Hen ("kity",2,2,2,"c");
		animalArray[3] = new Sheep ("doly",2,2,2);
		//animalArray[4] = new Cow("loly",2,2,2,"Clauds farm");
		animalArray[4] = new Hen((Hen) animalArray[2]);
		animalArray[0].renameFarmName("New f clauds");
		animalArray[4].name = "chen";
		
		print(animalArray);

	}

	@SuppressWarnings("static-access")
	public static  void print(AbsAnimal []animalArray){
		for(int i = 0; i < SIZE; i++)
		{
			System.out.println("Name: " + animalArray[i].name + " ,Age: " + animalArray[i].age + " ,FarmName: " + animalArray[i].farmName);

			animalArray[i].walk();
		}
	}

	public void sumOfMilk(AbsAnimal []animalArray){	
		for(int i = 0; i < SIZE; i++)
		{
			if(animalArray[i] instanceof AbsAnimalMilk){
				sum += ((AbsAnimalMilk) animalArray[i]).milk;
				System.out.println("Total farm milk capacity is " + (int)sum + " letters");
			}
		}
	}

	public static void main (String []args){		
		createAnArrayOfAnimal();
	}
}