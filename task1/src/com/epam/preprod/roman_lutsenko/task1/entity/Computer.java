package com.epam.preprod.roman_lutsenko.task1.entity;

public class Computer extends Thing{
	String nameProcessor;
	int RAM;
	String graphicsProcessor;

	public Computer() {
		super();
		nameProcessor = "none";
		RAM = -1;
		graphicsProcessor = "none";
	}

	public Computer(String nameModel, String firm, long price, String nameProcessor, int rAM,
			String graphicsProcessor) {
		super(nameModel, firm, price);
		this.nameProcessor = nameProcessor;
		RAM = rAM;
		this.graphicsProcessor = graphicsProcessor;
	}

	public String getNameProcessor() {
		return nameProcessor;
	}

	public void setNameProcessor(String nameProcessor) {
		this.nameProcessor = nameProcessor;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public String getGraphicsProcessor() {
		return graphicsProcessor;
	}

	public void setGraphicsProcessor(String graphicsProcessor) {
		this.graphicsProcessor = graphicsProcessor;
	}

	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + RAM;
		result = prime * result + ((graphicsProcessor == null) ? 0 : graphicsProcessor.hashCode());
		result = prime * result + ((nameProcessor == null) ? 0 : nameProcessor.hashCode());
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
		if (!(obj instanceof Computer)) {
			return false;
		}
		Computer other = (Computer) obj;
		if (RAM != other.RAM) {
			return false;
		}
		if (graphicsProcessor == null) {
			if (other.graphicsProcessor != null) {
				return false;
			}
		} else if (!graphicsProcessor.equals(other.graphicsProcessor)) {
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

	@Override
	public String toString() {
		return "Computer [nameProcessor=" + nameProcessor + ", RAM=" + RAM + ", graphicsProcessor=" + graphicsProcessor
				+ ", nameModel=" + nameModel + ", firm=" + firm + ", price=" + price + "]";
	}

	

}
