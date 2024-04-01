package org.amaap.ttp.scrabble.v1.domain.model.validator;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;

public class WordValidator {
    public static boolean isValid(String word) throws EmptyWordException, WordContainsDigitsException, WordContainsSpecialCharactersException {
        if (word == null || word.isEmpty()) {
            throw new EmptyWordException("Word Should have Characters");
        }
        if (isWordContainsDigits(word)) {
            throw new WordContainsDigitsException("Word Contains Digits");
        }
        if (isWordContainsSpecialCharacters(word)) {
            throw new WordContainsSpecialCharactersException("Word Contains Special Characters");
        }
        return true;
    }
    public static boolean isWordContainsDigits(String word) {
        return word.matches(".*\\d.*");
    }
    public static boolean isWordContainsSpecialCharacters(String word) {
        return word.matches(".*[^A-Za-z].*");
    }

}
