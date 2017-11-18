package com.epam.preprod.roman_lutsenko.task4.services.inerfaces;

public interface ToFileSavable {
    /**
     * Serialize product into file with name Paths.SERIALIZE_PRODUCT_FILE_NAME
     */
    void toFileSever();

    void fromFileReader();
}
