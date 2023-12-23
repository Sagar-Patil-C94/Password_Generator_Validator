package com.ivoyant.password;

import com.ivoyant.constants.StringConstants;

public class PasswordValidator {
    private static int getScore(String password) {
        // if password is generated successfully
        if (password != null) {
            // variable to store password score
            int score = 0;
            // if password consists of uppercase letter then increment score
            if (password.matches(StringConstants.CHAR_UPPER_REGEX)) {
                score++;
            }
            // if password consists of lowercase letter then increment score
            if (password.matches(StringConstants.CHAR_LOWER_REGEX)) {
                score++;
            }
            // if password consists of digits then increment score
            if (password.matches(StringConstants.DIGITS_REGEX)) {
                score++;
            }
            // if password consists of special characters then increment score
            if (password.matches(StringConstants.SPECIAL_CHARS_REGEX)) {
                score++;
            }
            // if password length is greater than 8 then increment score
            if (password.length() >= 8) {
                score++;
            }
            // if password length is greater than 16 then increment score
            if (password.length() >= 16) {
                score++;
            }
            return score;
        }
        // if password is null
        return -1;
    }

    public static void validate(String password) {
        // getting the password score
        int score = getScore(password);
        if (score != -1) {
            // if all conditions is obeyed
            if (score == 6) {
                System.out.println(StringConstants.strengthInfo + StringConstants.greatPassword);
            }
            // if any 4 or more conditions is obeyed
            else if (score >= 4) {
                System.out.println(StringConstants.strengthInfo + StringConstants.goodPassword);
            }
            // if any 2 or more conditions is obeyed
            else if (score >= 2) {
                System.out.println(StringConstants.strengthInfo + StringConstants.mediumPassword);
            }
            // if only 1 condition is obeyed
            else {
                System.out.println(StringConstants.strengthInfo + StringConstants.weekPassword);
            }
        }
    }
}
