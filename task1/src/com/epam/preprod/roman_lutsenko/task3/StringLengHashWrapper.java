package com.epam.preprod.roman_lutsenko.task3;

public class StringLengHashWrapper {

	private String stringToHash;

	public StringLengHashWrapper(String stringToHash) {
		this.stringToHash = stringToHash;
	}

	/**
	 * @return the stringToHash
	 */
	public String getStringToHash() {
		return stringToHash;
	}

	/**
	 * @param stringToHash the stringToHash to set
	 */
	public void setStringToHash(String stringToHash) {
		this.stringToHash = stringToHash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 1;
		result = stringToHash.length();
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
		StringLengHashWrapper other = (StringLengHashWrapper) obj;
		if (stringToHash == null) {
			if (other.stringToHash != null) {
				return false;
			}
		} else if (!stringToHash.equals(other.stringToHash)) {
			return false;
		}
		return true;
	}



	
}
