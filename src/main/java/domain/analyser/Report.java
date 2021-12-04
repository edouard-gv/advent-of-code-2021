package domain.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Report {
    private final List<String> lines;

    public Report(Stream<String> lines) {
        this.lines = lines.toList();
    }

    static Boolean mostCommonBit(List<Boolean> bits) {
        return bits.stream().filter(b -> b).count() >= bits.size() / 2.0;
    }

    Stream<List<Boolean>> splitStringsInColumns() {
        int width = lines.get(0).length();
        int height = lines.size();
        List<List<Boolean>> output = new ArrayList<>(width);
        for (int i = 0; i < width; i++) {
            List<Boolean> column = new ArrayList<>(height);
            for (String s : lines) {
                column.add('1' == s.charAt(i));
            }
            output.add(column);
        }
        return output.stream();
    }

    public BitList mostCommonBitStream() {
        return new BitList(this.splitStringsInColumns().map(Report::mostCommonBit).toList());
    }

    public BitList leastCommonBitStream() {
        return new BitList(this.splitStringsInColumns().map(Report::mostCommonBit).toList()).invert();
    }


    List<String> filterLinesWithBitAtPosition(Boolean bit, int i) {
        return lines.stream().filter(s -> (s.charAt(i) == '1') == bit).toList();
    }

    public BitList rating(Boolean bitCriteria, int pos) {
        List<String> filteredList = this.filterLinesWithBitAtPosition(this.mostCommonBitStream().get(pos) == bitCriteria, pos);
        if (filteredList.size() == 1) {
            return new BitList(filteredList.get(0));
        }
        return new Report(filteredList.stream()).rating(bitCriteria, pos+1);
    }
}
