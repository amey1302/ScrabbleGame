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
    void shouldBeAbleToThrowExceptionForNullWord() {
        // arrange
        String word = null;

        // act & assert
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(word));
    }

    @Test
    void shouldBeAbleToThrowAnExceptionWhenWordIsEmpty() {
        // arrange
        String word = "";

        // act & assert
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(word));
    }

    @Test
    void shouldBeAbleToThrowAnExceptionWhenWordContainsDigits() {
        // arrange
        String word = "34ANT";

        // act & assert
        assertThrows(WordContainsDigitsException.class, () -> scoreCalculator.getScoreForWord(word));
    }

    @Test
    void shouldBeAbleToThrowAnExceptionWhenWordContainsSpecialCharacters() {
        // arrange
        String word = "&^%$ANT";
        String word1 = "&&&&*(";

        // act & assert
        assertThrows(WordContainsSpecialCharactersException.class, () -> scoreCalculator.getScoreForWord(word));
        assertThrows(WordContainsSpecialCharactersException.class, () -> scoreCalculator.getScoreForWord(word1));
    }

    @Test
    void shouldBeCalculateScoreForWordWithAllLetters() throws InvalidWordException {
        // arrange
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int expected = 87;

        // act
        int actual = scoreCalculator.getScoreForWord(word);

        // assert
        assertEquals(expected, actual);
    }
}
