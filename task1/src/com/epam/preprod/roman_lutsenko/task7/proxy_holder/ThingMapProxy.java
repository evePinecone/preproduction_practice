package com.epam.preprod.roman_lutsenko.task7.proxy_holder;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThingMapProxy implements InvocationHandler {
    /**
     * container for all fields of Thing element.
     */
    private Map<String, Object> map;

    public ThingMapProxy() {
        map = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String[] string = methodField(method.getName());
        if (isGet(string[0])) {
            if (method.getReturnType().isPrimitive() && !map.containsKey(string[1])) {
                return defaultValue(method.getReturnType());
            }
            return map.get(string[1]);
        }
        if (isSet(string[0])) {
            return map.put(string[1], args[0]);
        }
        return method.invoke(map, args);
    }

    private boolean isGet(String name) {
        return Objects.equals(name, "get");
    }

    private boolean isSet(String name) {
        return Objects.equals(name, "set");
    }

    /**
     * Separates input method to field and method.
     * string [0] - equals method. string[1] - equals field.
     * @param str String to split.
     * @return Array of two string, contains method get or set with field.
     */
    private String[] methodField(String str) {
        return new String[]{str.substring(0, 3), str.substring(3)};
    }

    /**
     * Return default value for primitive type.
     * @param clazz Primitive class.
     * @return default value for clazz type.
     */
    private static  Object defaultValue(Class clazz) {
        return Array.get(Array.newInstance(clazz, 1), 0);
    }
}
