package com.epam.preprod.roman_lutsenko.task5;


import com.epam.preprod.roman_lutsenko.task5.chain.Util.FilterController;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.FileNameFilter;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.Filter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFilterController {

    private Filter filter;
    private static final String DIRECTORY = "C:\\Users\\Roman_Lutsenko\\preproduction_practice\\preproduction_practice\\task1\\test\\resources";

    @Before
    public void init(){

    }

    @Test
    public void listAllFilesInResourcesFolder(){

        System.setIn(new ByteArrayInputStream(DIRECTORY.getBytes()));
        FilterController filterController = new FilterController();
        System.setIn(System.in);
        String fileName = "testTask5";
        filter = new FileNameFilter(filter, fileName);

        filterController.setFilter(filter);
        List<File> list = filterController.searchFile(new File(DIRECTORY));


        List<File> listTrue = new ArrayList<>();
        listTrue.add(new File(DIRECTORY + "\\" +
                "testTask5"));
        System.setIn(System.in);
        assertEquals(list.get(0), listTrue.get(0));
    }
}
