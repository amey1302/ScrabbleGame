package org.amaap.ttp.scrabble.v1.domain;

import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrabbleManagerTest {
    ScrabbleManager scarbbleManager = ScrabbleManager.getInstance();

    @Test
    void shouldBeAbleToGetSingleInstance(){
        // arrange
        ScrabbleManager scarbbleManager1 = ScrabbleManager.getInstance();

        // act & assert
        assertEquals(scarbbleManager,scarbbleManager1);
    }
    @Test
    void shouldBeAbleToGetTheScoreForGivenWord() throws InvalidWordException {
        // arrange
        int expectedScore = 10;

        // act
        int actualScore = scarbbleManager.getScoreForWord("GUARDIAN");

        // assert
        assertEquals(expectedScore,actualScore);

    }
    @Test
    void shouldBeAbleToGetScoreForDoubleWord() throws InvalidWordException {
        // arrange
        int expectedScore = 14;
        String word ="ABC";

        // act
        int actualScore = scarbbleManager.getScoreWordMultiplier(word,2);

        // assert
        assertEquals(expectedScore,actualScore);
    }
}
