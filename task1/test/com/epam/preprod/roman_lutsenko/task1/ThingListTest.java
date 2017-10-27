package com.epam.preprod.roman_lutsenko.task1;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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
	
//	@Before
//	public void setUp(){
//		list = new ThingList<Laptop>();
//	}
	
	@Test
	public void testListInit(){
		list = new ThingList<Laptop>();
		assertTrue(list.isEmpty());
	//	assertTrue(list.size() == 0);
	}
	
//	@Test (expected = IllegalArgumentException.class)
//	public void testInvalidCapacity(){
//		list = new ThingList<Thing>(-1);
//	}
	
	
//	@Test (expected = IndexOutOfBoundsException.class)
//	public void testRemoveWithEmptyList(){
//		list.remove(0);
//	}
}