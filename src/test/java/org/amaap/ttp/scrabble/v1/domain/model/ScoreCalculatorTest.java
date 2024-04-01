package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void shouldBeAbleToReturnTheScoreForCapitalAlphabetWords() throws InvalidWordException {
        // arrange
        String word = "GUARDIAN";
        Scrabble scrabble = Scrabble.accept(word);
        int expected = 10;

        // act
        int actual = scoreCalculator.getScoreForWord(word);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToReturnTheScoreForSmallerAlphabet() throws InvalidWordException {
        // arrange
        String word = "guardian";
        int expected = 10;

        // act
        int actual = scoreCalculator.getScoreForWord(word);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToCalculateScoreForWordWithAllLetters() throws InvalidWordException {
        // arrange
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int expected = 87;

        // act
        int actual = scoreCalculator.getScoreForWord(word);

        // assert
        assertEquals(expected, actual);
    }
}
