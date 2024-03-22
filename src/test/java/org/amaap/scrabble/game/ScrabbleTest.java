package org.amaap.scrabble.game;

import org.amaap.scrabble.game.domain.Scrabble;
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
        int actual = Scrabble.score("GUARDIAN");
        assertEquals(10, actual);

    }

    @Test
    void shouldAbleToReturnTheScoreForSmallerAlphabet() throws InvalidWordException {
        int actual = Scrabble.score("guardian");

        assertEquals(10, actual);

    }

    @Test
    void shouldAbleToReturnTheScoreForDoubleOrTripleLetter() throws InvalidWordException {
        int actual = Scrabble.score("guardian");

        assertEquals(10, actual);

    }

    @Test
    void shouldThrowExceptionForNullWord() {
        assertThrows(EmptyWordException.class, () -> Scrabble.score(null));
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordIsEmpty() {
        String word = "";
        assertThrows(EmptyWordException.class, () -> Scrabble.score(word));
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsDigits() {
        String word = "34ANT";
        assertThrows(WordContainsDigitsException.class, () -> Scrabble.score(word));
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsSpecialCharacters() {
        String word = "&^%$ANT";
        String word1 = "&&&&*(";
        assertThrows(WordContainsSpecialCharactersException.class, () -> Scrabble.score(word));
        assertThrows(WordContainsSpecialCharactersException.class, () -> Scrabble.score(word1));
    }

    @Test
    void shouldCalculateScoreForWordWithAllLetters() throws InvalidWordException {
        int actual = Scrabble.score("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals(87, actual);
    }

    @Test
    void shouldThrowExceptionForWordWithLessThanThreeCharacters() {
        assertThrows(InvalidWordException.class, () -> Scrabble.score("Z"));
    }

    @Test
    void shouldCalculateScoreWithLetterMultiplier() throws InvalidWordException {
        int actual = Scrabble.scoreWithLetterMultiplier("DOG", new int[]{1, 2, 1});
        assertEquals(6, actual);
    }

    @Test
    void shouldCalculateScoreWithWordMultiplier() throws InvalidWordException {
        int actual = Scrabble.scoreWithWordMultiplier("DOG", 2);
        assertEquals(10, actual);
    }

}
