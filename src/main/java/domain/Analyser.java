package domain;

import domain.analyser.Report;

public class Analyser {

    public static int gamma(Report report) {
        return report.mostCommonBitStream().decimal();
    }

    public static int epsilon(Report report) {
        return report.mostCommonBitStream().invert().decimal();
    }
}
