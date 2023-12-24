package com.ivoyant.constants;

public class StringConstants {
    public static final String welcomeText = "Hello Welcome!!\nPassword Generator And Validator";
    public static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    public static final String DIGITS = "0123456789";
    public static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'<>,.?/";
    public static final String OPTION_INFO = "In Your Password....";
    public static final String CHAR_UPPER_REGEX = ".*[A-Z].*";
    public static final String CHAR_LOWER_REGEX = ".*[a-z].*";
    public static final String DIGITS_REGEX = ".*\\d.*";
    public static final String SPECIAL_CHARS_REGEX = ".*[!@#$%^&*()-_=+\\[\\]{}|;:'<>,.?/].*";
    public static final String greatPassword = "Great Password...";
    public static final String mediumPassword = "Medium Password...";
    public static final String goodPassword = "Good Password...";
    public static final String weekPassword = "Weak Password...";
    public static final String yesNoRegex = "^(?i)(y(es)?|no?)$";
    public static final String infoYN = "---------------------Please answer the below " +
            "question with Yes (y) or No (n)---------------------";

    public static final String infoResponse = "Invalid Response!!!\nFor Yes : Please Enter Yes,Y,YES,y " +
            "\nFor No : Please Enter N, No, NO, no, n";

    public static final String passwordLength = "Please enter the password length :";
    public static final String passwordLengthInfo = "Password Length Can't Be 0 or Less Than 0";
    public static final String printPassword = "Generated Password Is : ";
    public static final String inputMismatch = "Expected number for password length";
    public static final String strengthInfo = "Generated Password Strength : ";
}
