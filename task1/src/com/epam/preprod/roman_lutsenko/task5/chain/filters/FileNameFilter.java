package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class FileNameFilter extends Filter {

    private String fileName;

    public FileNameFilter(Filter filter, String fileName) {
        super(filter);
        this.fileName = fileName;
    }


//    public boolean execute(String directory) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Filter by name? 1/0");
//        String flag = scanner.nextLine();
//        if (flag.equals("1")) {
//            System.out.println("Enter file name >");
//            String fileName = scanner.nextLine();
//
//            File[] files = new File(directory).listFiles(new FilenameFilter() {
//                @Override
//                public boolean accept(File dir, String name) {
//                    return name.matches(fileName + ".*");
//                }
//            });
//            if (files != null && files.length > 0) {
//                for (File file : files) {
//                    if (file.isFile()) {
//                        System.out.println(file);
//                    }
//                }
//                return executeNext(directory + "\\" + fileName);
//            }
//            throw new NoSuchElementException();
//        }
//
//        return executeNext(directory);
//    }

    @Override
    public boolean execute(File file) {
        return file.getName().matches(fileName + ".*");
    }
}
