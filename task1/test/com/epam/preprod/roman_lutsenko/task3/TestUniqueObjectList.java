package com.epam.preprod.roman_lutsenko.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.roman_lutsenko.task3.UniqueObjectList;

public class TestUniqueObjectList {

	List<String> test;

	@Before
	public void initTest() {
		test = new UniqueObjectList<String>();
		for (int index = 0; index < 5; index++) {
			test.add("test" + index);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void SetDuplicateElementByIndexToBegin_IllegalArgumentException() {
		test.set(0, "test2");
	}

	@Test
	public void SetUniqueElementByIndexToBegin_getElementTrue() {
		test.set(0, "test");
		assertEquals("test", test.get(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingDuplicateElementByAdd_IllegalArgumentException() {
		test.add("test2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingDuplicateElementByAddWithIndex_IllegalArgumentException() {
		test.add(0, "test2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingDuplicateCollection_IllegalArgumentException() {
		List<String> list = new ArrayList<String>(test);
		test.addAll(list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingDuplicateElementByCollection_IllegalArgumentException() {
		List<String> list = new ArrayList<String>();
		list.add("test2");
		test.addAll(list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingCollectionWithDuplicates_IllegalArgumentException() {
		List<String> list = new ArrayList<String>();
		for (int index = 0; index < 5; index++) {
			list.add("index2");
		}
		test.addAll(list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingDuplicateElementByCollectionOnPositionIndex_IllegalArgumentException() {
		List<String> list = new ArrayList<String>();
		list.add("test2");
		test.addAll(0, list);
	}

	@Test(expected = IllegalArgumentException.class)
	public void AddingCollectionWithDuplicatesOnPositionIndex_IllegalArgumentException() {
		List<String> list = new ArrayList<String>();
		for (int index = 0; index < 5; index++) {
			list.add("index2");
		}
		test.addAll(0, list);
	}

	@Test
	public void replaceAllTest() {
		test.replaceAll(String -> String + 3);
		assertTrue(test.contains("test03"));
	}

}
