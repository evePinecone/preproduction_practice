package com.epam.preprod.roman_lutsenko.task4.test_serialize;

import com.epam.preprod.roman_lutsenko.task1.entity.Desktop;
import com.epam.preprod.roman_lutsenko.task1.entity.Thing;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class DemoSerializationOneThing {

    private static final String SERIALIZE_PRODUCT_FILE_NAME_PATH = "task1\\test\\resources\\testSerialization.out";
    private static final String GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH = "task1\\test\\resources\\testGZIPSerialization.out";
    private static final int NUMBER_OF_ELEMENT_TO_ADD_INTO_MAP = 6;

    private Map<Integer, Thing> map;

    public Map<Integer, Thing> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Thing> map) {
        this.map = map;
    }

    public static void main(String[] args) throws IOException {

        DemoSerializationOneThing test = new DemoSerializationOneThing();
        test.setMap(test.fill());

        test.serializeProduct();
        test.gZIPSerializeProduct();

    }

    private void serializeProduct() {
        System.err.println("Length Serialize begin >" + new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZE_PRODUCT_FILE_NAME_PATH))) {
            for (int index = 0; index < 10; index++) {
                oos.writeObject(map);
            }
        } catch (IOException e) {
            System.err.println("Err Serialize");
        }
        System.err.println("Length Serialize end >" + new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        new File(SERIALIZE_PRODUCT_FILE_NAME_PATH).delete();
    }

    private void gZIPSerializeProduct() {
        System.err.println("Length GZIPSerialize begin >" + new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH)))) {
            for (int index = 0; index < 10; index++) {
                oos.writeObject(map);
            }
        } catch (IOException e) {
            System.err.println("Err GZIPSerialize");
        }
        System.err.println("GZIPLength Serialize end >" + new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).length());
        new File(GZIP_SERIALIZE_PRODUCT_FILE_NAME_PATH).delete();
    }


    private Map<Integer, Thing> fill() {
        Map<Integer, Thing> map = new HashMap<>();
        for (int index = 1; index < NUMBER_OF_ELEMENT_TO_ADD_INTO_MAP; index++) {
            Desktop desktop = new Desktop();
            desktop.setId(index);
            desktop.setPrice(index * 100);
            desktop.setNameModel("desktop" + index);
            map.put(desktop.getId(), desktop);
        }
        return map;
    }
}
