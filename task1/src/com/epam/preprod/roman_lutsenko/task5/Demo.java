package com.epam.preprod.roman_lutsenko.task5;

import com.epam.preprod.roman_lutsenko.task5.Chain.*;

public class Demo {
    public static void main(String[] args) {
        Filter filter = new DirectoryFilter();
        filter.linkWith(new FileNameFilter()).linkWith(new ExtensionFilter()).linkWith(new ShowFiltered());
//        filter.linkWith(new FileNameFilter()).linkWith(new ShowFiltered());
        boolean success;
        do {
            success = filter.execute("");
        } while (!success);
    }
}
