package com.epam.preprod.roman_lutsenko.task1.entity;

public class PortableGadget extends Thing {
	String autonomy;
	
	public PortableGadget() {
		super();
		autonomy = "none";
	}

	public PortableGadget(String nameModel, String firm, double price, String autonomy) {
		super(nameModel, firm, price);
		this.autonomy = autonomy;
	}

	public String getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(String autonomy) {
		this.autonomy = autonomy;
	}

	@Override
	public String toString() {
		return "PortableGadget [autonomy=" + autonomy + ", nameModel=" + nameModel + ", firm=" + firm + ", price="
				+ price + "]";
	}
	
}
