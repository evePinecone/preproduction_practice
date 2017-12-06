package com.epam.preprod.roman_lutsenko.task7;

import com.epam.preprod.roman_lutsenko.task7.entities.Thing;
import com.epam.preprod.roman_lutsenko.task7.entities.ThingInterface;
import com.epam.preprod.roman_lutsenko.task7.proxy_holder.ThingMapProxy;

import java.lang.reflect.Proxy;

public class Demo {
    public static void main(String[] args) {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingMapProxy());
        thingInterface.setId(123);
//        thingInterface.setPrice(123);
        System.out.println("Name Model = " + thingInterface.getNameModel());
        System.out.println("Proxy map" + thingInterface);
    }
}
