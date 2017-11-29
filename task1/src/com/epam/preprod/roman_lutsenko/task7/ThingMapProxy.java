package com.epam.preprod.roman_lutsenko.task7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThingMapProxy implements InvocationHandler{
    private Map<String, Object> map;

    public ThingMapProxy() {
        map = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String[] string = methodField(method.getName());
        if(isGet(string[0]) && map.containsKey(string[1])) {
            return map.get(string[1]);
        }
        if(isSet(string[0])) {
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

    private String[] methodField(String str) {
        return new String[]{str.substring(0,3), str.substring(3)};
    }
}
