package com.epam.preprod.roman_lutsenko.task5.chain.Util;

import com.epam.preprod.roman_lutsenko.task5.chain.filters.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FilterController {

    private Scanner scanner = new Scanner(System.in);
    private Filter filter;
    private List<File> filteredFileList = new ArrayList<>();
    private String directory;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * Init filter controller with directory.
     */
    public FilterController() {
        System.out.println("Enter directory > ");
        do {
            directory = scanner.nextLine();
        } while (!(new File(directory).isDirectory()));
        //Uncomment to correct file Search.
    }

    public void runController() {

        System.out.println("Filter by name? 1/0");
        String flag = scanner.nextLine();
        if (flag.equals("1")) {
            System.out.println("Enter file name >");
            String fileName = scanner.nextLine();
            filter = new FileNameFilter(filter, fileName);
        }

        System.out.println("Filter by extension? 1/0");
        flag = scanner.nextLine();
        if (flag.equals("1")) {
            System.out.println("Enter extension >");
            String extension = scanner.nextLine();
            filter = new ExtensionFilter(filter, extension);
        }

        System.out.println("Filter by Size? 1/0");
        flag = scanner.nextLine();
        if (flag.equals("1")) {
            System.out.println("Enter min size >");
            long minSize = Long.parseLong(scanner.nextLine());
            System.out.println("Enter min size >");
            long maxSize = Long.parseLong(scanner.nextLine());
            filter = new SizeFilter(filter, minSize, maxSize);
        }

        System.out.println("Filter by date? 1/0");
        flag = scanner.nextLine();
        if (flag.equals("1")) {
            System.out.println("From, in format yyyy-MM-dd >");
            long dateMin = dateValid();
            System.out.println("To, in format yyyy-MM-dd >");
            long dateMax = dateValid();
            filter = new DateFilter(filter, dateMin, dateMax);
        }


        searchFile(new File(directory));
    }

    public List<File> searchFile(File file) {
        File[] files = file.listFiles();
        if(files != null && files.length > 0) {
            for (File file1 : files) {
                if(file1.isDirectory()) {
                    searchFile(file1);
                } else if(filter!= null && filter.execute(file1)) {
                    filteredFileList.add(file1);
                }
            }
        }
        return filteredFileList;
    }

    public void showFiltredList() {
        for (File file : filteredFileList) {
            System.out.println(file);
        }
    }

    private long dateValid() {
        Date valid = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        do {
            try {
                valid = simpleDateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("No such date! please format yyyy-MM-dd");
            }
        } while(valid == null);
        return valid.getTime();
    }
}
