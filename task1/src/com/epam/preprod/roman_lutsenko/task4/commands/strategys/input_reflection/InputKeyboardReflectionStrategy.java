package com.epam.preprod.roman_lutsenko.task4.commands.strategys.input_reflection;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;
import com.epam.preprod.roman_lutsenko.task4.util.InputUtil;
import com.epam.preprod.roman_lutsenko.task4.annotations.SetAnnotation;
import com.epam.preprod.roman_lutsenko.task4.commands.strategys.InputReflectionStrategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.ResourceBundle;

public class InputKeyboardReflectionStrategy<T extends Thing> implements InputReflectionStrategy<T> {
    private Class utilClass = InputUtil.class;

    @Override
    public void build(T t, Context context) {
        ResourceBundle resourceBundle = context.getResourceBundle();
        Class clazz = t.getClass();
        // do {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            SetAnnotation annotation = method.getAnnotation(SetAnnotation.class);
            if (!Objects.isNull(annotation)) {
                System.out.println(resourceBundle.getString("enter")+ " "
                        + resourceBundle.getString(annotation.name()));
                Class typeInput = method.getParameterTypes()[0];
                try {
                    method.invoke(t, findMethodRandom(typeInput));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.err.println("HEHEHEHEHEHE");
                }
            }
        }
        //   clazz = clazz.getSuperclass();
        //} while (!Objects.equals(clazz, Thing.class));
    }

    private Object findMethodRandom(Class typeMethod) {
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
