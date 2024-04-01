package org.amaap.ttp.scrabble.v1.config;

import org.amaap.ttp.scrabble.v1.config.exception.InvalidLetterException;

import java.util.HashMap;
import java.util.Map;

public class PointAllocator {
    
    public static Map<Integer, String> scoreMapping = new HashMap<>();
    static {
        scoreMapping.put(1, "EAIONRTLSU");
        scoreMapping.put(2, "DG");
        scoreMapping.put(3, "BCMP");
        scoreMapping.put(4, "FHVWY");
        scoreMapping.put(5, "K");
        scoreMapping.put(8, "JX");
        scoreMapping.put(10, "QZ");
    }
    public static Map<Integer, String> getScoreMapping() {
        return scoreMapping;
    }

}
