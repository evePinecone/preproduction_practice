package com.epam.preprod.roman_lutsenko.task9.util;

/**
 * Util class for parsing TCP request.
 */
public class ParseTcpRequest {

    public static String[] parseToRequestAndAttr(String string){
        return string.split("=");
    }
}
