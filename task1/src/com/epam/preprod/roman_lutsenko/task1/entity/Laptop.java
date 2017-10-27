package com.epam.preprod.roman_lutsenko.task1.entity;

public class Laptop extends Computer {
	double displayResolution;
	String autonomy;
	double weight;

	public Laptop() {
		super();
		displayResolution = -1;
		autonomy = "none";
		weight = -1;
	}

	public Laptop(String nameModel, String firm, long price, String nameProcessor, int rAM, String graphicsProcessor,
			double displayResolution, String autonomy, double weight) {
		super(nameModel, firm, price, nameProcessor, rAM, graphicsProcessor);
		this.displayResolution = displayResolution;
		this.autonomy = autonomy;
		this.weight = weight;
	}

	public double getDisplayResolution() {
		return displayResolution;
	}

	public void setDisplayResolution(double displayResolution) {
		this.displayResolution = displayResolution;
	}

	public String getAutonomy() {
		return autonomy;
	}

	public void setAutonomy(String autonomy) {
		this.autonomy = autonomy;
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
		result = prime * result + ((autonomy == null) ? 0 : autonomy.hashCode());
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
		if (autonomy == null) {
			if (other.autonomy != null) {
				return false;
			}
		} else if (!autonomy.equals(other.autonomy)) {
			return false;
		}
		if (Double.doubleToLongBits(displayResolution) != Double.doubleToLongBits(other.displayResolution)) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Laptop [displayResolution=" + displayResolution + ", autonomy=" + autonomy + ", weight=" + weight
				+ ", nameProcessor=" + nameProcessor + ", RAM=" + RAM + ", graphicsProcessor=" + graphicsProcessor
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

	
}
