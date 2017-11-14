package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

@Deprecated
public class DirectoryFilter extends Filter {

    private String directory;

    public DirectoryFilter(Filter filter, String directory) {
        super(filter);
        this.directory = directory;
    }

    @Override
    public boolean execute(File file) {
        //File[] files = new File(directory).listFiles((dir, name) -> true);
        return file.isDirectory();
    }

}


