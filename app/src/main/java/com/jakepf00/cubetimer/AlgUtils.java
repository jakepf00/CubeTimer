package com.jakepf00.cubetimer;

import android.content.res.Resources;

import java.util.ArrayList;

public class AlgUtils {
    public static ArrayList<Algorithm> getSubset(String subset, Resources resources) {
        switch(subset) {
            case "OLL": return getOLLs(resources);
            case "PLL": return getPLLs(resources);
            default: return new ArrayList<>();
        }
    }

    private static ArrayList<Algorithm> getPLLs(Resources resources) {
        ArrayList<Algorithm> algs = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            algs.add(new Algorithm(PLLs[i], getAlg("PLL", i), getColors("PLL", i, resources)));
        }
        return algs;
    }

    private static ArrayList<Algorithm> getOLLs(Resources resources) {
        ArrayList<Algorithm> algs = new ArrayList<>();
        for (int i = 1; i <= 57; i++) {
            String name = "OLL " + i;
            algs.add(new Algorithm(name, getAlg("OLL", i), getColors("OLL", i, resources)));
        }
        return algs;
    }

    private static String getAlg(String subset, int alg) {
        switch (subset) {
            case "PLL":
                switch (alg) {
                    case 0: return "R' F R' B2 R F' R' B2 R2";
                    case 1: return "R B' R F2 R' B R F2 R2";
                    default: return "";
                }
            case "OLL":
                switch (alg) {
                    case 1: return "R U2 R' R' F R F' U2 R' F R F'";
                    case 2: return "F R U R' U' F' f R U R' U' f'";
                    case 3: return "f R U R' U' f' U' F R U R' U' F'";
                    case 4: return "f R U R' U' f' U F R U R' U' F'";
                    case 5: return "r' U2 R U R' U r";
                    case 6: return "r U2 R' U' R U' r'";
                    case 7: return "L' U2 L U2 L F' L' F";
                    case 8: return "R U2 R' U2 R' F R F'";
                    case 9: return "R U R' U' R' F R2 U R' U' F'";
                    case 10: return "R U R' U R' F R F' R U2 R'";
                    default: return "";
                }
            default:
                return "";
        }
    }
    private static int[] getColors(String subset, int alg, Resources resources) {
        int g = resources.getColor(R.color.grey_cube);
        int w = resources.getColor(R.color.white_cube);
        int y = resources.getColor(R.color.yellow_cube);
        int b = resources.getColor(R.color.blue_cube);
        int gr = resources.getColor(R.color.green_cube);
        int r = resources.getColor(R.color.red_cube);
        int o = resources.getColor(R.color.orange_cube);
        int[] colors;
        switch(subset) {
            case "PLL":
                switch(alg) {
                    case 0: colors = new int[] {y,y,y,y,y,y,y,y,y,b,b,b,r,r,r,gr,gr,gr,o,o,o}; break;
                    default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
                }
                break;
            case "OLL":
                switch(alg) {
                    case 1:
                    default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
                }
                break;
            default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
        }
        return colors;
    }

    private static String[] PLLs = {"Aa", "Ab", "E", "F", "Ga", "Gb", "Gc", "Gd", "H", "Ja", "Jb", "Na", "Nb", "Ra", "Rb", "T", "Ua", "Ub", "V", "Y", "Z"};
}
