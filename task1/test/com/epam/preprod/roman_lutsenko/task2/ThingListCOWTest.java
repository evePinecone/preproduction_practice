package com.epam.preprod.roman_lutsenko.task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBracelet;
import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.roman_lutsenko.task1.ThingList;
import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBraslet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public class ThingListCOWTest {


	private List<Thing> list;

	@Before
	public void setUp() {
		list = new ThingListCOW<Thing>();
	}
	
	@Test
	public void testListInit() {
		list = new ThingList<Laptop>();
		assertTrue(list.isEmpty());
		assertEquals(list.size(), 0);
	}

	@Test
	public void addAllEmptyListAddedListWithOneElement_firstElementEquals(){
	    List<Thing> addedList = new ThingListCOW<>();
	    addedList.add(new Laptop());
	    list.addAll(addedList);
	    assertEquals(list.get(0), addedList.get(0));
    }

    @Test
	public void addAllEmptyListAddedListWithOneElementToZeroPosition_firstElementEquals(){
	    List<Thing> addedList = new ThingListCOW<>();
	    addedList.add(new Laptop());
	    list.addAll(0,addedList);
	    assertEquals(list.get(0), addedList.get(0));
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
	public void addedOneLaptopAndDeleteItByIndex_EmptyCollection() {
		Thing laptop = new Laptop();
		list.add(laptop);
		list.remove(0);
		assertTrue(list.isEmpty());
	}

	@Test
	public void addedOneLaptopAndDeleteItByObject_EmptyCollection() {
		Thing laptop = new Laptop();
		list.add(laptop);
		list.remove(laptop);
		assertTrue(list.isEmpty());
	}

	@Test
	public void copyOfListByOneElementToNewListWithRemovingFrom_NotEqualsLists() {
		list.add(new Laptop());
		list.add(new Desktop());
		Iterator<Thing> iterator = list.iterator();
		list.remove(new Desktop());
		List<Thing> listTest = new ThingListCOW<>();
		while (iterator.hasNext()) {
			listTest.add(iterator.next());
		}
		assertNotEquals(listTest, list);
	}

	@Test
	public void copyOfListByOneElementToNewListWithAdding_NotEqualsLists() {
		Iterator<Thing> iterator = list.iterator();
		list.add(new Desktop());
		List<Thing> listTest = new ThingListCOW<>();
		while (iterator.hasNext()) {
			listTest.add(iterator.next());
		}
		assertNotEquals(listTest, list);
	}

	@Test
    public void containsAllAddedCollectionAllInList_TrueResultOfOperation() {
	    list.add(new FitnessBracelet());
	    list.add(new FitnessBracelet());
	    list.add(new Desktop());
        List<Thing> addedList = new ThingListCOW<>();
        addedList.add(new Laptop());
        addedList.add(new Desktop());
        list.addAll(addedList);
        assertTrue(list.containsAll(addedList));
    }

	@Test
	public void setElementOnZeroPosition_OnFirstPositionLaptop() {
		list.add(new Desktop());
		list.set(0, new Laptop());
		assertEquals(new Laptop(),list.get(0));
	}
}
