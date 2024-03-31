package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;
import org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator;

import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsDigits;
import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsSpecialCharacters;

public class ScoreCalculator {
    private static final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    public static boolean isValid(String word) throws InvalidWordException {
        if (word == null || word.isEmpty())
            throw new EmptyWordException("Word Should have Characters");
        if (word.length() < 3)
            throw new InvalidWordException("Word should have minimum 3 Characters");
        if (isWordContainsDigits(word))
            throw new WordContainsDigitsException("Word Contains Digits");
        if (isWordContainsSpecialCharacters(word))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");
        return true;
    }
    public static int getScoreForWord(String word) throws InvalidWordException {
        isValid(word);
        int score = 0;
        String upperCaseWord = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            score += POINTS[upperCaseWord.charAt(i) - 'A'];
        }
        return score;
    }
}
