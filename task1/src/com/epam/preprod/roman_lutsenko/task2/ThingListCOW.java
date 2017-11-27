package com.epam.preprod.roman_lutsenko.task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.util.*;

/**
 * Container for elements that extends Things. Based on array. Extension by step
 * STEP_RESIZE.
 *
 * @param <E>
 * @author Roman_Lutsenko
 */
public class ThingListCOW<E extends Thing> implements List<Thing> {

    private static final int INITIAL_CAPACITY = 100;
    private static final int MAX_LIST_SIZE = Integer.MAX_VALUE - 2;
    /**
     * Step to resize an array;
     */
    private static final int STEP_RESIZE = 100;

    private int size;
    private Thing[] arrayList;

    private boolean isEdited = true;

    /**
     * @return the arrayList
     */
    public Thing[] getArrayList() {
        return arrayList;
    }

    public void setArrayList(Thing[] bufArrayList) {
        this.arrayList = bufArrayList;
    }

    public ThingListCOW() {
        this.arrayList = new Thing[INITIAL_CAPACITY];
    }

    public ThingListCOW(int initialCapacity) {
        if ((initialCapacity < 0) || (initialCapacity > MAX_LIST_SIZE)) {
            throw new IllegalArgumentException();
        }
        this.arrayList = new Thing[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Resize a base array in ThingListCOW by adding STEP_RESIZE.
     *
     * @throws IndexOutOfBoundsException if we can't resize array.
     */
    private void resizePlus(int stepResize) throws IndexOutOfBoundsException {
        if (size + stepResize >= MAX_LIST_SIZE) {
            throw new IndexOutOfBoundsException("Can't resize an array");
        }
        Thing[] bufArrayList = new Thing[size + stepResize];
        System.arraycopy(arrayList, 0, bufArrayList, 0, size);
        arrayList = bufArrayList;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect input index");
        }
    }

    private void checkIndexAdding(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Incorrect input index");
        }
    }

    private void checkEdit() {
        if (!isEdited) {
            isEdited = true;
            arrayList = Arrays.copyOf(arrayList, size);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }


    /**
     * Edited for custom filter.
     */
    @Override
    public Iterator<Thing> iterator() {
        return new ItrImpl();
    }

    private class ItrImpl implements Iterator<Thing> {
        private int cursor; // index of next element to return
        private Thing[] linkSave;
        private int sizeSave;

        ItrImpl() {
            isEdited = false;
            linkSave = arrayList;
            sizeSave = size;
        }

        @Override
        public boolean hasNext() {
            return cursor != sizeSave;
        }

        @Override
        public Thing next() {
            int index = cursor;
            if (index >= sizeSave) {
                throw new NoSuchElementException();
            }
            cursor = index + 1;
            return linkSave[index];
        }

    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            return (T[]) Arrays.copyOf(arrayList, size, array.getClass());
        }
        if (array.length > size)
            array[size] = null;
        System.arraycopy(arrayList, 0, array, 0, size);
        return array;
    }

    @Override
    public boolean add(Thing element) {
        checkEdit();
        if (arrayList.length <= size + 1) {
            resizePlus(STEP_RESIZE);
        }
        arrayList[size++] = element;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object object : collection) {
            if (!contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Thing> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        checkEdit();
        resizePlus(collection.size() + 1);
        System.arraycopy(collection.toArray(), 0, arrayList, size , collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Thing> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        checkIndexAdding(index);
        checkEdit();
        resizePlus(collection.size() + 1);
        System.arraycopy(arrayList,index, arrayList,index+collection.size(), size-index);
        System.arraycopy(collection.toArray(), 0, arrayList, index, collection.size());
        size += collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        checkEdit();
        boolean flagChanges = false;
        for (Object object : collection) {
            if (contains(object)) {
                remove(object);
                flagChanges = true;
            }
        }
        return flagChanges;
    }


    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        checkEdit();
        boolean flagChanges = false;
        for (int i = 0; i < size; i++) {
            if (!collection.contains(arrayList[i])) {
                remove(arrayList[i]);
                flagChanges = true;
            }
        }
        return flagChanges;
    }

    @Override
    public void clear() {
        checkEdit();
        size = 0;
        arrayList = new Thing[INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) arrayList[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, Thing element) {
        checkIndex(index);
        checkEdit();
        Thing bufElement = arrayList[index];
        arrayList[index] = element;
        return (E) bufElement;
    }

    @Override
    public void add(int index, Thing element) {
        checkIndexAdding(index);
        checkEdit();
        if (arrayList.length < size + 1) {
            resizePlus(STEP_RESIZE);
        }
        System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
        arrayList[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        checkIndex(index);
        checkEdit();
        E removedElement = (E) arrayList[index];
        System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
        size--;
        return removedElement;
    }

    @Override
    public boolean remove(Object object) {
        int indexRemove = indexOf(object);
        if (indexRemove == -1) {
            return false;
        }
        checkEdit();
        System.arraycopy(arrayList, indexRemove + 1, arrayList, indexRemove, size - indexRemove - 1);
        size--;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int indexOf(Object object) {
        E bufObj = (E) object;
        if (bufObj == null) {
            for (int i = 0; i < size; i++) {
                if (arrayList[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (bufObj.equals(arrayList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int lastIndexOf(Object object) {
        E bufObj = (E) object;
        if (bufObj == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (arrayList[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (bufObj.equals(arrayList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<Thing> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<Thing> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Thing> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder("ThingList [arrayList=");
        for (int i = 0; i < size - 1; i++) {
            resultString.append(arrayList[i]).append(", ");
        }
        resultString.append(arrayList[size - 1]).append(".");
        return resultString.toString();
    }

}
