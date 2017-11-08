package com.epam.preprod.roman_lutsenko.task1.entity;

/**
 * The base class for our entities.
 *
 * @author Roman_Lutsenko
 */
public abstract class Thing {
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
        if (!(o instanceof Thing)) return false;

        Thing thing = (Thing) o;

        if (id != thing.id) return false;
        if (price != thing.price) return false;
        return nameModel.equals(thing.nameModel);
    }

    @Override
    public int hashCode() {
        int result = nameModel.hashCode();
        result = 31 * result + id;
        result = 31 * result + (int) (price ^ (price >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[nameModel=" + nameModel + ", id=" + id + ", price=" + price + "]";
    }


}
