package com.jakepf00.cubetimer;

public class Solve implements Comparable<Solve> {
    public double time = 0.0;
    public String scramble = "";
    public String comment = "";
    public boolean DNF = false;
    public boolean plusTwo = false;
    public String toString() {
        return "" + time;
    }
    public String getData() {
        String stringDNF = DNF ? "true" : "false";
        String stringPlusTwo = plusTwo ? "true" : "false";
        return time + ",\"" + scramble + "\",\"" + comment + "\"," + stringDNF + "," + stringPlusTwo +  ";";
    }

    public int compareTo(Solve other) {
        return (Double.compare(this.time, other.time));
    }
}
