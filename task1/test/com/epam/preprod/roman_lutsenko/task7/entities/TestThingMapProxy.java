package com.epam.preprod.roman_lutsenko.task7.entities;

import com.epam.preprod.roman_lutsenko.task7.proxy_holder.ThingMapProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static junit.framework.TestCase.assertEquals;

public class TestThingMapProxy {

    @Test
    public void testThingProxy_setIdEqualGetId() {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingMapProxy());
        thingInterface.setId(123);
        assertEquals(123, thingInterface.getId());
    }

    @Test
    public void testThingProxy_getIdEqualZero() {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingMapProxy());
        assertEquals(0, thingInterface.getId());
    }

    @Test
    public void testThingProxy_getNameModelEqualNull() {
        ThingInterface thingInterface = (ThingInterface) Proxy.newProxyInstance(
                Thing.class.getClassLoader(), Thing.class.getInterfaces(), new ThingMapProxy());
        thingInterface.setId(123);
        assertEquals(null, thingInterface.getNameModel());
    }


}
