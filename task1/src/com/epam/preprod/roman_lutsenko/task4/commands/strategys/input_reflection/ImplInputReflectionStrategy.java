package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input_reflection;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.annotations.SetAnnotation;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputReflectionStrategy;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.ResourceBundle;

public abstract class ImplInputReflectionStrategy<T extends Thing> implements InputReflectionStrategy<T> {
    Class utilClass;

    protected abstract void showInputText(ResourceBundle resourceBundle, String nameField);

    @Override
    public void build(T t, Context context) {
        ResourceBundle resourceBundle = context.getResourceBundle();
        Class clazz = t.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            SetAnnotation annotation = method.getAnnotation(SetAnnotation.class);
            if (Objects.nonNull(annotation)) {
                showInputText(resourceBundle, annotation.name());
                Class typeInput = method.getParameterTypes()[0];
                try {
                    method.invoke(t, findMethodRandom(utilClass, typeInput));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.err.println("Incorrect invokation.");
                }
            }
        }
    }
}
