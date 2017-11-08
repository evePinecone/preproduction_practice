package com.epam.preprod.roman_lutsenko.task1.entity;

public class PortableGadget extends Thing {
	private String autonomy;
	
	public PortableGadget() {}

	public PortableGadget(String nameModel, int id, long price, String autonomy) {
		super(nameModel, id, price);
		this.autonomy = autonomy;
	}

	public String getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(String autonomy) {
		this.autonomy = autonomy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autonomy == null) ? 0 : autonomy.hashCode());
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
		PortableGadget other = (PortableGadget) obj;
		if (autonomy == null) {
			if (other.autonomy != null) {
				return false;
			}
		} else if (!autonomy.equals(other.autonomy)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+"[autonomy=" + autonomy + "]";
	}

}
