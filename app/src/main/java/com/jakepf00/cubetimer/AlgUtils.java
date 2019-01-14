package com.jakepf00.cubetimer;

import java.util.ArrayList;

public class AlgUtils {
    public static ArrayList<Algorithm> getPLLs() {
        ArrayList<Algorithm> algs = new ArrayList<>();
        algs.add(new Algorithm("hi"));
        algs.add(new Algorithm("hi2"));
        algs.add(new Algorithm("asdf"));
        algs.add(new Algorithm("test"));
        algs.add(new Algorithm("abc"));
        return algs;
    }

    public static ArrayList<Algorithm> getOLLs() {
        ArrayList<Algorithm> algs = new ArrayList<>();

        return algs;
    }
    private String getAlg(String subset, int alg) {
        switch (subset) {
            case "PLL":
                switch (alg) {
                    case 1:

                    case 2:

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
}
