package com.epam.preprod.roman_lutsenko.task1.filters;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

/**
 * Filter to highlight a laptop with price over 3000.
 * 
 * @author Roman_Lutsenko
 *
 * @param <T>
 */
public class ThingFilter<T extends Thing> implements Filter<T> {

	@Override
	public boolean accept(T thing) {
		if (thing instanceof Laptop) {
			if (thing.getPrice() > 3000) {
				return true;
			}
		}
		return false;
	}

}
