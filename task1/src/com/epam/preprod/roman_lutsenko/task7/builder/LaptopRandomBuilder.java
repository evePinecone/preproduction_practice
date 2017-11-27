package com.epam.preprod.roman_lutsenko.task7.builder;

import com.epam.preprod.roman_lutsenko.task1.entity.Laptop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.util.InputRandomUtil;
import com.epam.preprod.roman_lutsenko.task7.SetAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class LaptopRandomBuilder<T extends Laptop> implements Builder<T> {
    private Class utilClass = InputRandomUtil.class;

    @Override
    public void build(T t) {
        Class clazz = t.getClass();
        do {
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                Annotation annotation = method.getAnnotation(SetAnnotation.class);
                if (!Objects.isNull(annotation)) {
                    Class typeInput = method.getParameterTypes()[0];
                    try {
                     //   System.err.println("TYPE INPUT = " + typeInput + "\n Method input = " + method);
                        method.invoke(t, findMethodRandom(typeInput));// findMethodRandom(typeInput).invoke(utilClass));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.err.println("HEHEHEHEHEHE");
                    }
                }
            }
            clazz = clazz.getSuperclass();
        } while (!Objects.equals(clazz, Thing.class));
    }

    private Object findMethodRandom(Class typeMethod) {
        Object object = null;
        Method[] inputMethods = utilClass.getMethods();
        for (Method inputMethod : inputMethods) {
            if (Objects.equals(inputMethod.getReturnType(), typeMethod)) {
                try {
                    //System.err.println("INPUT METHOD = " + inputMethod);
                    object = inputMethod.invoke(utilClass);
                    break;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
