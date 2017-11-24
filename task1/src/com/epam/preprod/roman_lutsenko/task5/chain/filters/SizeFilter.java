package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class SizeFilter extends Filter{

    private long minSize;
    private long maxSize;

    public SizeFilter(FilterInterface filter, long minSize, long maxSize) {
        super(filter);
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean execute(File file) {
        return file.length() >= minSize && file.length() <= maxSize;
    }
}
