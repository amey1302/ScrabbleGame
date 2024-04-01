package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;

import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsDigits;
import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsSpecialCharacters;

public class Scrabble {
    private String word;

    private Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    public static Scrabble accept(String word) throws InvalidWordException {
        if (null == word || word.isEmpty())
            throw new EmptyWordException("Word Should have Characters");
        if (isWordContainsDigits(word))
            throw new WordContainsDigitsException("Word Contains Digits");
        if (isWordContainsSpecialCharacters(word))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");
        return new Scrabble(word);

    }
    public String getWord() {
        return word;
    }

    public int getScoreForWord(String word) {
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        return scoreCalculator.getScoreForWord(word);
    }
}
