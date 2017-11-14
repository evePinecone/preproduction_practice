package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class FileNameFilter extends Filter {

    private String fileName;

    public FileNameFilter(Filter filter, String fileName) {
        super(filter);
        this.fileName = fileName;
    }

    @Override
    public boolean execute(File file) {
        return file.getName().matches(fileName + ".*");
    }
}
