package org.amaap.ttp.scrabble.v1.domain.model;

import org.amaap.ttp.scrabble.v1.domain.model.exception.EmptyWordException;
import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScoreCalculatorTest {
    ScoreCalculator scoreCalculator = new ScoreCalculator();

    @Test
    void shouldAbleToReturnTheScoreForCapitalAlphabetWords() throws InvalidWordException {
        int actual = scoreCalculator.getScoreForWord("GUARDIAN");
        assertEquals(10, actual);

    }
    @Test
    void shouldAbleToReturnTheScoreForSmallerAlphabet() throws InvalidWordException {
        int actual = scoreCalculator.getScoreForWord("guardian");

        assertEquals(10, actual);
    }

    @Test
    void shouldAbleToReturnTheScoreForDoubleOrTripleLetter() throws InvalidWordException {
        int actual = scoreCalculator.getScoreForWord("guardian");

        assertEquals(10, actual);

    }

    @Test
    void shouldThrowExceptionForNullWord() {
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(null));
    }

    @Test
    void shouldAbleToThrowAnExceptionWhenWordIsEmpty() {
        String word = "";
        assertThrows(EmptyWordException.class, () -> scoreCalculator.getScoreForWord(word));
    }

}