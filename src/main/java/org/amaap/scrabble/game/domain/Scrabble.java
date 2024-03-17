package org.amaap.scrabble.game.domain;

import org.amaap.scrabble.game.exception.EmptyWordException;
import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;
import org.amaap.scrabble.game.validation.Validation;

public class Scrabble {
    private static final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};


    public static int calculateScoreAndValidateWord(String word) throws InvalidWordException {
        if (Validation.isWordNullOrEmpty(word))
            throw new EmptyWordException("Word Should have Characters");
        if (word.length() < 3)
            throw new InvalidWordException("Word should have minimum 3 Characters");
        if (Validation.isWordContainsDigits(word))
            throw new WordContainsDigitsException("Word Contains Digits");
        if (Validation.isWordContainsSpecialCharacters(word))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");
        return score(word.toUpperCase());
    }
    private static int score(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            score += POINTS[word.charAt(i) - 'A'];
        }
        return score;

    }

}
