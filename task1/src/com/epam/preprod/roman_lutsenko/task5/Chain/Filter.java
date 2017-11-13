package com.epam.preprod.roman_lutsenko.task5.Chain;

public abstract class Filter {

    private Filter next;

    public Filter linkWith(Filter next) {
        this.next = next;
        return next;
    }

    public abstract boolean execute(String directory);

    protected boolean executeNext(String directory) {
        return next == null || next.execute(directory);
    }

}
