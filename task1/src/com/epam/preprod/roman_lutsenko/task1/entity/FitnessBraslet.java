package com.epam.preprod.roman_lutsenko.task1.entity;

public class FitnessBraslet extends PortableGadget {
	String display;
	String strapMaterial;
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public FitnessBraslet() {
		super();
		this.display = "none";
		this.strapMaterial = "none";
	}

	public FitnessBraslet(String nameModel, String firm, double price, String autonomy, String display,
			String strapMaterial) {
		super(nameModel, firm, price, autonomy);
		this.display = display;
		this.strapMaterial = strapMaterial;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getStrapMaterial() {
		return strapMaterial;
	}

	public void setStrapMaterial(String strapMaterial) {
		this.strapMaterial = strapMaterial;
	}

	@Override
	public String toString() {
		return "FitnessBraslet [display=" + display + ", strapMaterial=" + strapMaterial + ", autonomy=" + autonomy
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}
	
}
