package com.epam.preprod.roman_lutsenko.task5.chain;

import com.epam.preprod.roman_lutsenko.task5.chain.Util.FilterContainer;
import com.epam.preprod.roman_lutsenko.task5.chain.filters.FilterInterface;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterController {

    private Scanner scanner = new Scanner(System.in);
    private FilterInterface filter;
    private List<File> filteredFileList = new ArrayList<>();
    private String directory;
    private FilterContainer filterContainer = new FilterContainer();

    public void setFilter(FilterInterface filter) {
        this.filter = filter;
    }

    /**
     * Init filter controller with directory.
     */
    public FilterController() {
        System.out.println("Enter directory > ");
        do {
            directory = scanner.nextLine();
        } while (!(new File(directory).isDirectory()));
    }

    public List<File> filterFiles() {
        filter = filterContainer.filterByName(scanner, filter);

        filter = filterContainer.filterByExtencion(scanner, filter);

        filter = filterContainer.filterBySize(scanner, filter);

        filter = filterContainer.filterByDate(scanner, filter);

        System.out.println("End of filers list. Wait for result.");

        return searchFile(new File(directory));
    }

    public List<File> searchFile(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    searchFile(file1);
                } else if (filter != null && filter.execute(file1)) {
                    filteredFileList.add(file1);
                }
            }
        }
        return filteredFileList;
    }
}
