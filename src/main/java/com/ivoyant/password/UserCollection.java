package com.ivoyant.password;

import com.ivoyant.constants.StringConstants;

import java.util.HashMap;
import java.util.Map;

public class UserCollection {
    // map which store question as key and related characters as value
    public static Map<String, String> userOptions = new HashMap<>();
    // map which store characters as key and boolean value as value which is accepted by user
    public static Map<String, Boolean> userResponses = new HashMap<>();

    // method which return the question and characters map
    public static Map<String, String> getUserOptions() {
        userOptions.put("Do you need to have UpperCase Letters?", StringConstants.CHAR_UPPER);
        userOptions.put("Do you need to have LowerCase Letters?", StringConstants.CHAR_LOWER);
        userOptions.put("Do you need to have Numbers?", StringConstants.DIGITS);
        userOptions.put("Do you need to have Special Characters?", StringConstants.SPECIAL_CHARS);
        return userOptions;
    }
}
