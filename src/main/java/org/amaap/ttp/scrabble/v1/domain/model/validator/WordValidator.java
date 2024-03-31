package org.amaap.ttp.scrabble.v1.domain.model.validator;

public class WordValidator {

    public static boolean isWordContainsDigits(String word) {
        return word.matches(".*\\d.*");
    }
    public static boolean isWordContainsSpecialCharacters(String word) {
        return word.matches(".*[^A-Za-z].*");
    }

}
