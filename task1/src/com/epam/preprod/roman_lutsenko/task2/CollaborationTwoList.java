package com.epam.preprod.roman_lutsenko.task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CollaborationTwoList<E> implements List<E> {

	List<E> unmodifable;
	List<E> modifable;

	public CollaborationTwoList(List<E> unmodifableCollecion, List<E> modifableCollection) {
		this.unmodifable = unmodifableCollecion;
		this.modifable = modifableCollection;
	}

	@Override
	public int size() {
		return unmodifable.size() + modifable.size();
	}

	@Override
	public boolean isEmpty() {
		return unmodifable.isEmpty() && modifable.isEmpty();
	}

	@Override
	public boolean contains(Object object) {
		return unmodifable.contains(object) || modifable.contains(object);
	}

	@Override
	public Iterator<E> iterator() {
		return new CollaborationgTwoListIterator();
	}

	private class CollaborationgTwoListIterator implements Iterator<E> {

		Iterator<E> unmodifableIterator = unmodifable.iterator();
		Iterator<E> modifableIterator = modifable.iterator();

		@Override
		public boolean hasNext() {
			if (unmodifableIterator.hasNext()) {
				return true;
			} else if (modifableIterator.hasNext()) {
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			if (unmodifableIterator.hasNext()) {
				return unmodifableIterator.next();
			} else if (modifableIterator.hasNext()) {
				return modifableIterator.next();
			}
			return null;
		}

	}

	@Override
	public Object[] toArray() {
		Object[] objectResult = unmodifable.toArray();
		System.arraycopy(modifable.toArray(), 0, objectResult, unmodifable.size(), modifable.size());
		return objectResult;
	}
	
	@Override
	public <T> T[] toArray(T[] array) {
		if (array.length < size())
            return (T[]) Arrays.copyOf(toArray(), size(), array.getClass());
        System.arraycopy(toArray(), 0, array, 0, size());
        if (array.length > size())
            array[size()] = null;
        return array;
	}

	@Override
	public boolean add(E element) {
		return modifable.add(element);
	}

	@Override
	public boolean remove(Object object) {
		if (modifable.contains(object)) {
			modifable.remove(object);
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object object : collection) {
			if (!unmodifable.contains(object) && !modifable.contains(object)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		return modifable.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		return modifable.addAll(index, collection);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return modifable.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return modifable.removeAll(collection);
	}

	@Override
	public void clear() {
		if (unmodifable.isEmpty()) {
			modifable.clear();
		} else {
			throw new ClearCollaborationTwoListException();
		}
	}

	@Override
	public E get(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index <= unmodifable.size()) {
			return unmodifable.get(index);
		} else {
			return modifable.get(index - unmodifable.size());
		}
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index <= unmodifable.size()) {
			throw new UnmodifiableCollaborationTwoListException();
		} else {
			return modifable.set(index - unmodifable.size(), element);
		}
	}

	@Override
	public void add(int index, E element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index <= unmodifable.size()) {
			throw new UnmodifiableCollaborationTwoListException();
		} else {
			modifable.add(index - unmodifable.size(), element);
		}
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index <= unmodifable.size()) {
			throw new UnmodifiableCollaborationTwoListException();
		} else {
			return modifable.remove(index - unmodifable.size());
		}
	}

	@Override
	public int indexOf(Object object) {
		if (unmodifable.contains(object)) {
			return unmodifable.indexOf(object);
		} else if (modifable.contains(object)) {
			return modifable.indexOf(object);
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object object) {
		if (unmodifable.contains(object)) {
			return unmodifable.lastIndexOf(object);
		} else if (modifable.contains(object)) {
			return modifable.lastIndexOf(object);
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
