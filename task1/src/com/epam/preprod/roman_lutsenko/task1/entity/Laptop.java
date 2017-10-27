package com.epam.preprod.roman_lutsenko.task1.entity;

public class Laptop extends Computer {
	double displayResolution;
	double weight;

	public Laptop() {
		super();
		displayResolution = -1;
		weight = -1;
	}

	public Laptop(String nameModel, String firm, long price, String nameProcessor, int rAM,
			double displayResolution, double weight) {
		super(nameModel, firm, price, nameProcessor, rAM);
		this.displayResolution = displayResolution;
		this.weight = weight;
	}

	public double getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(double displayResolution) {
		this.displayResolution = displayResolution;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(displayResolution);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (!(obj instanceof Laptop)) {
			return false;
		}
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(displayResolution) != Double.doubleToLongBits(other.displayResolution)) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Laptop [displayResolution=" + displayResolution + ", weight=" + weight + ", nameProcessor="
				+ nameProcessor + ", RAM=" + RAM + ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price
				+ "]";
	}
		
}
