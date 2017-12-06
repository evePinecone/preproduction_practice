package com.epam.preprod.roman_lutsenko.task7.entities;

/**
 * Implementation of ThingInterface. Copy of base entity from task1.
 */
public class Thing implements ThingInterface {

    private String nameModel;
    private int id;
    private long price;

    public Thing() {
    }

    public Thing(String nameModel, int id, long price) {
        this.nameModel = nameModel;
        this.id = id;
        this.price = price;
    }

    public String getNameModel() {
        return nameModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thing thing = (Thing) o;

        if (id != thing.id) return false;
        return price == thing.price && (nameModel != null ? nameModel.equals(thing.nameModel) : thing.nameModel == null);
    }

    @Override
    public int hashCode() {
        int result = nameModel != null ? nameModel.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", nameModel=" + nameModel + ", price=" + price + "]";
    }


}
