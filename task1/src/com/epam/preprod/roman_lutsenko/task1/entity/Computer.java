package com.epam.preprod.roman_lutsenko.task1.entity;

public class Computer extends Thing{
	String nameProcessor;
	int RAM;
	String graphicsProcessor;

	public Computer() {
		super();
		nameProcessor = "none";
		RAM = -1;
		graphicsProcessor = "none";
	}

	public Computer(String nameModel, String firm, double price, String nameProcessor, int rAM,
			String graphicsProcessor) {
		super(nameModel, firm, price);
		this.nameProcessor = nameProcessor;
		RAM = rAM;
		this.graphicsProcessor = graphicsProcessor;
	}

	public String getNameProcessor() {
		return nameProcessor;
	}

	public void setNameProcessor(String nameProcessor) {
		this.nameProcessor = nameProcessor;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public String getGraphicsProcessor() {
		return graphicsProcessor;
	}

	public void setGraphicsProcessor(String graphicsProcessor) {
		this.graphicsProcessor = graphicsProcessor;
	}

	@Override
	public String toString() {
		return "Computer [nameProcessor=" + nameProcessor + ", RAM=" + RAM + ", graphicsProcessor=" + graphicsProcessor
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

	

}
