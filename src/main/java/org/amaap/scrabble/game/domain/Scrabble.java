package org.amaap.scrabble.game.domain;

import org.amaap.scrabble.game.exception.EmptyWordException;
import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;
import org.amaap.scrabble.game.validator.Validation;

public class Scrabble {
    private static final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

    public static boolean isValid(String word) throws InvalidWordException {
        if (word == null || word.isEmpty())
            throw new EmptyWordException("Word Should have Characters");
        if (word.length() < 3)
            throw new InvalidWordException("Word should have minimum 3 Characters");
        if (Validation.isWordContainsDigits(word))
            throw new WordContainsDigitsException("Word Contains Digits");
        if (Validation.isWordContainsSpecialCharacters(word))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");
        return true;
    }
    // for checking score with word
    public static int score(String word) throws InvalidWordException {
        isValid(word);
        return calculateScore(word);
    }
    // for letter with multiplier
    public static int scoreWithLetterMultiplier(String word, int[] letterMultipliers) throws InvalidWordException {
        isValid(word);
        if (letterMultipliers.length != word.length())
            throw new InvalidWordException("Letter multipliers length should be equal to word length");

        return calculateScoreWithMultiplier(word, letterMultipliers);
    }
    //for with word multiplier
    public static int scoreWithWordMultiplier(String word, int wordMultiplier) throws InvalidWordException {
        isValid(word);
        return calculateScore(word) * wordMultiplier;
    }
    // method to calculate score
    private static int calculateScore(String word) {
        int score = 0;
        String upperCaseWord = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            score += POINTS[upperCaseWord.charAt(i) - 'A'];
        }
        return score;
    }

    private static int calculateScoreWithMultiplier(String word, int[] letterMultipliers) {
        int score = 0;
        String upperCaseWord = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            int letterScore = POINTS[upperCaseWord.charAt(i) - 'A'] * letterMultipliers[i];
            score += letterScore;
        }
        return score;
    }
}
