package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public abstract class Filter implements FilterInterface {

    private FilterInterface next;

    public Filter(FilterInterface nextFilter) {
        next = nextFilter;
    }

//    public boolean nextExecute(File file){
//        if(next != null) {
//            return execute(file) && next.nextExecute(file);
//        }
//        return execute(file);
//    }
}
