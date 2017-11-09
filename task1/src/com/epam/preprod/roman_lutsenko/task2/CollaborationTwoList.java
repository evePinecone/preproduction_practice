package com.epam.preprod.roman_lutsenko.task2;

import com.epam.preprod.roman_lutsenko.task2.exceptions.UnmodifiableCollaborationTwoListException;

import java.util.*;

public class CollaborationTwoList<E> implements List<E> {

    private List<E> unmodifiable;
    private List<E> modifiable;

    public CollaborationTwoList(List<E> unmodifableCollecion, List<E> modifableCollection) {
        this.unmodifiable = unmodifableCollecion;
        this.modifiable = modifableCollection;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Incorrect input index");
        }
    }

    private void checkIndexAdding(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Incorrect input index");
        }
    }

    @Override
    public int size() {
        return unmodifiable.size() + modifiable.size();
    }

    @Override
    public boolean isEmpty() {
        return unmodifiable.isEmpty() && modifiable.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return unmodifiable.contains(object) || modifiable.contains(object);
    }

    @Override
    public Iterator<E> iterator() {
        return new CollaborationgTwoListIterator();
    }

    private class CollaborationgTwoListIterator implements Iterator<E> {

        Iterator<E> unmodifableIterator = unmodifiable.iterator();
        Iterator<E> modifableIterator = modifiable.iterator();

        @Override
        public boolean hasNext() {
            return unmodifableIterator.hasNext() || modifableIterator.hasNext();
        }

        @Override
        public E next() {
            if (unmodifableIterator.hasNext()) {
                return unmodifableIterator.next();
            } else if (modifableIterator.hasNext()) {
                return modifableIterator.next();
            }
            throw new NoSuchElementException();
        }

    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[unmodifiable.size() + modifiable.size()];
        System.arraycopy(unmodifiable.toArray(), 0, result, 0, unmodifiable.size());
        System.arraycopy(modifiable.toArray(), 0, result, unmodifiable.size(), modifiable.size());
        return result;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size()) {
            return (T[]) Arrays.copyOf(toArray(), size(), array.getClass());
        }
        System.arraycopy(toArray(), 0, array, 0, size());
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override
    public boolean add(E element) {
        return modifiable.add(element);
    }

    @Override
    public boolean remove(Object object) {
        if (unmodifiable.contains(object)) {
            throw new UnmodifiableCollaborationTwoListException();
        }
        if (modifiable.contains(object)) {
            return modifiable.remove(object);
        }
        return false;
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
    public boolean addAll(Collection<? extends E> collection) {
        return modifiable.addAll(collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        checkIndexAdding(index);
        if (index < unmodifiable.size()) {
            throw new UnmodifiableCollaborationTwoListException();
        }
        return modifiable.addAll(index, collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object o : collection) {
            if (unmodifiable.contains(o)) {
                throw new UnmodifiableCollaborationTwoListException();
            }
        }
        return modifiable.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection.containsAll(unmodifiable)) {
            return modifiable.retainAll(collection);
        } else {
            throw new UnmodifiableCollaborationTwoListException();
        }
    }

    @Override
    public void clear() {
        if (unmodifiable.isEmpty()) {
            modifiable.clear();
        } else {
            throw new UnmodifiableCollaborationTwoListException();
        }
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        if (index < unmodifiable.size()) {
            return unmodifiable.get(index);
        } else {
            return modifiable.get(index - unmodifiable.size());
        }
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        if (index < unmodifiable.size()) {
            throw new UnmodifiableCollaborationTwoListException();
        } else {
            return modifiable.set(index - unmodifiable.size(), element);
        }
    }

    @Override
    public void add(int index, E element) {
        checkIndexAdding(index);
        if (index < unmodifiable.size()) {
            throw new UnmodifiableCollaborationTwoListException();
        } else {
            modifiable.add(index - unmodifiable.size(), element);
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        if (index < unmodifiable.size()) {
            throw new UnmodifiableCollaborationTwoListException();
        }
        return modifiable.remove(index - unmodifiable.size());

    }

    @Override
    public int indexOf(Object object) {
        if (unmodifiable.contains(object)) {
            return unmodifiable.indexOf(object);
        } else if (modifiable.contains(object)) {
            return unmodifiable.size() + modifiable.indexOf(object);
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (modifiable.contains(object)) {
            return modifiable.lastIndexOf(object) + unmodifiable.size();
        } else if (unmodifiable.contains(object)) {
            return unmodifiable.lastIndexOf(object);
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

}
