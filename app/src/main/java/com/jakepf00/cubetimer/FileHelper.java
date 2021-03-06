package com.jakepf00.cubetimer;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class FileHelper {
    public static void writeSolvesToFile(String cube, ArrayList<Solve> solves, Context context) {
        FileOutputStream outputStream;
        File file = new File(context.getFilesDir(), cube); // use cube name as file name
        try {
            outputStream = new FileOutputStream(file, true);
            for (Solve solve : solves) {
                outputStream.write(solve.getData().getBytes());
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Solve> readSolvesFromFile(String cube, Context context) {
        StringBuilder text = new StringBuilder();
        int thing;
        try {
            InputStream input = context.openFileInput(cube);
            while ((thing = input.read()) != -1) {
                char character = (char) thing;
                text.append(character);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] solveStrings = text.toString().split(";");
        ArrayList<Solve> solves = new ArrayList<>();
        for (String solve : solveStrings) {
            String[] solveData = solve.split(",");
            Solve a = new Solve();
            a.time = Double.valueOf(solveData[0]);
            if (solveData[1].length() > 2) {
                a.scramble = solveData[1].substring(1, solveData[1].length() - 1);
            }
            if (solveData[2].length() > 2) {
                a.comment = solveData[2].substring(1, solveData[2].length() - 1);
            }
            if (solveData[3].equals("true")) {
                a.DNF = true;
            }
            if (solveData[4].equals("true")) {
                a.plusTwo = true;
            }
            solves.add(0, a);
        }
        return solves;
    }
}
