package org.amaap.scrabble.game;

import org.amaap.scrabble.game.exception.InvalidWordException;
import org.amaap.scrabble.game.exception.WordContainsDigitsException;
import org.amaap.scrabble.game.exception.WordContainsSpecialCharactersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrabbleTest {
    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsDigits() {
        String word = "34ANT";
        assertThrows(WordContainsDigitsException.class, () -> {
            Scrabble.enterWord(word);
        });
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordContainsSpecialCharacters() {
        String word = "&^%$ANT";
        String word1 = "&&&&*(";
        assertThrows(WordContainsSpecialCharactersException.class, () -> {
            Scrabble.enterWord(word);
        });
        assertThrows(WordContainsSpecialCharactersException.class, () -> {
            Scrabble.enterWord(word1);
        });
    }

    @Test
    void shouldAbleToReturnTheScoreForCapitalAlphabetWords() throws InvalidWordException {
        Scrabble scrabble = Scrabble.enterWord("GUARDIAN");
        int actual = scrabble.score(scrabble.getWord());

        assertEquals(10,actual);

    }
    @Test
    void shouldAbleToReturnTheScoreForSmallerAlphabetWords() throws InvalidWordException {
        Scrabble scrabble = Scrabble.enterWord("guardian");
        int actual = scrabble.score(scrabble.getWord());

        assertEquals(10,actual);

    }
    @Test
    void shouldAbleToReturnTheScoreForSmallWord() throws InvalidWordException {
        Scrabble scrabble = Scrabble.enterWord("guardian");
        int actual = scrabble.score(scrabble.getWord());

        assertEquals(10,actual);

    }
}
