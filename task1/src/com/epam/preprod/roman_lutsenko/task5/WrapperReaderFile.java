package com.epam.preprod.roman_lutsenko.task5;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;

public class WrapperReaderFile implements Iterable<String>{

    Scanner fileScan;

    public WrapperReaderFile(String fileName) {
        try {
            fileScan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ItrImpl();
    }

    private class ItrImpl implements Iterator<String>{

        Scanner scan;

        ItrImpl(){
            scan = fileScan;
        }

        @Override
        public boolean hasNext() {
            return scan.hasNextLine();
        }

        @Override
        public String next() {
            if(hasNext()){
                return scan.nextLine();
            }
            throw new NoSuchElementException();
        }
    }

}

