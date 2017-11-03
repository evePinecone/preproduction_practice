package com.epam.preprod.roman_lutsenko.task3;

public class StringFourHashWrapper {

	private static final int NUMBER_LETTERS_FROM_STRING = 4;

	private String strToHash;

	public StringFourHashWrapper(String argumentToHash) {
		strToHash = argumentToHash;
	}

	/**
	 * @return the strToHash
	 */
	public String getStringToHash() {
		return strToHash;
	}

	/**
	 * @param strToHash
	 *            the strToHash to set
	 */
	public void setStrToHash(String strToHash) {
		this.strToHash = strToHash;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int index;
		int result;
		index = 0;
		result = 0;
		while (index < NUMBER_LETTERS_FROM_STRING && index < strToHash.length()) {
			result += strToHash.charAt(index++) - 48;
		}
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StringFourHashWrapper)) {
			return false;
		}
		StringFourHashWrapper other = (StringFourHashWrapper) obj;
		if (strToHash == null) {
			if (other.strToHash != null) {
				return false;
			}
		} else if (!strToHash.equals(other.strToHash)) {
			return false;
		}
		return true;
	}

}
