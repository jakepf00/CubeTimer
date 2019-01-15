package com.jakepf00.cubetimer;

import java.util.ArrayList;

public class AlgUtils {
    public static ArrayList<Algorithm> getSubset(String subset) {
        switch(subset) {
            case "OLL": return getOLLs();
            case "PLL": return getPLLs();
            default: return new ArrayList<>();
        }
    }

    private static ArrayList<Algorithm> getPLLs() {
        ArrayList<Algorithm> algs = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            algs.add(new Algorithm(PLLs[i], getAlg("PLL", i)));
        }
        return algs;
    }

    private static ArrayList<Algorithm> getOLLs() {
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
                        return "R' F R' B2 R F' R' B2 R2";
                    case 1:
                        return "R B' R F2 R' B R F2 R2";
                    default:
                        return "";
                }
            case "OLL":
                switch (alg) {
                    case 0:
                        return "(R U2 R') (R' F R F') U2 (R' F R F')";
                    case 1:
                        return "F (R U R' U') F' f (R U R' U') f'";
                    case 2:
                        return "f (R U R' U') f' U' F (R U R' U') F'";
                    case 3:
                        return "f (R U R' U') f' U F (R U R' U') F'";
                    case 4:
                        return "r' U2 R U R' U r";
                    case 5:
                        return "r U2 R' U' R U' r'";
                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    private static String[] PLLs = {"Aa", "Ab", "E", "F", "Ga", "Gb", "Gc", "Gd", "H", "Ja", "Jb", "Na", "Nb", "Ra", "Rb", "T", "Ua", "Ub", "V", "Y", "Z"};
}
