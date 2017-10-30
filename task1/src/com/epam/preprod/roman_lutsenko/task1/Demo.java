package com.epam.preprod.roman_lutsenko.task1;

import java.util.List;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.FitnessBraslet;
import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.PortableGadget;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task2.ThingListCOW;

public class Demo {

	public static void main(String[] args) {
	// 	hand-made tests
		List<Thing> test = new ThingListCOW<>();
		test.add(new Laptop());
		test.add(null);
		test.add(new Desktop());
		test.remove(0);
		System.out.println(test);
		System.out.println(test.size());
		
		Laptop laptop = new Laptop();
		laptop.setPrice(5000);
		test.add(laptop);
		test.add(new Laptop());
		test.add(2, new FitnessBraslet());
		System.out.println(test);
		System.out.println(test.get(3));
		test.add(new Laptop());
		System.out.println("_______________________________________");
		for (Thing thing : test) {
			test.add(new PortableGadget());
			System.out.println(thing + System.lineSeparator());
		}
		System.out.println("_______________________________________");
		for (Thing thing : test) {
			System.out.println(thing + System.lineSeparator());
		}
	}

}
