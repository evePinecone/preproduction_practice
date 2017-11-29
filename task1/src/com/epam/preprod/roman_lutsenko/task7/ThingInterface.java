package com.epam.preprod.roman_lutsenko.task7;

import java.io.Serializable;

public interface ThingInterface extends Serializable {
    String getNameModel();

    void setNameModel(String nameModel);

    int getId();

    void setId(int id);

    long getPrice();

    void setPrice(long price);

    boolean equals(Object o);

    int hashCode();

    String toString();
}
