package org.amaap.scrabble.game;

import org.amaap.scrabble.game.exception.EmptyWordException;
import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;

public class Scrabble {
    String word;

    private Scrabble(String word) {
        this.word = word;

    }

    public static Scrabble calculateScore(String word) throws InvalidWordException {
        if (word == null || word.isEmpty())
            throw new EmptyWordException("Word Should have Characters");
        if(word.length() < 3)
            throw new InvalidWordException("Word should have minimum 3 Characters");
        if (word.matches(".*\\d.*"))
            throw new WordContainsDigitsException("Word Contains Digits");
        else if (word.matches(".*[^A-Z^a-z].*"))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");

        return new Scrabble(word);
    }

    public int score(String word) {
        int score = 0;
        String upperCaseWord = word.toUpperCase();
        final int[] POINTS = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
        for (int i = 0; i < word.length(); i++) {
            score += POINTS[upperCaseWord.charAt(i) - 'A'];
        }
        return score;
    }

    public String getWord() {
        return word;
    }

}
