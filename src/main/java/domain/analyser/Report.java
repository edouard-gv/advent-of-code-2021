package domain.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Report {
    private final Stream<String> lines;

    public Report(Stream<String> lines) {
        this.lines = lines;
    }

    static Boolean mostCommonBit(List<Boolean> bits) {
        return bits.stream().filter(b -> b).count() > bits.size() / 2;
    }

    Stream<List<Boolean>> splitStringsInColumns() {
        List<String> inputList = lines.toList();
        int width = inputList.get(0).length();
        int height = inputList.size();
        List<List<Boolean>> output = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            List<Boolean> column = new ArrayList<>(height);
            for (String s : inputList) {
                column.add('1' == s.charAt(i));
            }
            output.add(column);
        }
        return output.stream();
    }

    public BitStream mostCommonBitStream() {
        return new BitStream(this.splitStringsInColumns().map(Report::mostCommonBit));
    }

}
