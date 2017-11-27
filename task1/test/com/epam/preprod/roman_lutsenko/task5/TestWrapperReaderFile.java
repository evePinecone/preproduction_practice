package com.epam.preprod.roman_lutsenko.task5;

import com.epam.preprod.roman_lutsenko.task5.file_reader.WrapperReaderFile;
import org.junit.Test;

public class TestWrapperReaderFile {

    @Test
    public void readFile_waitListWithSixElements() {
        WrapperReaderFile wrapperReaderFile = new WrapperReaderFile("test\\resources\\testTask5");

        for (String string : wrapperReaderFile) {
            System.out.println(string);
        }
    }
}
