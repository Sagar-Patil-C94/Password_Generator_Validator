package com.ivoyant;


import com.ivoyant.constants.LoggerConstants;
import com.ivoyant.constants.StringConstants;
import com.ivoyant.logger.CustomLogger;
import com.ivoyant.password.PasswordValidator;
import com.ivoyant.password.UserCollection;

import java.security.SecureRandom;
import java.util.*;

public class Plugin {
    public static List<String> info() {
        List<String> resultList = new ArrayList<>();
        resultList.add("-------------------------Password Security Tips-----------------------------");
        resultList.add("Tip : Avoid using the same password twice for different accounts.");
        resultList.add("Tip : Avoid repeating characters in your password Eg..XXyZ@13");
        resultList.add("Tip : Avoid using keyboard patterns in your password Eg..qwerty,1234");
        resultList.add("Tip : Avoid using common dictionary words in password Eg..password,123456");
        resultList.add("Tip : Avoid using predictable letter or number sequences in your password");
        return resultList;
    }

    public static String generate(List<Boolean> response, int length) {
        int i = 0;
        Map<String, String> userOptions = UserCollection.getUserOptions();
        Map<String, Boolean> userResponses = UserCollection.userResponses;
        for (String question : userOptions.keySet()) {
            userResponses.put(userOptions.get(question), response.get(i++));
        }
        List<Character> characterChosen = getCharactersChosen(userResponses);
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterChosen.size());
            password.append(characterChosen.get(randomIndex));
        }
        return password.toString();
    }

    private static List<Character> getCharactersChosen(Map<String, Boolean> userResponses) {
        StringBuilder characterChosen = new StringBuilder();
        for (String characters : userResponses.keySet()) {
            if (userResponses.get(characters)) {
                characterChosen.append(characters);
            }
        }
        if (characterChosen.toString().isEmpty()) {
            CustomLogger.error(LoggerConstants.invalidResponse);
            CustomLogger.info(LoggerConstants.defaultAction);
            for (String characters : userResponses.keySet()) {
                characterChosen.append(characters);
            }
        }
        List<Character> shuffledChosenChar = new ArrayList<>();
        for (char c : characterChosen.toString().toCharArray()) {
            shuffledChosenChar.add(c);
        }
        Collections.shuffle(shuffledChosenChar);
        return shuffledChosenChar;
    }

    public static String validate(String password) {
        int score = PasswordValidator.getScore(password);
        if (score != -1) {
            if (score == 6) {
                return StringConstants.strengthInfo + StringConstants.greatPassword;
            } else if (score >= 4) {
                return StringConstants.strengthInfo + StringConstants.goodPassword;
            } else if (score >= 2) {
                return StringConstants.strengthInfo + StringConstants.mediumPassword;
            } else {
                return StringConstants.strengthInfo + StringConstants.weekPassword;
            }
        }
        return null;
    }
}
