package com.epam.preprod.roman_lutsenko.task2;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBraslet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public class ThingListCOWTest {


	private List<Thing> test;

	@Before
	public void setUp() {
		test = new ThingListCOW<Thing>();
		test.add(new Laptop());
		test.add(new Laptop());
		test.add(2, new FitnessBraslet());
	}
	
	@Test
	public void testIterator() {
		Iterator<Thing> iterator = test.iterator();
		test.add(new Desktop());
		int counter = 0;
		while (iterator.hasNext()) {
			//iterator.next();
			System.out.println(iterator.next());
			counter++;
		}
		assertEquals(counter, 3);
	}
}
