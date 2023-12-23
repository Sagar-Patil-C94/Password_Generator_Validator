package com.ivoyant;

import com.ivoyant.constants.LoggerConstants;
import com.ivoyant.constants.StringConstants;
import com.ivoyant.logger.CustomLogger;
import com.ivoyant.password.PasswordGenerate;
import com.ivoyant.password.PasswordInfo;
import com.ivoyant.password.PasswordValidator;

public class App {
    public static void main(String[] args) {
        // log message
        CustomLogger.info(LoggerConstants.appStart);
        // welcome message
        System.out.println(StringConstants.welcomeText);
        // password tips to users
        PasswordInfo.info();
        // calling password generator and in turn validating the same
        PasswordValidator.validate(PasswordGenerate.generate());
    }
}