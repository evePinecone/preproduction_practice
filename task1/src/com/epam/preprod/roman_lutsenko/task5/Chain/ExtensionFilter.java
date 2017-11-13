package com.epam.preprod.roman_lutsenko.task5.Chain;

import java.io.File;
import java.io.FilenameFilter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExtensionFilter extends Filter {

    @Override
    public boolean execute(String directory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Filter by extension? 1/0");
        String flag = scanner.nextLine();
        if (flag.equals("1")) {
            System.out.println("Enter extension >");
            String extension = scanner.nextLine();

            File[] files = new File(directory).listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    //System.err.println(name);
                    return name.matches(".*" + extension);
                }
            });
            if (files != null && files.length > 0) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println(file);
                    }
                }
                return executeNext(directory + "\\*." + extension);
            }
            throw new NoSuchElementException();
        }

        return executeNext(directory);
    }

}
