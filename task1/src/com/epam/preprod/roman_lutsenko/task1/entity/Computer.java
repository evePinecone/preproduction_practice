package com.epam.preprod.roman_lutsenko.task1.entity;

public class Computer extends Thing {
	private String nameProcessor;
	private int ram;

	public Computer() {
	}

	public Computer(String nameModel, String firm, long price, String nameProcessor, int rAM) {
		super(nameModel, firm, price);
		this.nameProcessor = nameProcessor;
		ram = rAM;
	}

	public String getNameProcessor() {
		return nameProcessor;
	}

	public void setNameProcessor(String nameProcessor) {
		this.nameProcessor = nameProcessor;
	}

	public int getRAM() {
		return ram;
	}

	public void setRAM(int rAM) {
		ram = rAM;
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
		result = prime * result + ram;
		result = prime * result + ((nameProcessor == null) ? 0 : nameProcessor.hashCode());
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
		Computer other = (Computer) obj;
		if (ram != other.ram) {
			return false;
		}
		if (nameProcessor == null) {
			if (other.nameProcessor != null) {
				return false;
			}
		} else if (!nameProcessor.equals(other.nameProcessor)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "[nameProcessor=" + nameProcessor + ", ram=" + ram + "]";
	}

}
