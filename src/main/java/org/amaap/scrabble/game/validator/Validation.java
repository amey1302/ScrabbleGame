package org.amaap.scrabble.game.validator;

public class Validation {
    public static boolean isWordContainsDigits(String word) {
        return word.matches(".*\\d.*");
    }
    public static boolean isWordContainsSpecialCharacters(String word) {
        return word.matches(".*[^A-Za-z].*");
    }
}
