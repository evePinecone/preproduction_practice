package com.epam.preprod.roman_lutsenko.task9.util;

import java.io.File;

public class ParseHttpRequest {

//    public static String[] getAttributesOfRequest(String string) {
//
//    }

    // "вырезает" из строки str часть, находящуюся между строками start и end
    // если строки end нет, то берётся строка после start
    // если кусок не найден, возвращается null
    // для поиска берётся строка до "\n\n" или "\r\n\r\n", если таковые присутствуют
    public static String extract(String str, String start, String end) {
        int separator = str.indexOf("\n\n", 0);
        int element;
        if (separator < 0) {
            separator = str.indexOf("\r\n\r\n", 0);
        }
        if (separator > 0) {
            str = str.substring(0, separator);
        }
        separator = str.indexOf(start, 0) + start.length();
        if (separator < start.length()) {
            return null;
        }
        element = str.indexOf(end, separator);
        if (element < 0) element = str.length();
        return (str.substring(separator, element)).trim();
    }

    // "вырезает" из HTTP заголовка URI ресурса и конвертирует его в filepath
    // URI берётся только для GET и POST запросов, иначе возвращается null
    public static String getPath(String header) {
        String URI = extract(header, "GET ", " "), path;
        if (URI == null) URI = extract(header, "POST ", " ");
        if (URI == null) return null;

        path = URI.toLowerCase();
        if (path.indexOf("http://", 0) == 0) {
            URI = URI.substring(7);
            URI = URI.substring(URI.indexOf("/", 0));
        } else if (path.indexOf("/", 0) == 0)
            URI = URI.substring(1);

        // отсекаем из URI часть запроса, идущего после символов ? и #
        int i = URI.indexOf("?");
        if (i > 0) URI = URI.substring(0, i);
        i = URI.indexOf("#");
        if (i > 0) URI = URI.substring(0, i);

        //Document to find situated on absolute path begins with D:/
        path = "" + File.separator;
        char a;
        for (i = 0; i < URI.length(); i++) {
            a = URI.charAt(i);
            if (a == '/')
                path = path + File.separator;
            else
                path = path + a;
        }
        return path;
    }

}
