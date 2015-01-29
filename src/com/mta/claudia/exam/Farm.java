package com.mta.claudia.exam;

public class Farm {

	private float sum = 0;

	public final static int SIZE = 5;

	AbsAnimal[] animalArray = new AbsAnimal[SIZE];

	//animalArray[0] = new Cow("milka",2,2,2);
	//animalArray[1] = new Dog ("jo",2,2);
	//animalArray[2] = new Hen ("kity",2,2,2);
	//animalArray[3] = new Sheep ("doly",2,2,2);
	//animalArray[4] = new Cow("loly",2,2,2);

}
/*
	for(int i = 0; i < SIZE; i++)
	{
		System.out.println("Name: " + getName(animalArray[i].name) + " ,Age" + getAge(animalArray[i].age));
		walk();

		if(animalArray[i] instanceof AbsAnimalMilk || animalArray[i] instanceof AbsAnimalMilk)
		{
			sum = sum + getMilk();
			system.out.println("Total farm milk capacity is " + (int)sum + "letters");
		}
	}
 */

