package com.epam.preprod.roman_lutsenko.task1.filters;

import java.util.Iterator;

public interface FilterableIterator<T> extends Iterable<T> {
 
	Iterator<T> iterator(Filter<T> filter);
}
