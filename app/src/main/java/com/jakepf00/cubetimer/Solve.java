package com.jakepf00.cubetimer;

public class Solve implements Comparable<Solve> {
    public double time = 0.0;
    public String scramble = "";
    public boolean DNF = false;
    public boolean plusTwo = false;
    public String comment = "";
    public String toString() {
        return time + ";";
    }

    public int compareTo(Solve other) {
        return (Double.compare(this.time, other.time));
    }
}
