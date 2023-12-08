package com.tekion.cricket.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ScorecardGenerator {
    private static final String[] outcomes = {"0", "1", "2", "3", "4", "5", "6", "W"};
    private static final Random random = new Random();

    public static String getRandomScore() {
        int randomIndex = random.nextInt(outcomes.length);
        return outcomes[randomIndex];
    }
}
