package com.epam.preprod.roman_lutsenko.task1;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBraslet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

public class Demo {

	public static void main(String[] args) {
	// 	hand-made tests
		ThingList<Laptop> test = new ThingList<>();
		test.add(new Laptop());
		test.add(null);
		test.add(new Desktop());
		test.remove(0);
		System.out.println(test);
		System.out.println(test.size());
		
		test.add(new Laptop());
		test.add(2, new FitnessBraslet());
		System.out.println(test);
		System.out.println(test.get(3));
		test.add(new Laptop());
		System.out.println("_______________________________________");
		for (Thing thing : test) {
			System.out.println(thing + System.lineSeparator());
		}
	}

}
