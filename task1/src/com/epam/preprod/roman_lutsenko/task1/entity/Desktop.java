package com.epam.preprod.roman_lutsenko.task1.entity;

public class Desktop extends Computer {
	String formFactor;
	String typeWorkspace;

	public Desktop() {
		super();
		formFactor = "none";
		typeWorkspace = "none";
	}

	public Desktop(String nameModel, String firm, long price, String nameProcessor, int rAM,
			String formFactor, String typeWorkspace) {
		super(nameModel, firm, price, nameProcessor, rAM);
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

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((formFactor == null) ? 0 : formFactor.hashCode());
		result = prime * result + ((typeWorkspace == null) ? 0 : typeWorkspace.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Desktop)) {
			return false;
		}
		Desktop other = (Desktop) obj;
		if (formFactor == null) {
			if (other.formFactor != null) {
				return false;
			}
		} else if (!formFactor.equals(other.formFactor)) {
			return false;
		}
		if (typeWorkspace == null) {
			if (other.typeWorkspace != null) {
				return false;
			}
		} else if (!typeWorkspace.equals(other.typeWorkspace)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Desktop [formFactor=" + formFactor + ", typeWorkspace=" + typeWorkspace + ", nameProcessor="
				+ nameProcessor + ", RAM=" + RAM + ", nameModel="
				+ nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

}
