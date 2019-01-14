package com.jakepf00.cubetimer;

public class Algorithm {
    private String name;
    private String algorithm;
    public Algorithm(String name) {
        this.name = name;
    }
    public Algorithm(String name, String algorithm) {
        this.name = name;
        this.algorithm = algorithm;
    }
    public String toString() {
        return name;
    }
}
