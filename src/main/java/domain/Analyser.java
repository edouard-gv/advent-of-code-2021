package domain;

import domain.analyser.Report;

public class Analyser {

    private Report report;

    public Analyser(Report report) {

        this.report = report;
    }

    public int gamma() {
        return this.report.mostCommonBitStream().decimal();
    }

    public int epsilon() {
        return this.report.mostCommonBitStream().invert().decimal();
    }
}
