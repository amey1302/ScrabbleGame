package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void shouldThrowAnEmptyWordExceptionForNullWord() {
        // act & assert
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(null));
    }

    @Test
    void shouldThrowEmptyWordExceptionForEmptyWord() {
        // act & assert
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(""));
    }

    @Test
    void shouldThrowAnWordContainsDigitsExceptionWhenWordContainsDigits() {
        // arrange
        String word = "34ANT";

        // act & assert
        assertThrows(WordContainsDigitsException.class, () -> scoreCalculator.getScoreForWord(word));
    }

    @Test
    void shouldThrowAnWordContainsSpecialCharactersExceptionWhenWordContainsSpecialCharacters() {
        // arrange
        String word = "&^%$ANT";
        String word1 = "&&&&*(";

        // act & assert
        assertThrows(WordContainsSpecialCharactersException.class, () -> scoreCalculator.getScoreForWord(word));
        assertThrows(WordContainsSpecialCharactersException.class, () -> scoreCalculator.getScoreForWord(word1));
    }

    @Test
    void shouldReturnTheScoreForCapitalAlphabetWords() throws InvalidWordException {
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
    void shouldBeAbleToCalculateScoreForWordWithAllLetters() throws InvalidWordException {
        // arrange
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int expected = 87;

        // act
        int actual = scoreCalculator.getScoreForWord(word);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void shouldBeAbleToReturnScoreForWordWithDoubleLetter() {
        // arrange
        String word = "GUARDIAN";
        char letterToDouble = 'A';
        int multiplier = 2;
        int expectedScore = 10 + 2 + 1 + 1 + 1 + 1 + 1 + 1;

        // act
        int actualScore = scoreCalculator.getScoreWithLetterMultiplier(word, letterToDouble, multiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldBeAbleToReturnScoreForWordWithTripleLetter() {
        // arrange
        String word = "CAT";
        char letterToTriple = 'T';
        int multiplier = 3;
        int expectedScore = 3 + 1 + (3 * 1);

        // act
        int actualScore = scoreCalculator.getScoreWithLetterMultiplier(word, letterToTriple, multiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }
}
