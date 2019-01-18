package com.jakepf00.cubetimer;

import java.util.Random;

public class Scrambler {
    public static String generateScramble(String cube) {
        switch (cube) {
            case "2x2": return "1 2";
            case "3x3": return generateScramble3x3();
            case "4x4": return "1 2 3 4";
            case "5x5": return "1 2 3 4 5";
            case "6x6": return "1 2 3 4 5 6";
            case "7x7": return "1 2 3 4 5 6 7";
            case "Rubik's Clock": return "Clock";
            case "Megaminx": return "Megaminx";
            case "Pyraminx": return "Pyraminx";
            case "Skewb": return "Skewb";
            case "Square-1": return "Square-one";
            default: return "1";
        }
    }
    private static String generateScramble3x3() {
        StringBuilder scramble = new StringBuilder();
        Random rand = new Random();
        int number;
        for (int i = 0; i < 20; i++) {
            number = rand.nextInt(6);
            switch (number) {
                case 0: scramble.append('F'); break;
                case 1: scramble.append('R'); break;
                case 2: scramble.append('U'); break;
                case 3: scramble.append('L'); break;
                case 4: scramble.append('D'); break;
                case 5: scramble.append('B'); break;
            }
            number = rand.nextInt(3);
            switch (number) {
                case 0: scramble.append('\''); break;
                case 1: scramble.append('2'); break;
            }
            scramble.append(' ');
        }
        return scramble.toString();
    }
}
