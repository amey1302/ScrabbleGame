package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.config.PointAllocator;
import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;

import java.util.Map;

import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsDigits;
import static org.amaap.ttp.scrabble.v1.domain.model.validator.WordValidator.isWordContainsSpecialCharacters;

public class ScoreCalculator {
    public int getScoreForWord(String word) throws InvalidWordException {
        if (null == word || word.isEmpty())
            throw new EmptyWordException("Word Should have Characters");
        if (isWordContainsDigits(word))
            throw new WordContainsDigitsException("Word Contains Digits");
        if (isWordContainsSpecialCharacters(word))
            throw new WordContainsSpecialCharactersException("Word Contain Special Characters");

        int score = 0;
        String upperCaseWord = word.toUpperCase();
        for (int i = 0; i < upperCaseWord.length(); i++) {
            int letterScore = getScore(upperCaseWord.charAt(i));
            score += letterScore;
        }
        return score;
    }

    private int getScore(char c) {
        return PointAllocator.getScoreMapping().entrySet().stream()
                .filter(entry -> entry.getValue().contains(String.valueOf(c)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
    }

    public int getScoreForWordWithMultiplier(String word, int wordMultiplier) throws InvalidWordException {
        return getScoreForWord(word) * wordMultiplier;
    }

    public int getScoreWithLetterMultiplier(String originalWord, char letterToMultiply, int multiplier) {
        int score = 0;
        String upperCaseWord = originalWord.toUpperCase();
        for (int i = 0; i < upperCaseWord.length(); i++) {
            char currentChar = upperCaseWord.charAt(i);
            int letterScore = getScore(currentChar);
            if (currentChar == Character.toUpperCase(letterToMultiply)) {
                score += (multiplier * letterScore);
            } else {
                score += letterScore;
            }
        }
        return score;
    }

}
