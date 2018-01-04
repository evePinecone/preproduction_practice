package com.epam.preprod.roman_lutsenko.util;

import org.apache.log4j.Logger;

public class ParseInputData {

    private static final Logger logger = Logger.getLogger(ParseInputData.class);

    public static String phoneFromString(String string) {
        logger.debug("phone formatted " + string.substring(1));
        return string.substring(1);
    }

}
