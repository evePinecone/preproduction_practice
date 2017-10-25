package com.epam.preprod.roman_lutsenko.task1.entity;

/**
 * The base class for our entities.
 *
 * @author Roman_Lutsenko
 *
 */
public abstract class Thing {
	String nameModel;
	/**
	 * Company manufacturer.
	 */
	String firm;
	double price;

	public Thing() {
		nameModel = "none";
		firm = "none";
		price = -1;
	}

	public Thing(String nameModel, String firm, double price) {
		super();
		this.nameModel = nameModel;
		this.firm = firm;
		this.price = price;
	}

	public String getNameModel() {
		return nameModel;
	}

	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}

	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Thing [nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}
 
	
}
