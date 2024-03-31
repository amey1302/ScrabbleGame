package org.amaap.ttp.scrabble.v1.domain.model.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordValidatorTest {

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsDigits() {
        // arrange
        String word = "hello123";

        // act
        boolean result = WordValidator.isWordContainsDigits(word);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordDoesNotContainDigits() {
        // arrange
        String word = "hello";

        // act
        boolean result = WordValidator.isWordContainsDigits(word);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsSpecialCharacters() {
        // arrange
        String word = "hello@world";

        // act
        boolean result = WordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordDoesNotContainSpecialCharacters() {
        // arrange
        String word = "helloworld";

        // act
        boolean result = WordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsBothDigitsAndSpecialCharacters() {
        // arrange
        String word = "hello123@world";

        // act
        boolean resultDigit = WordValidator.isWordContainsDigits(word);
        boolean resultSpecial = WordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertTrue(resultDigit);
        assertTrue(resultSpecial);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordContainsNeitherDigitsNorSpecialCharacters() {
        // arrange
        String word = "helloworld";

        // act
        boolean resultDigit = WordValidator.isWordContainsDigits(word);
        boolean resultSpecial = WordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertFalse(resultDigit);
        assertFalse(resultSpecial);
    }
}
