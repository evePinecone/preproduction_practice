package com.epam.preprod.roman_lutsenko.task5.Chain;

public class ShowFiltered extends Filter {

    @Override
    public boolean execute(String directory) {
        System.out.println("DIRECTORY > " + directory);
        return executeNext(directory);
    }

}
