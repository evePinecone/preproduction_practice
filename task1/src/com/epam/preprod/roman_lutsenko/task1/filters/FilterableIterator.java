package com.epam.preprod.roman_lutsenko.task1.filters;

import java.util.Iterator;

public interface FilterableIterator<T> extends Iterable<T> {
 
	public Iterator<T> iterator(Filter<T> filter);
}
