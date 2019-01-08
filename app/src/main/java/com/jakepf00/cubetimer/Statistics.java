package com.jakepf00.cubetimer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

public class Statistics {
    public static double calculateMean(ArrayList<Solve> solves) {
        if(solves.size() == 0) return 0.0;
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

    public static double calculateBest(ArrayList<Solve> solves) {
        if(solves.size() == 0) return 0.0;
        double best = solves.get(0).time;
        for (Solve solve : solves) {
            best = (solve.time < best) ? solve.time : best;
        }
        best = round(best, 3);
        return best;
    }

    public static double calculateAverage(ArrayList<Solve> solves, int numSolves) {
        if ((solves.size() < numSolves) || (numSolves < 3)) return 0.0;
        ArrayList<Solve> lastSolves = new ArrayList<>();
        for (int i = 0; i < numSolves; i++) {
            lastSolves.add(solves.get(i));
        }
        Collections.sort(lastSolves);
        double totalTime = 0;
        for (int i = 1; i < numSolves - 1; i++) {
            totalTime += lastSolves.get(i).time;
        }
        double average = totalTime / (numSolves - 2);
        average = round(average, 3);
        return average;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
