package com.jakepf00.cubetimer;

import android.content.Context;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class FileHelper {
    public static void writeStringToFile(String fileName, String text, Context context) {
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String readStringFromFile(String fileName, Context context) {
        StringBuilder text = new StringBuilder();
        int thing;
        try {
            InputStream input = context.openFileInput(fileName);
            while ((thing = input.read()) != -1) {
                char character = (char) thing;
                text.append(character);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public static void writeSolvesToFile(String fileName, ArrayList<Solve> solves, Context context) {
        FileOutputStream outputStream;
        try {
            outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            for (Solve solve : solves) {
                outputStream.write(solve.toString().getBytes());
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Solve> readSolvesFromFile(String fileName, Context context) {
        StringBuilder text = new StringBuilder();
        int thing;
        try {
            InputStream input = context.openFileInput(fileName);
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
            Solve a = new Solve();
            a.time = Double.valueOf(solve);
            solves.add(a);
        }
        return solves;
    }
}
