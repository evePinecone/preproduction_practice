package com.epam.preprod.roman_lutsenko.task1.entity;

public class Laptop extends Computer {
	private double displayResolution;
	private double weight;

	public Laptop() {
	}

	public Laptop(String nameModel, Integer firm, long price, String nameProcessor, int ram, double displayResolution,
                  double weight) {
		super(nameModel, firm, price, nameProcessor, ram);
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

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
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
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(displayResolution) != Double.doubleToLongBits(other.displayResolution)) {
			return false;
		}
		return Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Laptop " + super.toString() + "[displayResolution=" + displayResolution + ", weight=" + weight + "]";
	}


}
