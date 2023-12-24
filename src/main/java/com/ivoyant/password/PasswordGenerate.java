package com.ivoyant.password;

import com.ivoyant.constants.LoggerConstants;
import com.ivoyant.constants.StringConstants;
import com.ivoyant.logger.CustomLogger;

import java.security.SecureRandom;
import java.util.*;

public class PasswordGenerate {
    // for accepting inputs form user
    private static final Scanner scanner = new Scanner(System.in);
    // method which generate and return generated password
    public static String generate() throws InputMismatchException {
        // displaying what to enter as a response
        System.out.println(StringConstants.infoYN);
        // string variable to store response
        String response;
        // maps defined in user collections
        Map<String, String> userOptions = UserCollection.getUserOptions();
        Map<String, Boolean> userResponses = UserCollection.userResponses;
        // printing each question and accepting the response from user
        for (String question : userOptions.keySet()) {
            System.out.println(StringConstants.OPTION_INFO);
            System.out.println(question);
            response = scanner.nextLine();
            // using regex which is defined as string to check whether user entered yes or no
            if (response.matches(StringConstants.yesNoRegex)) {
                // if any one case is entered by user then response will be yes, else no
                userResponses.put(userOptions.get(question), Objects.equals(response, "y") ||
                        Objects.equals(response, "Y") || Objects.equals(response, "yes") ||
                        Objects.equals(response, "Yes") || Objects.equals(response, "YES"));
            }
            // if user entered other than yes or no
            else {
                CustomLogger.error(LoggerConstants.yesNoResponse);
                System.out.println(StringConstants.infoResponse);
                CustomLogger.info(LoggerConstants.exitApplication);
                return null;
            }
        }
        // getting password length
        System.out.print(StringConstants.passwordLength);
        // variable to store accepted input
        int passwordLength;
        // exception handling if user entered not entered number which cause InputMismatchException
        try {
            passwordLength = scanner.nextInt();
        } catch (InputMismatchException e) {
            CustomLogger.error(LoggerConstants.inputException);
            System.out.println(StringConstants.inputMismatch);
            return null;
        }
        // If length entered is negative or 0
        if (passwordLength <= 0) {
            CustomLogger.error(LoggerConstants.negativeLength);
            System.out.println(StringConstants.passwordLengthInfo);
            CustomLogger.info(LoggerConstants.exitApplication);
            return null;
        }
        // getting the shuffled selected characters list
        List<Character> characterChosen = getCharactersChosen(userResponses);
        // builder to generated random password
        StringBuilder password = new StringBuilder();
        // creating random object to get random index within length of character list
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(characterChosen.size());
            // adding the random index's character in character list
            password.append(characterChosen.get(randomIndex));
        }
        // printing generated password on console
        System.out.println(StringConstants.printPassword + password);
        // returning password to validate
        return password.toString();
    }

    // method to create selected list of characters based on response of user and return the shuffled list
    private static List<Character> getCharactersChosen(Map<String, Boolean> userResponses) {
        StringBuilder characterChosen = new StringBuilder();
        for (String characters : userResponses.keySet()) {
            // if user response is yes the appending the related characters
            if (userResponses.get(characters)) {
                characterChosen.append(characters);
            }
        }
        // if user entered no for all questions then using default as all characters
        if (characterChosen.toString().isEmpty()) {
            CustomLogger.error(LoggerConstants.invalidResponse);
            CustomLogger.info(LoggerConstants.defaultAction);
            for (String characters : userResponses.keySet()) {
                characterChosen.append(characters);
            }
        }
        // created list of characters to store shuffled order
        List<Character> shuffledChosenChar = new ArrayList<>();
        for (char c : characterChosen.toString().toCharArray()) {
            shuffledChosenChar.add(c);
        }
        // using collections inbuilt method shuffle to shuffle characters in list
        Collections.shuffle(shuffledChosenChar);
        // returning shuffled list
        return shuffledChosenChar;
    }
}
