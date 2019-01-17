package com.jakepf00.cubetimer;

public class Algorithm {
    private String name;
    private String algorithm;
    private int[] colors;

    public Algorithm(String name) {
        this.name = name;
    }
    public Algorithm(String name, String algorithm) {
        this.name = name;
        this.algorithm = algorithm;
    }
    public Algorithm(String name, String algorithm, int[] colors) {
        this.name = name;
        this.algorithm = algorithm;
        this.colors = colors;
    }

    public String toString() {
        return name;
    }
    public String getName() { return name; }
    public String getAlgorithm() {
        return algorithm;
    }
    public int[] getColors() {
        return colors;
    }
}
