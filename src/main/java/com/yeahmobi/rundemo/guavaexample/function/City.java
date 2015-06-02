package com.yeahmobi.rundemo.guavaexample.function;

public class City {
	private String name;
	private String zipCode;
	private int population;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public City(String name, String zipCode, int population) {
		super();
		this.name = name;
		this.zipCode = zipCode;
		this.population = population;
	}
	
}
