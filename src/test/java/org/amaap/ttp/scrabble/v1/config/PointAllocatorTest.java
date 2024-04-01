package org.amaap.ttp.scrabble.v1.config;

import org.amaap.ttp.scrabble.v1.config.exception.InvalidLetterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointAllocatorTest {
    PointAllocator pointAllocator = new PointAllocator();
    @Test
    void shouldBeAbleToGetScoreForValidLetter() throws InvalidLetterException {
        // Arrange
        char letter = 'A';
        int expectedScore = 1;

        // Act
        int actualScore = pointAllocator.getScoreForLetter(letter);

        // Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldBeAbleToThrowExceptionForInvalidLetter() {
        // Arrange
        char invalidLetter = '!';

        // Act & Assert
        assertThrows(InvalidLetterException.class, () -> pointAllocator.getScoreForLetter(invalidLetter));
    }

}