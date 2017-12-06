package com.epam.preprod.roman_lutsenko.task7.entities;

import com.epam.preprod.roman_lutsenko.task7.proxy_holder.ThingProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static junit.framework.TestCase.assertEquals;

public class TestThingProxy {

    @Test(expected = UnsupportedOperationException.class)
    public void testThingProxyThrowingException() {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingProxy(new Thing()));
        thingInterface.setId(123);
    }

    @Test
    public void testThingProxy_setIdEqualGetId() {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingProxy(new Thing()));
        assertEquals(0, thingInterface.getId());
    }
}
