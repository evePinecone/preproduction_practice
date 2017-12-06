package com.epam.preprod.roman_lutsenko.task7.proxy_holder;

import com.epam.preprod.roman_lutsenko.task7.entities.Thing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Proxy for interface ThingInterface. Block set operation, make Thing element unmodifable.
 */
public class ThingProxy implements InvocationHandler {
    private Thing thing;
    private final String SET_STRING_CONSTANT = "set";

    public ThingProxy(Thing thing) {
        this.thing = thing;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith(SET_STRING_CONSTANT)) {
            throw new UnsupportedOperationException();
        }
        return method.invoke(thing, args);
    }
}
