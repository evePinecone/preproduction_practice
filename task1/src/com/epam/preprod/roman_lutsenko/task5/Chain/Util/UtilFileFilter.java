package com.epam.preprod.roman_lutsenko.task5.Chain.Util;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UtilFileFilter {
    public static List<String> findFileByName(String directory) {
        List<String> list = new ArrayList<>();
        //File[] files = new File(directory).listFiles();

        File[] files = new File(directory).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("NAME > " + dir);
                return name.contains(directory);
            }
        });
        if (files == null) {
            throw new NoSuchElementException();
        }
        for (File file : files) {
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
}
