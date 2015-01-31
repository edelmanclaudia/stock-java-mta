package com.mta.claudia.exam;

public class Farm {

	private static float sum;

	public final static int SIZE = 5;
	//public enum Animal1{cow,sheep,dog,hen};
	
	static AbsAnimal[] animalArray = new AbsAnimal[SIZE];

	
	
	public static void Farm(){
		//animalArray = new AbsAnimal[SIZE];
		animalArray[0] = new Cow("milka",2,2,2);
		animalArray[1] = new Dog ("jo",2,2);
		animalArray[2] = new Hen ("kity",2,2,2);
		animalArray[3] = new Sheep ("doly",2,2,2);
		animalArray[4] = new Cow("loly",2,2,2);

	}

	public static  void fuck(){
		Farm();
		
		for(int i = 0; i < SIZE; i++)
		{
			System.out.println("Name: " + animalArray[i].getName() + " ,Age" + animalArray[i].getAge());
			
			animalArray[i].walk();
			
			if(animalArray[i] instanceof AbsAnimalMilk)
			//if((Animal1.cow) || (Animal1.sheep))
			{
				sum += ((AbsAnimalMilk) animalArray[i]).getMilk();
				System.out.println("Total farm milk capacity is " + (int)sum + " letters");
			}
		}
	}
	
	public static void main (String []args)
	{		
		fuck();
		
		((Hen)animalArray[2]).getNumOfEggs();
		
		//Hen abs = new AbsAnimal("h",2,2,2);  
				
		
		
		System.out.println("yes i can fuck " + animalArray[0].getName());
	}
}

