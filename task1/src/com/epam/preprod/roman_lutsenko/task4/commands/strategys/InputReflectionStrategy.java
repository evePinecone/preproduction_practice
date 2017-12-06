package com.epam.preprod.roman_lutsenko.task4.commands.strategys;

import com.epam.preprod.roman_lutsenko.task1.entity.Thing;
import com.epam.preprod.roman_lutsenko.task4.context.Context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Interface of creation strategy with reflection.
 *
 * @param <T>
 */
public interface InputReflectionStrategy<T extends Thing> {

    /**
     * Creation method for input thing.
     *
     * @param t       element to create.
     * @param context context of the shop.
     */
    void build(T t, Context context);

    /**
     * Find input static method in utilClass to the type parameter typeMethod.
     * Method need to be with no input parameters.
     * If there is no such method in utilClass returns null value instead input element.
     *
     * @param utilClass  in where class need to find.
     * @param typeMethod type of need element
     * @return crated field or if no such method to creae returns null.
     */
    default Object findMethodRandom(Class utilClass, Class typeMethod) {
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