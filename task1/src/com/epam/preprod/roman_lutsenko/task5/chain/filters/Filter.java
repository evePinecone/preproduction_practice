package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public abstract class Filter {

    private Filter next;

    public Filter(Filter nextFilter) {
        next = nextFilter;
    }

    public abstract boolean execute(File file);

    public boolean nextExecute(File file){
        if(next != null) {
            return execute(file) && next.nextExecute(file);
        }
        return execute(file);
    }

    /*protected boolean executeNext(String directory) {
        return next == null || next.execute(directory);
    } */

}
