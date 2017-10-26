package com.epam.preprod.roman_lutsenko.task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

/**
 * 
 * @author Roman_Lutsenko
 *
 * @param <E>
 */
public class ThingList<E extends Thing> implements List<Thing> {

	private final int INITIAL_CAPACITY = 100;
	private final int MAX_LIST_SIZE = Integer.MAX_VALUE - 2;
	/**
	 * Step to resize an array;
	 */
	private final int STEP_RESIZE = 100;

	private int size;
	private Thing[] arrayList;

	public ThingList() {
		this.arrayList = new Thing[INITIAL_CAPACITY];
	}

	public ThingList(int initialCapacity) {
		if (initialCapacity < 0 || initialCapacity > MAX_LIST_SIZE) {

		}
		this.arrayList = new Thing[initialCapacity];
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Resize a base array in ThingList by adding STEP_RESIZE.
	 *
	 * @throws IndexOutOfBoundsException
	 *             if we can't resize array.
	 */
	@SuppressWarnings("unused")
	private void resizePlus() throws IndexOutOfBoundsException {
		if (size + STEP_RESIZE >= MAX_LIST_SIZE)
			throw new IndexOutOfBoundsException("Can't resize an array");
		Thing[] bufArrayList = new Thing[size + STEP_RESIZE];
		System.arraycopy(arrayList, 0, bufArrayList, 0, size);
		arrayList = bufArrayList;
	}

	@Override
	public boolean isEmpty() {
		if (arrayList == null || size == 0)
			return true;
		return false;
		/*
		 * return (arrayList == null || size == 0)
		 */
	}

	@Override
	public boolean contains(Object o) {
		return (indexOf(o) >= 0);
	}

	/*
	 * Not added if to iterator. Just simple.
	 * (non-Javadoc)
	 * @see java.util.List#iterator()
	 */
	@Override
	public Iterator<Thing> iterator() {
		return new ItrImpl();
	}
	
	private class ItrImpl implements Iterator<Thing> {
		int cursor;       // index of next element to return
        int lastRet = -1;
		
		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public E next() {
            int index = cursor;
            if (index >= size)
                throw new NoSuchElementException();
            Object[] elementData = ThingList.this.arrayList;
            cursor = index + 1;
            return (E) arrayList[lastRet = index];
		}
		
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(arrayList, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(arrayList, size, a.getClass());
		System.arraycopy(arrayList, 0, a, 0, size);
		return a;
	}

	@Override
	public boolean add(Thing e) {
		if (arrayList.length <= size - 1) {
			resizePlus();
		}
		arrayList[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (!contains(o))
			return false;
		int indexRemove = indexOf(o);
		System.arraycopy(arrayList, indexRemove, arrayList, indexRemove - 1, size - indexRemove - 1);
		size--;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (int i = 0; i < size; i++) {
			if (!c.contains(arrayList[i]))
				return false;
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
		System.arraycopy(c, 0, arrayList, size - 1, c.size());
		size+=c.size();
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
		System.arraycopy(arrayList, index, arrayList, index + c.size(), c.size());
		System.arraycopy(c, 0, arrayList, index, c.size());
		size+=c.size();
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
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
		size = 0;
		arrayList = new Thing[INITIAL_CAPACITY];
	}

	@Override
	public Thing get(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		if (contains(arrayList[index]))
			return arrayList[index];
		return null;
	}

	@Override
	public Thing set(int index, Thing element) {
		// Need to place element to the last empty element?
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		Thing bufElement = arrayList[index];
		arrayList[index] = element;
		return bufElement;
	}

	@Override
	public void add(int index, Thing element) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		if (size >= arrayList.length) {
			resizePlus();
		}
		System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
		arrayList[index] = element;
		size++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Thing remove(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		E removedElement;
		if (contains(arrayList[index])) {
			removedElement = (E) arrayList[index];
			System.arraycopy(arrayList, index + 1, arrayList, index, size - index - 1);
			size--;
		} else {
			removedElement = null;
		}
		return removedElement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int indexOf(Object o) {
		E bufObj = (E) o;
		if (bufObj == null) {
			for (int i = 0; i < size; i++)
				if (arrayList[i] == null)
					return i;
		}
		for (int i = 0; i < size; i++)
			if (bufObj.equals(arrayList[i]))
				return i;
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int lastIndexOf(Object o) {
		E bufObj = (E) o;
		if (bufObj == null) {
			for (int i = size - 1; i >= 0; i--)
				if (arrayList[i] == null)
					return i;
		}
		for (int i = size - 1; i >= 0; i--)
			if (bufObj.equals(arrayList[i]))
				return i;
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
