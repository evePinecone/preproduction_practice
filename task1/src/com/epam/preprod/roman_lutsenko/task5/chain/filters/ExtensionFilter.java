package com.epam.preprod.roman_lutsenko.task5.chain.filters;

import java.io.File;

public class ExtensionFilter extends Filter {

    private String extension;

    public ExtensionFilter(Filter filter, String extension) {
        super(filter);
        this.extension = extension;
    }

//    @Override
//    public boolean execute(String directory) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Filter by extension? 1/0");
//        String flag = scanner.nextLine();
//        if (flag.equals("1")) {
//            System.out.println("Enter extension >");
//            String extension = scanner.nextLine();
//
//            File[] files = new File(directory).listFiles(new FilenameFilter() {
//                @Override
//                public boolean accept(File dir, String name) {
//                    //System.err.println(name);
//                    return name.matches(".*" + extension);
//                }
//            });
//            if (files != null && files.length > 0) {
//                for (File file : files) {
//                    if (file.isFile()) {
//                        System.out.println(file);
//                    }
//                }
//                return executeNext(directory + "\\*." + extension);
//            }
//            throw new NoSuchElementException();
//        }
//
//        return executeNext(directory);
//    }

    @Override
    public boolean execute(File file) {
        return file.getName().endsWith(extension);
    }
}
