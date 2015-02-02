package com.mta.claudia.exam;

public class Zona extends Song{

	public Zona(String model) {
		super(model);
		this.model = "";
	}
	
	private int cargoMax;
	
	public int getCargoMax(){
		return cargoMax;
	}
	
	public static void main(String[] args) {
		Base b1 = new Base(7.6);
		Base b2 = new Derived1(5.2, 'a');
		Base b3 = new Derived2(9.8, 3);
		
		b1.foo();
		b2.foo();
		b3.foo();
		
		System.out.println("is"+5+4);
		System.out.println(5+4);
		System.out.println(5+4+"to");
		System.out.println(+5+4);

		
	}

}
