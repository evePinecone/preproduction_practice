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
     * @param strToHash the strToHash to set
     */
    public void setStrToHash(String strToHash) {
        this.strToHash = strToHash;
    }

    @Override
    public int hashCode() {
        int index = 0;
        int result = 0;
        while (index < NUMBER_LETTERS_FROM_STRING && index < strToHash.length()) {
            result += strToHash.charAt(index++);
        }
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        StringFourHashWrapper that = (StringFourHashWrapper) object;

        return strToHash != null ? strToHash.equals(that.strToHash) : that.strToHash == null;
    }

}
