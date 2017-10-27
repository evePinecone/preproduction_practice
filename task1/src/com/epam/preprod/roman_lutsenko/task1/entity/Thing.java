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
	long price;

	public Thing() {
		nameModel = "none";
		firm = "none";
		price = -1;
	}

	public Thing(String nameModel, String firm, long price) {
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firm == null) ? 0 : firm.hashCode());
		result = prime * result + ((nameModel == null) ? 0 : nameModel.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
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
		if (!(obj instanceof Thing)) {
			return false;
		}
		Thing other = (Thing) obj;
		if (firm == null) {
			if (other.firm != null) {
				return false;
			}
		} else if (!firm.equals(other.firm)) {
			return false;
		}
		if (nameModel == null) {
			if (other.nameModel != null) {
				return false;
			}
		} else if (!nameModel.equals(other.nameModel)) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Thing [nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}
 
	
}
