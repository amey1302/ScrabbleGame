package org.amaap.ttp.scrabble.v1.domain;

import org.amaap.ttp.scrabble.v1.domain.model.exception.InvalidWordException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScarbbleManagerTest {
    ScarbbleManager scarbbleManager = ScarbbleManager.getInstance();

    @Test
    void shouldBeAbleToGetSingleInstance(){
        // arrange
        ScarbbleManager scarbbleManager1 = ScarbbleManager.getInstance();

        // act & assert
        assertEquals(scarbbleManager,scarbbleManager1);
    }

}
