package com.epam.preprod.roman_lutsenko.constants;

public class DBCommands {

    // test table
    public static final String SQL_FIND_ALL_FIELDS = "SELECT * FROM shop.test;";

    //user table
    public static final String SQL_FIND_USER_BY_PHONE = "SELECT * FROM user WHERE phone = ?";
    public static final String SQL_ADD_USER = "INSERT INTO shop.user (name, email, phone, password) VALUES (?, ?, ?, ?)";

}
