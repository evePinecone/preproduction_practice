package com.epam.preprod.roman_lutsenko.task5;

import org.junit.Test;

public class TestWrapperReaderFile {

    @Test
    public void readFile_waitListWithSixElements() {
        WrapperReaderFile wrapperReaderFile = new WrapperReaderFile("testTask5");

        for (String string : wrapperReaderFile) {
            System.out.println(string);
        }
    }
}
