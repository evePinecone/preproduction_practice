package com.epam.preprod.roman_lutsenko.task2;

public class Test {

    public static void main(String[] args) {
        int mas[] = new int[10];

        for(int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
        System.out.println(mas.toString());
        System.out.println("\nSPACE BETWEEN ARRAYS");
        for (int ma : mas) {
            System.out.print(ma + " ");
        }
    }
}
