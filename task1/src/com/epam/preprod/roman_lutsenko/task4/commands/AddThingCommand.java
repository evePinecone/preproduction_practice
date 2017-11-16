package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
import com.epam.preprod.roman_lutsenko.task4.constants.EntityContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.util.Scanner;

public class AddThingCommand implements Command {

    @Override
    public void execute(Context context) {
        InputStrategy inputStrategy = context.getInputStrategy();

        Thing thing = inputStrategy.input(chooseThingToADD());
        context.getLocalProductService().put(thing);
        //из этой команды передавать выбранный элемент в инпут
        //сделать сущности Computer и PortableGadget абстрактными, в базовом классе сделать абстрактный метод build.
    }

    public Thing chooseThingToADD() {
        EntityContainer.show();
        Scanner scanner = new Scanner(System.in);
        return  new EntityContainer().getEntity(scanner.nextLine());
    }

}
