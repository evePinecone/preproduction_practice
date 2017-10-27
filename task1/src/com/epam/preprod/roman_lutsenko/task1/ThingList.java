package com.epam.preprod.roman_lutsenko.task1;

import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task1.filters.Filter;
import com.epam.preprod.roman_lutsenko.task1.filters.ThingFilter;

/**
 * Container for elements that extends Things.
 * Based on array. Extension by step STEP_RESIZE.
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
		return (arrayList == null || size == 0);

	}

	@Override
	public boolean contains(Object o) {
		return (indexOf(o) >= 0);
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
		return new FilteredIterator(new ItrImpl(), new ThingFilter<Thing>());
		// return new FilteredIterator(new ItrImpl(), null);
		// return new ItrImpl();
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
		private final Iterator<Thing> iterator;
		private final Filter<Thing> filter;

		private boolean hasNext = true;
		private Thing next;
		int cursor;

		/**
		 * Constructor for custom iterator.
		 * 
		 * @param iterator basic realisation of iterator.
		 * @param filter
		 *            implementetion of interface
		 *            com.epam.preprod.roman_lutsenko.task1.filters.Filter
		 */
		public FilteredIterator(final Iterator<Thing> iterator, final Filter<Thing> filter) {
			this.iterator = iterator;
			Objects.requireNonNull(iterator);

			if (filter == null) {
				this.filter = new AcceptAllFilter();
			} else {
				this.filter = filter;
			}
			this.findNext();
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public Thing next() {
			Thing returnValue = this.next;
			this.findNext();
			return returnValue;
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
			while (this.iterator.hasNext()) {
				this.next = iterator.next();
				if (this.filter.accept(this.next)) {
					return;
				}
			}
			this.hasNext = false;
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
			if (index >= size)
				throw new NoSuchElementException();
			Object[] arrayList = ThingList.this.arrayList;
			cursor = index + 1;
			return (Thing) arrayList[lastRet = index];
		}

		@Override
		public void remove() {
			if (lastRet < 0)
				throw new IllegalStateException();
			try {
				ThingList.this.remove(lastRet);
				cursor = lastRet;
				lastRet = -1;
			} catch (IndexOutOfBoundsException ex) {
				throw new ConcurrentModificationException();
			}
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
		System.arraycopy(arrayList, index, arrayList, index + c.size(), c.size());
		System.arraycopy(c, 0, arrayList, index, c.size());
		size += c.size();
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

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		if (contains(arrayList[index]))
			return (E) arrayList[index];
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, Thing element) {
		// Need to place element to the last empty element?
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Incorrect input index");
		Thing bufElement = arrayList[index];
		arrayList[index] = element;
		return (E) bufElement;
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
	public E remove(int index) {
		if (index < 0 || index > size || size == 0)
			throw new IndexOutOfBoundsException("Incorrect input index");
		E removedElement;
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
		if (!contains(o))
			return false;
		int indexRemove = indexOf(o);
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
