package com.epam.preprod.roman_lutsenko.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

/**
 * Testing the ArrayList implementation.
 * 
 * @author Roman_Lutsenko
 *
 */
public class ThingListTest {

	private List<Thing> list;

	@Before
	public void setUp() {
		list = new ThingList<Laptop>();
	}

	@Test
	public void testListInit() {
		list = new ThingList<Laptop>();
		assertTrue(list.isEmpty());
		assertTrue(list.size() == 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCapacity() {
		list = new ThingList<Thing>(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveWithEmptyList() {
		list.remove(0);
	}

	@Test
	public void testAddElements() {
		list.add(new Laptop());
		list.add(new FitnessBracelet());

		assertEquals(new Laptop(), list.get(0));
		assertEquals(new FitnessBracelet(), list.get(1));

		list.add(1, new Desktop());

		assertEquals(new Laptop(), list.get(0));
		assertEquals(new Desktop(), list.get(1));
		assertEquals(new FitnessBracelet(), list.get(2));

		assertTrue(list.size() == 3);
	}

	@Test
	public void testRemoveByIndex() {
		Thing laptop = new Laptop();
		list.add(laptop);
		list.remove(0);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testRemoveByObj() {
		Thing laptop = new Laptop();
		list.add(laptop);
		list.remove(laptop);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testIterator() {
		Thing laptop = new Laptop();
		Thing desktop = new Desktop();
		Thing fit = new FitnessBracelet();
		laptop.setPrice(5000);
		
		list.add(laptop);
		list.add(desktop);
		list.add(fit);
		int counter = 0;
		for (Thing thing : list) {
			System.out.println(thing);
			counter++;
		}
		assertEquals(counter, 1);
	}
	
	// Problem with iterator testing.
}