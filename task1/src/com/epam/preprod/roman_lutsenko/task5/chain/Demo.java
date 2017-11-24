package com.epam.preprod.roman_lutsenko.task5.chain;

import java.io.File;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        FilterController filterController = new FilterController();
        List<File> fileList = filterController.filterFiles();
        for (File file : fileList) {
            System.out.println(file);
        }
    }
}