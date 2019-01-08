package com.jakepf00.cubetimer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Statistics {
    public static double calculateMean(ArrayList<Solve> solves) {
        double totalTime = 0;
        double numSolves = 0;
        for (Solve solve : solves) {
            totalTime += solve.time;
            numSolves++;
        }
        double mean = totalTime / numSolves;
        mean = round(mean, 3);
        return mean;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
