package com.epam.preprod.roman_lutsenko.task3.unique;

import com.epam.preprod.roman_lutsenko.task3.unique.UniqueObjectList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void setUniqueElementByIndexToBegin_getElementTrue() {
        test.set(0, "test");
        assertEquals("test", test.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateElementByAdd_IllegalArgumentException() {
        test.add("test2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateElementByAddWithIndex_IllegalArgumentException() {
        test.add(0, "test2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateCollection_IllegalArgumentException() {
        List<String> list = new ArrayList<String>(test);
        test.addAll(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateElementByCollection_IllegalArgumentException() {
        List<String> list = new ArrayList<String>();
        list.add("test2");
        test.addAll(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingCollectionWithDuplicates_IllegalArgumentException() {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < 2; index++) {
            list.add("index2");
        }
        test.addAll(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingDuplicateElementByCollectionOnPositionIndex_IllegalArgumentException() {
        List<String> list = new ArrayList<String>();
        list.add("test2");
        test.addAll(0, list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingCollectionWithDuplicatesOnPositionIndex_IllegalArgumentException() {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < 5; index++) {
            list.add("index2");
        }
        test.addAll(0, list);
    }

    @Test
    public void replaceAllTest() {
        test.replaceAll(baseString -> baseString + 3);
        assertTrue(test.contains("test03"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceAllwithOneString_waitException() {
        test.replaceAll(baseString -> "test");
    }

}
