package com.epam.preprod.roman_lutsenko.task4.constants.containers;

import com.epam.preprod.roman_lutsenko.task1.entity.*;

import java.util.Map;
import java.util.TreeMap;

import static com.epam.preprod.roman_lutsenko.task4.constants.CommandConstants.*;

public class EntityContainer {

    private Map<String, Thing> strategyList = new TreeMap<>();

    public EntityContainer() {
        //Here put elements.
        strategyList.put(ENTITY_ID_LAPTOP, new Laptop());
        strategyList.put(ENTITY_ID_DESKTOP, new Desktop());
        strategyList.put(ENTITY_ID_FITNESS_BRACELET, new FitnessBracelet());
        strategyList.put(ENTITY_ID_NO_SUCH_ENTITY, new NoSuchEntity());
    }

    public Thing getEntity(String key) {
        if (strategyList.containsKey(key) && key != null) {
            return strategyList.get(key);
        }
        return strategyList.get(ENTITY_ID_NO_SUCH_ENTITY);
    }

    public static void show() {
        System.out.println("1. Laptop");
        System.out.println("2. Desktop");
        System.out.println("3. FitnessBracelet");
    }
}
