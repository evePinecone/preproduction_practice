package com.epam.preprod.roman_lutsenko.task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task1.filters.Filter;
import com.epam.preprod.roman_lutsenko.task1.filters.FilterableIterator;

/**
 * container for elements that extends Things. Based on array. Extension by step
 * STEP_RESIZE.
 * 
 * @author Roman_Lutsenko
 *
 * @param <E>
 */
public class ThingList<E extends Thing> implements List<Thing>, FilterableIterator<Thing> {

	private static final int INITIAL_CAPACITY = 100;
	private static final int MAX_LIST_SIZE = Integer.MAX_VALUE - 2;
	/**
	 * Step to resize an array;
	 */
	private static final int STEP_RESIZE = 100;

	private int size;
	private Thing[] arrayList;

	public ThingList() {
		this.arrayList = new Thing[INITIAL_CAPACITY];
	}

	public ThingList(int initialCapacity) {
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
	 * Resize a base array in ThingList by adding STEP_RESIZE.
	 *
	 * @throws IndexOutOfBoundsException
	 *             if we can't resize array.
	 */
	private void resizePlus(final int step_resize) {
		if (size + step_resize >= MAX_LIST_SIZE) {
			throw new IndexOutOfBoundsException("Can't resize an array");
		}
		Thing[] bufArrayList = new Thing[size + step_resize];
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

	@Override
	public boolean isEmpty() {
		return size == 0;

	}

	@Override
	public boolean contains(Object object) {
		return indexOf(object) >= 0;
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
	public Iterator<Thing> iterator(Filter<Thing> filter) {
		return new FilteredIterator(filter);
	}

	@Override
	public Iterator<Thing> iterator() {
		return new ItrImpl();
	}

	/**
	 * Custom filtered iterator for collection. To get instance need to implement
	 * interface com.epam.preprod.roman_lutsenko.task1.filters.Filter with needed
	 * attr and use new instance of ItrImpl.
	 * 
	 * @author Roman_Lutsenko
	 *
	 */
	public final class FilteredIterator implements Iterator<Thing> {
		private final Filter<Thing> filter;

		int cursor = 0;
		int indexFind = 0;

		/**
		 * Constructor for custom iterator.
		 *
		 * @param filter
		 *            Implementation of interface
		 *            com.epam.preprod.roman_lutsenko.task1.filters.Filter
		 */
		public FilteredIterator(final Filter<Thing> filter) {
			if (filter == null) {
				this.filter = new AcceptAllFilter();
			} else {
				this.filter = filter;
			}
			findNext();
		}

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public Thing next() {
			int i = cursor;
			if (i >= size) {
				throw new NoSuchElementException();
			}
			findNext();
			return (E) arrayList[i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/**
		 * Finding next element that satisfies to filter.
		 * 
		 */
		private void findNext() {
			while (indexFind <= size) {
				if (this.filter.accept(arrayList[indexFind++])) {
					cursor = indexFind - 1;
					return;
				}
			}
			cursor = size;
		}

	}

	/**
	 * If filter is not set.
	 * 
	 * @author Roman_Lutsenko
	 *
	 */
	private static final class AcceptAllFilter implements Filter<Thing> {
		public boolean accept(final Thing thing) {
			return true;
		}
	}

	private class ItrImpl implements Iterator<Thing> {
		int cursor; // index of next element to return
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size;
		}

		@Override
		public Thing next() {
			int index = cursor;
			if (index >= size) {
				throw new NoSuchElementException();
			}
			Object[] arrayList = ThingList.this.arrayList;
			cursor = index + 1;
			return (Thing) arrayList[lastRet = index];
		}

		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			ThingList.this.remove(lastRet);
			cursor = lastRet;
			lastRet = -1;
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
		if (array.length > size) {
			array[size] = null;
		}
		System.arraycopy(arrayList, 0, array, 0, size);
		return array;
	}

	@Override
	public boolean add(Thing element) {
		if (arrayList.length < size + 1) {
			resizePlus(STEP_RESIZE);
		}
		arrayList[size++] = element;
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		if (collection.isEmpty()) {
			return true;
		}
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
		if (size + collection.size() >= arrayList.length) {
			resizePlus(collection.size() + 1);
		}
		System.arraycopy(collection.toArray(), 0, arrayList, size, collection.size());
		size += collection.size();
		return true;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Thing> collection) {
		if (collection.isEmpty()) {
			return false;
		}
		checkIndexAdding(index);
		if (size + collection.size() >= arrayList.length) {
			resizePlus(collection.size() + 1);
		}
		System.arraycopy(arrayList, index, arrayList, index + collection.size(), collection.size());
		System.arraycopy(collection.toArray(), 0, arrayList, index, collection.size());
		size += collection.size();
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean flagChanges = false;
		for (int i = 0; i < size; i++) {
			if (collection.contains(arrayList[i])) {
				remove(arrayList[i]);
				flagChanges = true;
			}
		}
		return flagChanges;
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
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
		Thing bufElement = arrayList[index];
		arrayList[index] = element;
		return (E) bufElement;
	}

	@Override
	public void add(int index, Thing element) {
		checkIndexAdding(index);
		if (size >= arrayList.length) {
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
