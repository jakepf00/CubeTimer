package com.jakepf00.cubetimer;

class Clock {
    private double  start;

    Clock() {}

    void start() {
        start = System.currentTimeMillis();
    }
    double stop() {
        double now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
