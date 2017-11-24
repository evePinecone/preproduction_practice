package com.epam.preprod.roman_lutsenko.task4.services;

public interface FileSavable {
    /**
     * Serialize product into file with name Paths.SERIALIZE_PRODUCT_FILE_NAME
     */
    void serializeProduct();

    /**
     * Unerialize product from file with name Paths.SERIALIZE_PRODUCT_FILE_NAME and add to productDAO container.
     */
    void unSerializeProduct();
}
