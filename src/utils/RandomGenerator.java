package utils;

import java.text.DecimalFormat;

public class RandomGenerator {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double generateRandomNumber(double min, double max) {
        return Double.parseDouble(df.format(((Math.random() * (max - min)) + min)));
    }

}