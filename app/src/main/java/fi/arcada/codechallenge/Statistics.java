package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collections;

public class Statistics {


    public static double calcMean(ArrayList<Double> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);

        }
        return sum / values.size();
    }

    public static double calcMedian(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(values);

        int midIndex = sorted.size() / 2;
        return sorted.get(midIndex);
    }

    public static double calcStdev(ArrayList<Double> values) {
        double mean = Statistics.calcMean(values);
        double avvikelse = 0;
        for (int i = 0; i < values.size(); i++) {
            avvikelse += Math.pow((values.get(i) - mean), 2);
        }
        double varians = avvikelse / values.size();

        double stdev = Math.sqrt(varians);
        return stdev;
    }

    public static double calcType(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(values);

        double mostCommonNumber = values.get(0);
        double currentNumber = values.get(0);
        int currentCount = 1;
        int maxCount = 1;
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostCommonNumber = currentNumber;
                }
                currentNumber = values.get(i);
                currentCount = 1;


            }
            if (currentCount > maxCount) {
                mostCommonNumber = currentNumber;
            }

        }

        return mostCommonNumber;
    }

    public static double calcLQ(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(values);

        double lqIndex = sorted.size() * 0.25;
        return sorted.get((int) lqIndex);
    }
    public static double calcUQ(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);
        Collections.sort(values);

        double uqIndex = sorted.size() * 0.75;
        return sorted.get((int) uqIndex);
    }
    public static double calcIQR(ArrayList<Double> values) {
    double lq = calcLQ(values);
    double uq = calcUQ(values);
        return uq-lq;
    }
}