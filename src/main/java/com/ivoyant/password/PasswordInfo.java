package com.ivoyant.password;

import com.ivoyant.logger.CustomLogger;

public class PasswordInfo {
    public static void info() {
        // log message
        CustomLogger.info("Displaying the password security tips");
        // password security tips
        System.out.println("-------------------------Password Security Tips-----------------------------");
        System.out.println("Tip : Avoid using the same password twice for different accounts.");
        System.out.println("Tip : Avoid repeating characters in your password Eg..XXyZ@13");
        System.out.println("Tip : Avoid using keyboard patterns in your password Eg..qwerty,1234");
        System.out.println("Tip : Avoid using common dictionary words in password Eg..password,123456");
        System.out.println("Tip : Avoid using predictable letter or number sequences in your password");
    }

}
