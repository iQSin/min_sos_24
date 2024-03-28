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

        int midIndex = sorted.size()/2;
        return sorted.get(midIndex);
    }

    public static double calcStdev(ArrayList<Double> values) {
        double mean = Statistics.calcMean(values);
        double avvikelse = 0;
        for (int i= 0; i < values.size(); i++) {
            avvikelse += Math.pow((values.get(i)-mean), 2);
        }
        double varians = avvikelse / values.size();

        double stdev = Math.sqrt(varians);
        return stdev;
    }

}