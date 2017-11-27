package com.epam.preprod.roman_lutsenko.task3.unique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class UniqueObjectList<E> extends ArrayList<E> implements List<E> {

    private static final long serialVersionUID = 1L;

    private void checkElementAlreadyExists(E element) {
        if (contains(element)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkContainsCollection(Collection<? extends E> collection) {
        checkCollectionForDuplicates(collection);
        for (E element : collection) {
            checkElementAlreadyExists(element);
        }
    }

    private void checkCollectionForDuplicates(Collection<? extends E> collection) {
        Object[] array = collection.toArray();
        Arrays.sort(array);
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index].equals(array[index + 1])) {
                throw new IllegalArgumentException();
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#set(int, java.lang.Object)
     */
    @Override
    public E set(int index, E element) {
        checkElementAlreadyExists(element);
        return super.set(index, element);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#add(java.lang.Object)
     */
    @Override
    public boolean add(E element) {
        checkElementAlreadyExists(element);
        return super.add(element);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#add(int, java.lang.Object)
     */
    @Override
    public void add(int index, E element) {
        checkElementAlreadyExists(element);
        super.add(index, element);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#addAll(java.util.Collection)
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        checkContainsCollection(collection);
        return super.addAll(collection);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#addAll(int, java.util.Collection)
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        checkContainsCollection(collection);
        return super.addAll(index, collection);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.ArrayList#replaceAll(java.util.function.UnaryOperator)
     */
    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        List<E> list = new UniqueObjectList<>();
        for (E obj : this) {
            list.add(operator.apply(obj));
        }
        clear();
        addAll(list);
    }

}
