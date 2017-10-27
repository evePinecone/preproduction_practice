package com.epam.preprod.roman_lutsenko.task1.entity;

public class FitnessBraslet extends PortableGadget {
	String display;
	String strapMaterial;
	
	public FitnessBraslet() {
		super();
		this.display = "none";
		this.strapMaterial = "none";
	}

	public FitnessBraslet(String nameModel, String firm, long price, String autonomy, String display,
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((strapMaterial == null) ? 0 : strapMaterial.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FitnessBraslet)) {
			return false;
		}
		FitnessBraslet other = (FitnessBraslet) obj;
		if (display == null) {
			if (other.display != null) {
				return false;
			}
		} else if (!display.equals(other.display)) {
			return false;
		}
		if (strapMaterial == null) {
			if (other.strapMaterial != null) {
				return false;
			}
		} else if (!strapMaterial.equals(other.strapMaterial)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "FitnessBraslet [display=" + display + ", strapMaterial=" + strapMaterial + ", autonomy=" + autonomy
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}
	
}
