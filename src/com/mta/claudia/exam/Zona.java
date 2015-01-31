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
}
