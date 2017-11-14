package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class SizeFilter extends Filter{

    private long minSize;
    private long maxSize;

    public SizeFilter(Filter filter, long minSize, long maxSize) {
        super(filter);
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

//    @Override
//    public boolean execute(String directory) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Filter by Size? 1/0");
//        String flag = scanner.nextLine();
//        if (flag.equals("1")) {
//            System.out.println("Enter min size >");
//            long minSize = Long.parseLong(scanner.nextLine());
//            System.out.println("Enter min size >");
//            long maxSize = Long.parseLong(scanner.nextLine());
//
//
//            File[] files = new File(directory).listFiles(new FilenameFilter() {
//                @Override
//                public boolean accept(File dir, String name) {
//                    // NONE LOGIC
//
//                    System.err.println(dir);
//                    return true;
//                }
//            });
//            if (files != null && files.length > 0) {
//                for (File file : files) {
//                    if (file.isFile()) {
//                        System.out.println(file);
//                    }
//                }
//                return executeNext(directory);
//            }
//            throw new NoSuchElementException();
//        }
//
//        return executeNext(directory);
//    }

    @Override
    public boolean execute(File file) {
        return file.length() >= minSize && file.length() <= maxSize;
    }
}
