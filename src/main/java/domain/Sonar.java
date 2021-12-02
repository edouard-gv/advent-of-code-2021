package domain;

import java.util.List;

public class Sonar {

    public static int countSimpleIncreases(List<Integer> measures) {
        return compareAtSteps(measures, 1);
    }

    public static int countCumulativeIncreases(List<Integer> measures) {
        return compareAtSteps(measures, 3);
    }

    private static int compareAtSteps(List<Integer> measures, int steps) {
        int count = 0;
        for (int i = steps; i < measures.size(); i++) {
            if (measures.get(i) > measures.get(i - steps)) {
                count++;
            }
        }
        return count;
    }
}
