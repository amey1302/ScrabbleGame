package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsDigitsException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.WordContainsSpecialCharactersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrabbleTest {

    @Test
    void shouldBeAbleToThrowExceptionForNullWord() {
        // act & assert
        assertThrows(EmptyWordException.class, () -> Scrabble.accept(null));
    }

    @Test
    void shouldBeAbleToThrowExceptionForEmptyWord() {
        // act & assert
        assertThrows(EmptyWordException.class, () -> Scrabble.accept(""));
    }

    @Test
    void shouldBeAbleToThrowAnExceptionWhenWordContainsDigits() {
        // arrange
        String word = "34ANT";

        // act & assert
        assertThrows(WordContainsDigitsException.class, () -> Scrabble.accept(word));
    }

    @Test
    void shouldBeAbleToThrowAnExceptionWhenWordContainsSpecialCharacters() {
        // arrange
        String word = "&^%$ANT";
        String word1 = "&&&&*(";

        // act & assert
        assertThrows(WordContainsSpecialCharactersException.class, () -> Scrabble.accept(word));
        assertThrows(WordContainsSpecialCharactersException.class, () ->Scrabble.accept(word1));
    }

}