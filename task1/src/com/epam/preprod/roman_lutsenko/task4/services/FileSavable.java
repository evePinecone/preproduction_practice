package com.epam.preprod.roman_lutsenko.task4.services;

/**
 * Indicates two methods for serialize and deserialize object in file.
 */
public interface FileSavable {
    /**
     * Serialize product into file with name PathsConstants.SERIALIZE_PRODUCT_FILE_NAME
     */
    void serializeProduct();

    /**
     * Unserialize product from file with name PathsConstants.SERIALIZE_PRODUCT_FILE_NAME and add to productDAO container.
     */
    void unSerializeProduct();
}
