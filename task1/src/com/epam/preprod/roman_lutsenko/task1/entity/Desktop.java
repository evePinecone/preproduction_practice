package com.epam.preprod.roman_lutsenko.task1.entity;

public class Desktop extends Computer {
	String formFactor;
	String typeWorkspace;

	public Desktop() {
		super();
		formFactor = "none";
		typeWorkspace = "none";
	}

	public Desktop(String nameModel, String firm, double price, String nameProcessor, int rAM, String graphicsProcessor,
			String formFactor, String typeWorkspace) {
		super(nameModel, firm, price, nameProcessor, rAM, graphicsProcessor);
		this.formFactor = formFactor;
		this.typeWorkspace = typeWorkspace;
	}

	public String getFormFactor() {
		return formFactor;
	}

	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String getTypeWorkspace() {
		return typeWorkspace;
	}

	public void setTypeWorkspace(String typeWorkspace) {
		this.typeWorkspace = typeWorkspace;
	}

	@Override
	public String toString() {
		return "Desktop [formFactor=" + formFactor + ", typeWorkspace=" + typeWorkspace + ", nameProcessor="
				+ nameProcessor + ", RAM=" + RAM + ", graphicsProcessor=" + graphicsProcessor + ", nameModel="
				+ nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

}
