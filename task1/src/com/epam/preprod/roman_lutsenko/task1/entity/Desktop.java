package com.epam.preprod.roman_lutsenko.task1.entity;

import com.epam.preprod.roman_lutsenko.task7.SetAnnotation;

public class Desktop extends Computer {
	private String formFactor;
	private String typeWorkspace;

	public Desktop() {	}

	public Desktop(String nameModel, int id, long price, String nameProcessor, int ram,
                   String formFactor, String typeWorkspace) {
		super(nameModel, id, price, nameProcessor, ram);
		this.formFactor = formFactor;
		this.typeWorkspace = typeWorkspace;
	}

	public String getFormFactor() {
		return formFactor;
	}

    @SetAnnotation(name = "desktopFormFactor")
	public void setFormFactor(String formFactor) {
		this.formFactor = formFactor;
	}

	public String getTypeWorkspace() {
		return typeWorkspace;
	}

    @SetAnnotation(name = "desktopTypeWorkspace")
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
		if (!(obj.getClass().equals(this.getClass()))) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Desktop " + super.toString()+"[formFactor=" + formFactor + ", typeWorkspace=" + typeWorkspace + "]";
	}

	

}
