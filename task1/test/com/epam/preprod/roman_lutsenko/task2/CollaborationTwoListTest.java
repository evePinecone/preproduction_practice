package com.epam.preprod.roman_lutsenko.task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epam.preprod.roman_lutsenko.task2.exceptions.ClearCollaborationTwoListException;
import com.epam.preprod.roman_lutsenko.task2.exceptions.UnmodifiableCollaborationTwoListException;

public class CollaborationTwoListTest {

	private List<String> test;
	private List<String> unmodifiable;
	private List<String> modifiable;

	@Before
	public void setUp() {
		unmodifiable = new ArrayList<>();
		unmodifiable.add("primaryFirst");
		unmodifiable.add("primarySecond");
		unmodifiable.add("primaryThird");

		modifiable = new ArrayList<>();
		modifiable.add("one");
		modifiable.add("two");
		modifiable.add("three");
		modifiable.add("four");
		modifiable.add("five");
		test = new CollaborationTwoList<>(unmodifiable, modifiable);
	}

	@Test(expected = UnmodifiableCollaborationTwoListException.class)
    public void throwsException_whenRemoveFromUnmodifiablePart(){
	    test.remove("primaryFirst");
    }

    @Test
    public void retainAllUnmodifiablePart_listWithoutModifiablePart() {
	    assertTrue(test.retainAll(unmodifiable));
    }

    @Test(expected = UnmodifiableCollaborationTwoListException.class)
    public void retainAllModifiablePart_ThrowUnmodifableCollaborationTwoListException(){
	    test.retainAll(modifiable);
    }

    @Test
    public void retainAllUmodifablePartWithElementOne_listContainsElementOne() {
        List<String> list = new ArrayList<>();
        list.addAll(unmodifiable);
        list.add("one");
        test.retainAll(list);
        assertTrue(test.contains("one"));
    }

    @Test
	public void testIterator() {
		int counter = 0;
		for (String string : test) {
//			System.out.println(string);
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
	public void testRemoveMod() {
		assertTrue(test.remove("one"));
	}

	@Test
	public void testRemoveNone() {
		assertFalse(test.remove("qweqwe"));
	}

	@Test
	public void testContainsAllUnmod() {
		assertTrue(test.containsAll(unmodifiable));
	}

	@Test
	public void testContainsAllMod() {
		assertTrue(test.containsAll(modifiable));
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

	@Test(expected = UnmodifiableCollaborationTwoListException.class)
	public void addingToIndexInUnmodifiblePart_UnmodifableCollaborationTwoListException() {
		test.addAll(0, unmodifiable);
	}

	@Test(expected = ClearCollaborationTwoListException.class)
	public void clearingTestList_exception() {
		test.clear();
	}
	
	@Test
	public void clearListWithOnlyModifiablePart_emptyList() {
		List<String> unmod = new ArrayList<>();
		List<String> mod = new ArrayList<>();
		
		mod.add("qweqwe");
		List<String> list = new CollaborationTwoList<>(unmod, mod);
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void setElementOnModifibleIndex() {
		test.set(4, "qweqwe");
		assertEquals("qweqwe", test.get(4));
	}
	
	@Test
	public void addElementOnModifibleIndex() {
		test.set(4, "qweqwe");
		assertEquals("qweqwe", test.get(4));
	}
	
	@Test
	public void removeElementOnModifibleIndex() {
		test.remove(4);
		assertEquals("three", test.get(4));
	}
	
	@Test(expected = UnmodifiableCollaborationTwoListException.class)
	public void removeElementOnUNmodifibleIndex() {
		test.remove(2);
	}
	
	@Test
	public void indexOfElementTwo_4() {
		assertEquals(4, test.indexOf("two"));
	}
}
