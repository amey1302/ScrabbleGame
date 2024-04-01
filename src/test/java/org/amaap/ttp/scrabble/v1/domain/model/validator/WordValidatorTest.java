package org.amaap.ttp.scrabble.v1.domain.model.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordValidatorTest {
    WordValidator wordValidator = new WordValidator();

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsDigits() {
        // arrange
        String word = "hello123";

        // act
        boolean result = wordValidator.isWordContainsDigits(word);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordDoesNotContainDigits() {
        // arrange
        String word = "hello";

        // act
        boolean result = wordValidator.isWordContainsDigits(word);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsSpecialCharacters() {
        // arrange
        String word = "hello@world";

        // act
        boolean result = wordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertTrue(result);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordDoesNotContainSpecialCharacters() {
        // arrange
        String word = "helloworld";

        // act
        boolean result = wordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertFalse(result);
    }

    @Test
    void shouldBeAbleToReturnTrueWhenWordContainsBothDigitsAndSpecialCharacters() {
        // arrange
        String word = "hello123@world";

        // act
        boolean resultDigit = wordValidator.isWordContainsDigits(word);
        boolean resultSpecial = wordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertTrue(resultDigit);
        assertTrue(resultSpecial);
    }

    @Test
    void shouldBeAbleToReturnFalseWhenWordContainsNeitherDigitsNorSpecialCharacters() {
        // arrange
        String word = "helloworld";

        // act
        boolean resultDigit = wordValidator.isWordContainsDigits(word);
        boolean resultSpecial = wordValidator.isWordContainsSpecialCharacters(word);

        // assert
        assertFalse(resultDigit);
        assertFalse(resultSpecial);
    }
}
