package com.epam.preprod.roman_lutsenko.task5.Chain;

import java.io.File;
import java.util.Scanner;

public class DirectoryFilter extends Filter {

    @Override
    public boolean execute(String directory) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory > ");
        String path = scanner.nextLine();

        File[] files = new File(path).listFiles((dir, name) -> true);

        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
            return executeNext(path);
        }
        return false;
    }

}


