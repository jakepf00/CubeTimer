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
                switch (PLLs[alg]) {
                    case "Aa": return "R' F R' B2 R F' R' B2 R2";
                    case "Ab": return "R B' R F2 R' B R F2 R2";
                    case "E": return "x' R U' R' D U R' D' R U R' D R U' R' D' x";
                    case "F": return "R' U2 R' d' R' F' R2 U' R' U R' F R U' F";
                    case "Ga": return "R2 u R' U R' U' R u' R2 y L' U L";
                    case "Gb": return "R' U' R y R2 u R' U R U' R u' R2";
                    case "Gc": return "R2' u' R U' R U R' u R2 y R U' R'";
                    case "Gd": return "R U R' y' R2 u' R U' R' U R' u R2";
                    case "H": return "M2 U' M2 U2 M2 U' M2";
                    case "Ja": return "R' U L' U2 R U' R' U2 R L";
                    case "Jb": return "R U R' F' R U R' U' R' F R2 U' R' U'";
                    case "Na": return "z U R' D R2 U' R U D' R' D R2 U' R D'";
                    case "Nb": return "z U' R D' R2 U R' D U' R D' R2 U R' D";
                    case "Ra": return "L U2 L' U2 L F' L' U' L U L F L2 ";
                    case "Rb": return "R' U2 R U2 R' F R U R' U' R' F' R2 U'";
                    case "T": return "R U R' U' R' F R2 U' R' U' R U R' F'";
                    case "Ua": return "R U' R U R U R U' R' U' R2";
                    case "Ub": return "R2 U R U R' U' R' U' R' U R' ";
                    case "V": return "R' U R' d' R' F' R2 U' R' U R' F R F";
                    case "Y": return "F R U' R' U' R U R' F' R U R' U' R' F R F'";
                    case "Z": return "M2 U' M2 U' M' U2 M2 U2 M'";
                    default: return "";
                }
            case "OLL":
                switch (alg) {
                    case 1: return "R U2 R2' F R F' U2 R' F R F'";
                    case 2: return "F R U R' U' F' f R U R' U' f'";
                    case 3: return "f R U R' U' f' U' F R U R' U' F'";
                    case 4: return "f R U R' U' f' U F R U R' U' F'";
                    case 5: return "r' U2 R U R' U r";
                    case 6: return "r U2 R' U' R U' r'";
                    case 7: return "L' U2 L U2 L F' L' F";
                    case 8: return "R U2 R' U2 R' F R F'";
                    case 9: return "R U R' U' R' F R2 U R' U' F'";
                    case 10: return "R U R' U R' F R F' R U2 R'";
                    case 11: return "";
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
                switch(PLLs[alg]) {
                    case "Aa": colors = new int[] {y,y,y,y,y,y,y,y,y,gr,o,gr,o,b,b,r,r,o,r,gr,b}; break;
                    case "Ab": colors = new int[] {y,y,y,y,y,y,y,y,y,o,o,r,b,b,r,gr,r,gr,b,gr,o}; break;
                    case "E": colors = new int[] {y,y,y,y,y,y,y,y,y,o,gr,r,b,o,gr,o,b,r,b,r,gr}; break;
                    case "F": colors = new int[] {y,y,y,y,y,y,y,y,y,o,o,o,b,gr,r,gr,r,b,gr,b,r}; break;
                    case "Ga": colors = new int[] {y,y,y,y,y,y,y,y,y,o,r,gr,b,o,b,r,gr,gr,r,b,o}; break;
                    case "Gb": colors = new int[] {y,y,y,y,y,y,y,y,y,b,r,o,r,o,r,gr,b,o,gr,gr,b}; break;
                    case "Gc": colors = new int[] {y,y,y,y,y,y,y,y,y,r,b,b,gr,o,gr,o,r,b,o,gr,r}; break;
                    case "Gd": colors = new int[] {y,y,y,y,y,y,y,y,y,b,gr,o,r,o,r,gr,r,o,gr,b,b}; break;
                    case "H": colors = new int[] {y,y,y,y,y,y,y,y,y,o,r,o,b,gr,b,r,o,r,gr,b,gr}; break;
                    case "Ja": colors = new int[] {y,y,y,y,y,y,y,y,y,o,r,r,b,b,r,gr,gr,gr,b,o,o}; break;
                    case "Jb": colors = new int[] {y,y,y,y,y,y,y,y,y,o,o,gr,b,b,b,r,gr,gr,r,r,o}; break;
                    case "Na": colors = new int[] {y,y,y,y,y,y,y,y,y,o,o,r,b,gr,gr,o,r,r,b,b,gr}; break;
                    case "Nb": colors = new int[] {y,y,y,y,y,y,y,y,y,r,o,o,gr,gr,b,r,r,o,gr,b,b}; break;
                    case "Ra": colors = new int[] {y,y,y,y,y,y,y,y,y,b,r,gr,r,o,gr,o,gr,o,r,b,b}; break;
                    case "Rb": colors = new int[] {y,y,y,y,y,y,y,y,y,gr,o,b,o,b,b,r,gr,r,o,r,gr}; break;
                    case "T": colors = new int[] {y,y,y,y,y,y,y,y,y,o,o,gr,b,gr,b,r,r,gr,r,b,o}; break;
                    case "Ua": colors = new int[] {y,y,y,y,y,y,y,y,y,r,r,r,gr,o,gr,o,b,o,b,gr,b}; break;
                    case "Ub": colors = new int[] {y,y,y,y,y,y,y,y,y,r,r,r,gr,b,gr,o,gr,o,b,o,b}; break;
                    case "V": colors = new int[] {y,y,y,y,y,y,y,y,y,r,gr,o,gr,b,b,r,r,o,gr,o,b}; break;
                    case "Y": colors = new int[] {y,y,y,y,y,y,y,y,y,r,b,o,gr,o,b,r,r,o,gr,gr,b}; break;
                    case "Z": colors = new int[] {y,y,y,y,y,y,y,y,y,b,o,b,r,gr,r,gr,r,gr,o,b,o}; break;
                    default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
                }
                break;
            case "OLL":
                switch(alg) {
                    case 1:  colors = new int[] {g,g,g,g,y,g,g,g,g,g,y,g,y,y,y,g,y,g,y,y,y}; break;
                    case 2:  colors = new int[] {g,g,g,g,y,g,g,g,g,g,y,y,y,y,y,g,y,y,g,y,g}; break;
                    case 3:  colors = new int[] {g,g,g,g,y,g,g,g,y,y,y,g,g,y,y,g,y,g,y,y,g}; break;
                    case 4:  colors = new int[] {g,g,y,g,y,g,g,g,g,g,y,g,y,y,g,y,y,g,g,y,y}; break;
                    case 5:  colors = new int[] {g,g,g,g,y,y,g,y,y,y,y,g,g,y,y,g,g,g,y,g,g}; break;
                    case 6:  colors = new int[] {g,y,y,g,y,y,g,g,g,g,g,g,y,y,g,y,y,g,g,g,y}; break;
                    case 7:  colors = new int[] {g,y,g,y,y,g,y,g,g,y,g,g,g,g,g,g,y,y,y,y,g}; break;
                    case 8:  colors = new int[] {g,y,g,g,y,y,g,g,y,g,g,y,y,y,g,y,y,g,g,g,g}; break;
                    case 9:  colors = new int[] {g,y,g,y,y,g,g,g,y,g,g,y,y,g,g,y,y,g,g,y,g}; break;
                    case 10: colors = new int[] {g,g,y,y,y,g,g,y,g,y,y,g,g,g,y,g,g,y,g,y,g}; break;
                    case 11: colors = new int[] {y,g,g,y,y,g,g,y,g,g,y,g,g,g,y,g,g,y,y,y,g}; break;
                    case 12: colors = new int[] {g,g,y,g,y,y,g,y,g,g,y,g,y,y,g,y,g,g,g,g,y}; break;
                    case 13: colors = new int[] {g,g,g,y,y,y,y,g,g,y,y,g,g,g,g,g,y,y,y,g,g}; break;
                    case 14: colors = new int[] {g,g,g,y,y,y,g,g,y,g,y,y,y,g,g,y,y,g,g,g,g}; break;
                    case 15: colors = new int[] {g,g,g,y,y,y,g,g,y,y,y,g,g,g,y,g,y,g,y,g,g}; break;
                    case 16: colors = new int[] {g,g,g,y,y,y,y,g,g,g,y,y,y,g,g,g,y,g,g,g,y}; break;
                    case 17: colors = new int[] {y,g,g,g,y,g,g,g,y,g,y,y,g,y,y,g,y,g,g,y,g}; break;
                    case 18: colors = new int[] {y,g,y,g,y,g,g,g,g,g,y,g,g,y,g,y,y,y,g,y,g}; break;
                    case 19: colors = new int[] {y,g,y,g,y,g,g,g,g,g,y,g,g,y,y,g,y,g,g,y,y}; break;
                    case 20: colors = new int[] {y,g,y,g,y,g,y,g,y,g,y,g,g,y,g,g,y,g,g,y,g}; break;
                    case 21: colors = new int[] {g,y,g,y,y,y,g,y,g,y,g,y,g,g,g,y,g,y,g,g,g}; break;
                    case 22: colors = new int[] {g,y,g,y,y,y,g,y,g,g,g,y,y,g,y,g,g,y,g,g,g}; break;
                    case 23: colors = new int[] {y,y,y,y,y,y,g,y,g,g,g,g,g,g,g,y,g,y,g,g,g}; break;
                    case 24: colors = new int[] {g,y,y,y,y,y,g,y,y,y,g,g,g,g,g,y,g,g,g,g,g}; break;
                    case 25: colors = new int[] {g,y,y,y,y,y,y,y,g,g,g,g,y,g,g,g,g,y,g,g,g}; break;
                    case 26: colors = new int[] {g,y,y,y,y,y,g,y,g,g,g,g,y,g,g,y,g,g,g,g,y}; break;
                    case 27: colors = new int[] {g,y,g,y,y,y,y,y,g,y,g,g,g,g,g,g,g,y,y,g,g}; break;
                    case 28: colors = new int[] {y,g,y,g,y,y,y,y,y,g,y,g,g,y,g,g,g,g,g,g,g}; break;
                    case 29: colors = new int[] {y,g,y,y,y,g,g,y,g,g,y,g,g,g,y,g,g,g,g,y,y}; break;
                    case 30: colors = new int[] {y,g,y,g,y,y,g,y,g,g,y,g,g,y,y,g,g,g,g,g,y}; break;
                    case 31: colors = new int[] {g,y,y,g,y,y,g,g,y,y,g,g,g,y,g,y,y,g,g,g,g}; break;
                    case 32: colors = new int[] {g,g,y,g,y,y,g,y,y,y,y,g,g,y,g,y,g,g,g,g,g}; break;
                    case 33: colors = new int[] {g,g,y,y,y,y,g,g,y,y,y,g,g,g,g,y,y,g,g,g,g}; break;
                    case 34: colors = new int[] {g,g,g,y,y,y,y,g,y,g,y,g,y,g,g,g,y,g,y,g,g}; break;
                    case 35: colors = new int[] {y,g,g,g,y,y,g,y,y,g,y,g,g,y,g,y,g,g,y,g,g}; break;
                    case 36: colors = new int[] {y,y,g,g,y,y,g,g,y,g,g,y,g,y,y,g,y,g,g,g,g}; break;
                    case 37: colors = new int[] {y,y,g,y,y,g,g,g,y,g,g,g,g,g,g,y,y,g,y,y,g}; break;
                    case 38: colors = new int[] {g,y,y,y,y,g,y,g,g,y,g,g,g,g,g,g,y,g,g,y,y}; break;
                    case 39: colors = new int[] {g,g,y,y,y,y,y,g,g,g,y,g,y,g,g,g,y,y,g,g,g}; break;
                    case 40: colors = new int[] {y,g,g,y,y,y,g,g,y,g,y,y,g,g,y,g,y,g,g,g,g}; break;
                    case 41: colors = new int[] {g,y,g,y,y,g,y,g,y,y,g,y,g,g,g,g,y,g,g,y,g}; break;
                    case 42: colors = new int[] {y,g,y,y,y,g,g,y,g,g,y,g,g,g,g,y,g,y,g,y,g}; break;
                    case 43: colors = new int[] {y,g,g,y,y,g,y,y,g,g,y,g,g,g,g,g,g,g,y,y,y}; break;
                    case 44: colors = new int[] {g,g,y,g,y,y,g,y,y,g,y,g,y,y,y,g,g,g,g,g,g}; break;
                    case 45: colors = new int[] {g,g,y,y,y,y,g,g,y,g,y,g,y,g,y,g,y,g,g,g,g}; break;
                    case 46: colors = new int[] {y,y,g,g,y,g,y,y,g,g,g,g,g,y,g,g,g,g,y,y,y}; break;
                    case 47: colors = new int[] {g,y,g,g,y,y,g,g,g,y,g,g,g,y,g,y,y,g,y,g,y}; break;
                    case 48: colors = new int[] {g,y,g,y,y,g,g,g,g,g,g,y,y,g,y,g,y,y,g,y,g}; break;
                    case 49: colors = new int[] {g,y,g,g,y,y,g,g,g,g,g,y,y,y,y,g,y,y,g,g,g}; break;
                    case 50: colors = new int[] {g,g,g,g,y,y,g,y,g,g,y,y,y,y,y,g,g,y,g,g,g}; break;
                    case 51: colors = new int[] {g,g,g,y,y,y,g,g,g,g,y,y,y,g,y,g,y,y,g,g,g}; break;
                    case 52: colors = new int[] {g,y,g,g,y,g,g,y,g,y,g,g,g,y,g,y,g,g,y,y,y}; break;
                    case 53: colors = new int[] {g,g,g,g,y,y,g,y,g,g,y,g,y,y,y,g,g,g,y,g,y}; break;
                    case 54: colors = new int[] {g,y,g,g,y,y,g,g,g,g,g,g,y,y,y,g,y,g,y,g,y}; break;
                    case 55: colors = new int[] {g,y,g,g,y,g,g,y,g,g,g,g,y,y,y,g,g,g,y,y,y}; break;
                    case 56: colors = new int[] {g,g,g,y,y,y,g,g,g,g,y,g,y,g,y,g,y,g,y,g,y}; break;
                    case 57: colors = new int[] {y,g,y,y,y,y,y,g,y,g,y,g,g,g,g,g,y,g,g,g,g}; break;
                    default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
                }
                break;
            default: colors = new int[] {g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g,g};
        }
        return colors;
    }

    private static String[] PLLs = {"Aa", "Ab", "E", "F", "Ga", "Gb", "Gc", "Gd", "H", "Ja", "Jb", "Na", "Nb", "Ra", "Rb", "T", "Ua", "Ub", "V", "Y", "Z"};
}
