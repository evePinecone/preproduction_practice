package com.epam.preprod.roman_lutsenko.task1.entity;

public class Laptop extends Computer {
	double displayResolution;
	String autonomy;
	double weight;

	public Laptop() {
		super();
		displayResolution = -1;
		autonomy = "none";
		weight = -1;
	}

	public Laptop(String nameModel, String firm, double price, String nameProcessor, int rAM, String graphicsProcessor,
			double displayResolution, String autonomy, double weight) {
		super(nameModel, firm, price, nameProcessor, rAM, graphicsProcessor);
		this.displayResolution = displayResolution;
		this.autonomy = autonomy;
		this.weight = weight;
	}

	public double getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(double displayResolution) {
		this.displayResolution = displayResolution;
	}

	public String getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(String autonomy) {
		this.autonomy = autonomy;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Laptop [displayResolution=" + displayResolution + ", autonomy=" + autonomy + ", weight=" + weight
				+ ", nameProcessor=" + nameProcessor + ", RAM=" + RAM + ", graphicsProcessor=" + graphicsProcessor
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

	
}
