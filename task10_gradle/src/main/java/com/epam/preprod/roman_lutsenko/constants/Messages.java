package com.epam.preprod.roman_lutsenko.constants;

/**
 * Container for all log messages.
 */
public class Messages {

    public static final String INITIALIZED = " was inited";
    public static final String DESTROYED = " was destroyed";
    public static final String STARTED = " was started";
    public static final String ENDED = " was ended";
    public static final String LOADED = "Loaded ";
    public static final String REDIRECTED = " was redirected to ";


    //Validation messages
    public static final String VALID_BEGIN_PHONE = "Validation for phone field";
    public static final String VALID_BEGIN_NAME = "Validation for name field";
    public static final String VALID_BEGIN_EMAIL = "Validation for email field";
    public static final String VALID_BEGIN_PASSWORD = "Validation for password field";


    public static final String REGISTRATION_DUPLICATE_USER = "User with such phone is registered";
    public static final String REGISTRATION_NON_VALID_FIELDS = "Some fields are incorrect";

    public static final String GET_METHOD_START = " GET method started";
    public static final String POST_METHOD_START = " POST method started";
    public static final String GET_METHOD_ENDED = " GET method ended";

    //err
    public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
    public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";
    public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
    public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";
    public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
    public static final String ERR_CANNOT_ROLL_BACK_CONNECTION = "Cannot roll back a connection";
    public static final String ERR_CANNOT_INSTANTIATE_DAO_FACTORY = "Cannot instantiate DAOFactory object";


    //success
    public static final String SUCCESS_DATA_SOURCE_OBTAINED = "Data source has been successfully obtained: ";
    public static final String SUCCESS_CONNECTION_CLOSED = "Connection has been successfully closed";
    public static final String SUCCESS_STATEMENT_CLOSED = "Statement has been successfully closed";
    public static final String SUCCESS_RESULTSET_CLOSED = "ResultSet has been successfully closed";
    public static final String SUCCESS_CONNECTION_ROLLED_BACK = "Connection has been rolled back";
    public static final String SUCCESS_DAO_FACTORY_INSTANCE_OBTAINED = "DAOFActory instance has been successfully obtained: ";
}
