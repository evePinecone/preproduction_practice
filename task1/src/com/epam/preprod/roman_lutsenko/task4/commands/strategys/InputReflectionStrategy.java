package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public interface InputReflectionStrategy<T extends Thing> {

    void build(T t, Context context);

    public default Object findMethodRandom(Class utilClass, Class typeMethod) {
        Object object;
        Method[] inputMethods = utilClass.getMethods();
        for (Method inputMethod : inputMethods) {
            if (Objects.equals(inputMethod.getReturnType(), typeMethod) && inputMethod.getParameterTypes().length == 0) {
                try {
                    object = inputMethod.invoke(utilClass);
                    return object;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
