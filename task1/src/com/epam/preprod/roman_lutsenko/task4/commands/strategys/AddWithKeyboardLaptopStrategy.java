package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;

import java.util.Scanner;

public class AddWithKeyboardLaptopStrategy implements InputStrategy<Laptop> {

    @Override
    public Laptop input(Laptop thing) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id > ");
        thing.setId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter nameModel ");
        thing.setNameModel(scanner.nextLine());
        System.out.println("Enter price ");
        thing.setPrice(Long.parseLong(scanner.nextLine()));
        System.out.println("Enter processors name ");
        thing.setNameProcessor(scanner.nextLine());
        System.out.println("Enter RAM ");
        thing.setRAM(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter displayResolution ");
        thing.setDisplayResolution(Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter weight ");
        thing.setWeight(Double.parseDouble(scanner.nextLine()));
        return thing;
    }
}
