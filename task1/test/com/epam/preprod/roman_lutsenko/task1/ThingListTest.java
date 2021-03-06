package com.epam.preprod.roman_lutsenko.task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.manipulation.Filter;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task1.filters.ThingFilter;

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
		list = new ThingList<Thing>();
	}

	@Test
	public void addingToTheEmptyListNewCollectionWithOneElement_lsitWithOneElementInto() {
		List<Thing> added = new ThingList<Thing>();
		added.add(new Laptop());
		list.addAll(added);
		System.out.println(added);
		assertEquals(list.get(0), added.get(0));
	}
	
	@Test
	public void testListInit() {
		list = new ThingList<Laptop>();
		assertTrue(list.isEmpty());
		assertEquals(list.size(),0);
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
	public void testFiltredIterator_resultListContainsOneLaptop() {
		Thing laptop = new Laptop();
		Thing desktop = new Desktop();
		Thing fit = new FitnessBracelet();
		laptop.setPrice(5000);

		list.add(laptop);
		list.add(desktop);
		list.add(fit);

		Iterator<Thing> iterator = ((ThingList<Thing>) list).iterator(new ThingFilter<Thing>());
		list.add(new Desktop());

		List<Thing> testList = new ThingList<>();
		while (iterator.hasNext()) {
			testList.add(iterator.next());
		}
		assertTrue(testList.contains(laptop));
	}

}