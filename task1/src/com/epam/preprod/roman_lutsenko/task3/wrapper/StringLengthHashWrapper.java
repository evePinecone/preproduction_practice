package com.epam.preprod.roman_lutsenko.task3.wrapper;

public class StringLengthHashWrapper {

    private String stringToHash;

    public StringLengthHashWrapper(String stringToHash) {
        this.stringToHash = stringToHash;
    }

    /**
     * @return the stringToHash
     */
    public String getStringToHash() {
        return stringToHash;
    }


    @Override
    public int hashCode() {
        return stringToHash.length();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        StringLengthHashWrapper that = (StringLengthHashWrapper) object;

        return stringToHash.equals(that.stringToHash);
    }
}
