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
public class ThingListCOW<E extends Thing> implements List<Thing>{

	private final int INITIAL_CAPACITY = 100;
	private final int MAX_LIST_SIZE = Integer.MAX_VALUE - 2;
	/**
	 * Step to resize an array;
	 */
	private final int STEP_RESIZE = 100;

	private int size;
	private Thing[] arrayList;

	/**
	 * @return the arrayList
	 */
	public Thing[] getArrayList() {
		return arrayList;
	}

	/**
	 * @param arrayList the arrayList to set
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
		//	Thing[] linkSave = ThingListCOW.this.linkSave;
			cursor = index + 1;
			return (Thing) linkSave[index];
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
	public boolean add(Thing e) {
		if (arrayList.length <= size - 1) {
			resizePlus();
		}
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		bufArrayList[size++] = e;
		setArrayList(bufArrayList);
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
	public boolean addAll(Collection<? extends Thing> c) {
		while (arrayList.length <= c.size()) {
			resizePlus();
			/*
			 * if we catch IndexOutOfBoundsException; return false;
			 */
		}
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		System.arraycopy(c, 0, bufArrayList, size - 1, c.size());
		setArrayList(bufArrayList);
		size += c.size();
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
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		System.arraycopy(bufArrayList, index, bufArrayList, index + c.size(), c.size());
		System.arraycopy(c, 0, bufArrayList, index, c.size());
		setArrayList(bufArrayList);
		size += c.size();
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		boolean flagChanges = false;
		for (int i = 0; i < size; i++) {
			if (c.contains(bufArrayList[i])) {
				remove(bufArrayList[i]);
				flagChanges = true;
			}
		}
		setArrayList(bufArrayList);
		return flagChanges;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		boolean flagChanges = false;
		for (int i = 0; i < size; i++) {
			if (!c.contains(bufArrayList[i])) {
				remove(bufArrayList[i]);
				flagChanges = true;
			}
		}
		setArrayList(bufArrayList);
		return flagChanges;
	}

	@Override
	public void clear() {
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
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length);
		Thing bufElement = bufArrayList[index];
		bufArrayList[index] = element;
		setArrayList(bufArrayList);
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
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length);
		System.arraycopy(bufArrayList, index, bufArrayList, index + 1, size - index);
		bufArrayList[index] = element;
		setArrayList(bufArrayList);
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) {
		if (index < 0 || index > size || size == 0) {
			throw new IndexOutOfBoundsException("Incorrect input index");
		}
		E removedElement;
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		if (contains(bufArrayList[index]) && index > 0) {
			removedElement = (E) bufArrayList[index];
			System.arraycopy(bufArrayList, index + 1, bufArrayList, index, size - index - 1);
			size--;
		} else if (index == 0) {
			removedElement = (E) bufArrayList[index];
			System.arraycopy(bufArrayList, index + 1, bufArrayList, index, size - index - 1);
			size--;
		} else {
			removedElement = null;
		}
		setArrayList(bufArrayList);
		return removedElement;
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o)) {
			return false;
		}
		int indexRemove = indexOf(o);
		Thing[] bufArrayList = Arrays.copyOf(arrayList, arrayList.length); 
		if (indexRemove >= 0) {
			System.arraycopy(bufArrayList, indexRemove + 1, bufArrayList, indexRemove, size - indexRemove - 1);
			size--;
		}
		setArrayList(bufArrayList);
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


}
