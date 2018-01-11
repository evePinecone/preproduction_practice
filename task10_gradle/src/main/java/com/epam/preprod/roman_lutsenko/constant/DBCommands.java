package com.epam.preprod.roman_lutsenko.constant;

public class DBCommands {

    // test table
    public static final String SQL_FIND_ALL_FIELDS = "SELECT * FROM shop.test;";

    //user table
    //select
    public static final String SQL_FIND_USER_BY_PHONE = "SELECT * FROM shop.user WHERE phone=?";

    //insert
    public static final String SQL_ADD_USER = "INSERT INTO shop.user (name, email, phone, password) VALUES (?, ?, ?, ?)";

    //delete
    public static final String SQL_REMOVE_USER_BY_PHONE = "DELETE FROM shop.user WHERE phone = ?";

}
