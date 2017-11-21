package com.epam.preprod.roman_lutsenko.task4.commands;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputStrategy;
import com.epam.preprod.roman_lutsenko.task4.constants.containers.EntityContainer;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.context.StrategyContext;

import java.util.Scanner;

public class AddThingCommand implements Command {

    @Override
    public void execute(Context context) {
        StrategyContext strategyContext = context.getStrategyContext();

        Thing thing = chooseThingToADD();
        InputStrategy inputStrategy = strategyContext.get(thing.getClass());
        inputStrategy.input(thing);
        context.getLocalProductService().put(thing);
        //из этой команды передавать выбранный элемент в инпут
        //сделать сущности Computer и PortableGadget абстрактными, в базовом классе сделать абстрактный метод build.
    }

    private Thing chooseThingToADD() {
        EntityContainer.show();
        //дергать с ютилки врапер ввода.
        Scanner scanner = new Scanner(System.in);
        return new EntityContainer().getEntity(scanner.nextLine());
    }

}
