package com.epam.preprod.roman_lutsenko.task5.file_reader;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WrapperReaderFile implements Iterable<String> {

    private Scanner fileScan;
    private static final String ENCODING = "UTF-8";


    public WrapperReaderFile(String fileName) {
        try {
            fileScan = new Scanner(new File(fileName), ENCODING);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ItrImpl();
    }

    private class ItrImpl implements Iterator<String> {

        @Override
        public boolean hasNext() {
            if (fileScan.hasNextLine()) {
                return true;
            }
            fileScan.close();
            return false;
        }

        @Override
        public String next() {
            if (hasNext()) {
                return fileScan.nextLine();
            }
            throw new NoSuchElementException();
        }
    }

}

