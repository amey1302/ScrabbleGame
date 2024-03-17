package org.amaap.scrabble.game;

import org.amaap.scrabble.game.exception.EmptyWordException;
import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrabbleTest {
    @Test
    void shouldAbleToReturnTheScoreForCapitalAlphabetWords() throws InvalidWordException {
        Scrabble scrabble = Scrabble.calculateScore("GUARDIAN");
        int actual = scrabble.score(scrabble.getWord());

        assertEquals(10, actual);

    }

    @Test
    void shouldAbleToReturnTheScoreForSmallerAlphabet() throws InvalidWordException {
        Scrabble scrabble = Scrabble.calculateScore("guardian");
        int actual = scrabble.score(scrabble.getWord());

        assertEquals(10, actual);

    }

    @Test
    void shouldThrowExceptionForNullWord() {
        assertThrows(EmptyWordException.class, () -> {
            Scrabble.calculateScore(null);
        });
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordIsEmpty() {
        String word = "";
        assertThrows(EmptyWordException.class, () -> {
            Scrabble.calculateScore(word);
        });
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsDigits() {
        String word = "34ANT";
        assertThrows(WordContainsDigitsException.class, () -> {
            Scrabble.calculateScore(word);
        });
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsSpecialCharacters() {
        String word = "&^%$ANT";
        String word1 = "&&&&*(";
        assertThrows(WordContainsSpecialCharactersException.class, () -> {
            Scrabble.calculateScore(word);
        });
        assertThrows(WordContainsSpecialCharactersException.class, () -> {
            Scrabble.calculateScore(word1);
        });
    }

    @Test
    void shouldCalculateScoreForWordWithAllLetters() throws InvalidWordException {
        Scrabble scrabble = Scrabble.calculateScore("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        int actual = scrabble.score(scrabble.getWord());
        assertEquals(87, actual);
    }

    @Test
    void shouldThrowExceptionForWordWithLessThanThreeCharacters() {
        assertThrows(InvalidWordException.class, () -> {
            Scrabble.calculateScore("Z");
        });
    }

}
