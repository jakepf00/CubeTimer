package com.jakepf00.cubetimer;

import java.util.ArrayList;

public class AlgUtils {
    public static ArrayList<Algorithm> getPLLs() {
        ArrayList<Algorithm> algs = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            algs.add(new Algorithm(PLLs[i], getAlg("PLL", i)));
        }
        return algs;
    }

    public static ArrayList<Algorithm> getOLLs() {
        ArrayList<Algorithm> algs = new ArrayList<>();
        for (int i = 0; i < 57; i++) {
            String name = "OLL " + (i + 1);
            algs.add(new Algorithm(name, getAlg("OLL", i)));
        }
        return algs;
    }

    private static String getAlg(String subset, int alg) {
        switch (subset) {
            case "PLL":
                switch (alg) {
                    case 0:

                    case 1:

                    default:
                        return "";
                }
            case "OLL":
                switch (alg) {
                    case 1:

                    case 2:

                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    private static String[] PLLs = {"Aa", "Ab", "E", "F", "Ga", "Gb", "Gc", "Gd", "H", "Ja", "Jb", "Na", "Nb", "Ra", "Rb", "T", "Ua", "Ub", "V", "Y", "Z"};
}
