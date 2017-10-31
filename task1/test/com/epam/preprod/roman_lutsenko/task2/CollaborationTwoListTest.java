package com.epam.preprod.roman_lutsenko.task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CollaborationTwoListTest {

	private List<String> test;
	private List<String> unmodifable;
	private List<String> modifable;
	
	@Before
	public void setUp() {
		unmodifable = new ArrayList<>();
		unmodifable.add("primaryFirst");
		unmodifable.add("primarySecond");
		unmodifable.add("primaryThird");
		
		modifable = new ArrayList<>();
		modifable.add("one");
		modifable.add("two");
		modifable.add("three");
		modifable.add("four");
		modifable.add("five");
		test = new CollaborationTwoList<>(unmodifable, modifable);
	}
	
	@Test
	public void testIterator() {
		int counter = 0;
		for (String string : test) {
			//System.out.println(string);
			counter++;
		}
		assertEquals(counter, 8);
	}
	
	@Test 
	public void testIsEmpty() {
		List<String> unmod = new ArrayList<>();
		List<String> mod = new ArrayList<>();
		List<String> list = new CollaborationTwoList<>(unmod, mod);
		assertTrue(list.isEmpty());
	}
	
	@Test 
	public void testIsEmptyUnmod() {
		List<String> unmod = new ArrayList<>();
		List<String> mod = new ArrayList<>();
		
		unmod.add("qwe");
		
		List<String> list = new CollaborationTwoList<>(unmod, mod);
		assertFalse(list.isEmpty());
	}
	
	@Test 
	public void testIsEmptyMod() {
		List<String> unmod = new ArrayList<>();
		List<String> mod = new ArrayList<>();
		
		mod.add("qwe");
		
		List<String> list = new CollaborationTwoList<>(unmod, mod);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testContainsUnMod() {
		assertTrue(test.contains("one"));
	}
	
	@Test
	public void testContainsMod() {
		assertTrue(test.contains("primaryFirst"));
	}
	
	@Test
	public void testContains() {
		assertFalse(test.contains("false"));
	}
	
	@Test
	public void testAdd() {
		test.add("qweqwe");
		assertTrue(test.contains("qweqwe"));
	}
	
	@Test
	public void testRemoveUnmod() {
		assertFalse(test.remove("primaryFirst"));
	}
	
	@Test
	public void testRemoveMod() {
		test.remove("one");
		assertFalse(test.contains("one"));
	}
	
	
	@Test
	public void testRemoveNone() {
		assertFalse(test.remove("qweqwe"));
	}
	
	@Test
	public void testContainsAllUnmod() {
		assertTrue(test.containsAll(unmodifable));
	}
	
	@Test
	public void testContainsAllMod() {
		assertTrue(test.containsAll(modifable));
	}
	
	@Test
	public void testContainsAllSelf() {
		assertTrue(test.containsAll(test));
	}

	@Test
	public void testContainsAllOther() {
		List<String> other = new ArrayList<>();
		other.add("qweqwe");
		assertFalse(test.containsAll(other));
	}
	

}
