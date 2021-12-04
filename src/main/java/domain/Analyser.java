package domain;

import domain.analyser.Report;

public class Analyser {

    private final Report report;

    public Analyser(Report report) {

        this.report = report;
    }

    public int gamma() {
        return this.report.mostCommonBitStream().decimal();
    }

    public int epsilon() {
        return this.report.leastCommonBitStream().decimal();
    }

    public int rating(Boolean bitCriteria) {
        return this.report.rating(bitCriteria, 0).decimal();
    }
}
