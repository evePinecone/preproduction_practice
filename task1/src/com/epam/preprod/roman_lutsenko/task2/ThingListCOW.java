package com.epam.preprod.roman_lutsenko.task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

/**
 * Container for elements that extends Things. Based on array. Extension by step
 * STEP_RESIZE.
 * 
 * @author Roman_Lutsenko
 *
 * @param <E>
 */
public class ThingListCOW<E extends Thing> implements List<Thing> {

	private final int INITIAL_CAPACITY = 100;
	private final int MAX_LIST_SIZE = Integer.MAX_VALUE - 2;
	/**
	 * Step to resize an array;
	 */
	private final int STEP_RESIZE = 100;

	private int size;
	private Thing[] arrayList, snapshot;

	private boolean isEdited;

	/**
	 * @return the arrayList
	 */
	public Thing[] getArrayList() {
		return arrayList;
	}

	/**
	 * @param arrayList
	 *            the arrayList to set
	 */
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
	 * @throws IndexOutOfBoundsException
	 *             if we can't resize array.
	 */
	@SuppressWarnings("unused")
	private void resizePlus() throws IndexOutOfBoundsException {
		if (size + STEP_RESIZE >= MAX_LIST_SIZE) {
			throw new IndexOutOfBoundsException("Can't resize an array");
		}
		Thing[] bufArrayList = new Thing[size + STEP_RESIZE];
		System.arraycopy(arrayList, 0, bufArrayList, 0, size);
		arrayList = bufArrayList;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;

	}

	@Override
	public boolean contains(Object obj) {
		return indexOf(obj) >= 0;
	}

	/*
	 * Not added if to iterator. Just simple. (non-Javadoc)
	 * 
	 * @see java.util.List#iterator()
	 */
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
			if (isEdited) {
				linkSave = snapshot;
				sizeSave = snapshot.length;
				System.out.println("Is edited = " + isEdited);
			}
			return cursor != sizeSave;
		}

		@Override
		public Thing next() {
			int index = cursor;
			if (index >= sizeSave) {
				throw new NoSuchElementException();
			}
			// Thing[] linkSave = ThingListCOW.this.linkSave;
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
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(arrayList, size, a.getClass());
		}
		if (a.length > size)
			a[size] = null;
		System.arraycopy(arrayList, 0, a, 0, size);
		return a;
	}

	@Override
	public boolean add(Thing element) {
		if (arrayList.length <= size - 1) {
			resizePlus();
		}
		checkEdit();
		// Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length);
		arrayList[size++] = element;
		// setArrayList(bufArrayList);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (int i = 0; i < size; i++) {
			if (!c.contains(arrayList[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Thing> collection) {
		while (arrayList.length <= collection.size()) {
			resizePlus();
			/*
			 * if we catch IndexOutOfBoundsException; return false;
			 */
		}
		checkEdit();
		System.arraycopy(collection, 0, arrayList, size - 1, collection.size());
		size += collection.size();
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Thing> c) {
		while (arrayList.length <= size + c.size()) {
			resizePlus();
			/*
			 * if we try to catch IndexOutOfBoundsException; return false;
			 */
		}
		checkEdit();
		System.arraycopy(arrayList, index, arrayList, index + c.size(), c.size());
		System.arraycopy(c, 0, arrayList, index, c.size());
		size += c.size();
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		checkEdit();
		boolean flagChanges = false;
		for (int i = 0; i < size; i++) {
			if (c.contains(arrayList[i])) {
				remove(arrayList[i]);
				flagChanges = true;
			}
		}
		return flagChanges;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		checkEdit();
		boolean flagChanges = false;
		for (int i = 0; i < size; i++) {
			if (!c.contains(arrayList[i])) {
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
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Incorrect input index");
		}
		if (contains(arrayList[index])) {
			return (E) arrayList[index];
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, Thing element) {
		// Need to place element to the last empty element?
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Incorrect input index");
		}
		checkEdit();
		Thing bufElement = arrayList[index];
		arrayList[index] = element;
		return (E) bufElement;
	}

	@Override
	public void add(int index, Thing element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Incorrect input index");
		}
		if (size >= arrayList.length) {
			resizePlus();
		}
		checkEdit();
		System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
		arrayList[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index < 0 || index > size || size == 0) {
			throw new IndexOutOfBoundsException("Incorrect input index");
		}
		E removedElement;
		checkEdit();
		if (contains(arrayList[index]) && index > 0) {
			removedElement = (E) arrayList[index];
			System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
			size--;
		} else if (index == 0) {
			removedElement = (E) arrayList[index];
			System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
			size--;
		} else {
			removedElement = null;
		}
		return removedElement;
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o)) {
			return false;
		}
		int indexRemove = indexOf(o);
		checkEdit();
		if (indexRemove >= 0) {
			System.arraycopy(arrayList, indexRemove + 1, arrayList, indexRemove, size - indexRemove - 1);
			size--;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		E bufObj = (E) o;
		if (bufObj == null) {
			for (int i = 0; i < size; i++) {
				if (arrayList[i] == null) {
					return i;
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (bufObj.equals(arrayList[i])) {
				return i;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Object o) {
		E bufObj = (E) o;
		if (bufObj == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (arrayList[i] == null) {
					return i;
				}
			}
		}
		for (int i = size - 1; i >= 0; i--) {
			if (bufObj.equals(arrayList[i])) {
				return i;
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

	private void checkEdit() {
		if (!isEdited) {
			isEdited = true;
			snapshot = Arrays.copyOf(arrayList, size);
		}
	}

}
