package com.epam.preprod.roman_lutsenko.task1.entity;

import com.epam.preprod.roman_lutsenko.task4.annotations.SetAnnotation;

public class FitnessBracelet extends PortableGadget {
	private String display;
	private String strapMaterial;
	
	public FitnessBracelet() { }

	public FitnessBracelet(String nameModel, int id, long price, String autonomy, String display,
                           String strapMaterial) {
		super(nameModel, id, price, autonomy);
		this.display = display;
		this.strapMaterial = strapMaterial;
	}

	public String getDisplay() {
		return display;
	}

    @SetAnnotation(name = "fitnessBraceletDisplay")
	public void setDisplay(String display) {
		this.display = display;
	}

	public String getStrapMaterial() {
		return strapMaterial;
	}

    @SetAnnotation(name = "fitnessBraceletStrapMaterial")
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
		if (!(obj.getClass().equals(this.getClass()))) {
			return false;
		}
		FitnessBracelet other = (FitnessBracelet) obj;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FitnessBracelet" + super.toString()+"[display=" + display + ", strapMaterial=" + strapMaterial + "]";
	}
	
}
