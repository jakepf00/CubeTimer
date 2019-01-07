package com.jakepf00.cubetimer;

public class Clock {
    private double  start = 0.0;

    public void start() {
        start = System.currentTimeMillis();
    }
    public double stop() {
        double now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
