package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class ExtensionFilter extends Filter {

    private String extension;

    public ExtensionFilter(Filter filter, String extension) {
        super(filter);
        this.extension = extension;
    }

    @Override
    public boolean execute(File file) {
        return file.getName().endsWith(extension);
    }
}
