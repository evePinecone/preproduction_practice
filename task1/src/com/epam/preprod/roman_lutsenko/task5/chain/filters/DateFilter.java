package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class DateFilter extends Filter {

    private long timeMin;
    private long timeMax;

    public DateFilter(Filter nextFilter, long timeMin, long timeMax) {
        super(nextFilter);
        this.timeMin = timeMin;
        this.timeMax = timeMax;
    }

    @Override
    public boolean execute(File file) {
        return file.lastModified() >= timeMin && file.lastModified() <= timeMax;
    }
}
