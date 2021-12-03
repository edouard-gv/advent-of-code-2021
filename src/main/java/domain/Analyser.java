package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.TRUE;

public class Analyser {
    public static Boolean mostCommonBit(List<Boolean> bits) {
        return bits.stream().filter(b -> b).count() > bits.size() / 2;
    }

    public static Stream<List<Boolean>> splitStringsInCulumns(Stream<String> input) {
        List<String> inputList = input.toList();
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

    public static Stream<Boolean> mostCommonBitStream(Stream<String> input) {
        return splitStringsInCulumns(input).map(Analyser::mostCommonBit);
    }

    public static int convertBooleanListToDecimal(Stream<Boolean> bits) {
        return Integer.parseInt(bits.map(b -> (b?"1":"0")).collect(Collectors.joining()), 2);
    }

    public static int gamma(Stream<String> lines) {
        return convertBooleanListToDecimal(mostCommonBitStream(lines));
    }

    public static int epsilon(Stream<String> lines) {
        return convertBooleanListToDecimal(mostCommonBitStream(lines).map(b -> !b));
    }
}
