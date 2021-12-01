package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {

    public static List<Integer> readFile(String suffix) throws IOException {
        Path path = Paths.get("src/main/resources/day" + suffix + ".txt");
        Stream<String> lines = Files.lines(path);
        return lines.map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int countSimpleIncreases(List<Integer> measures) {
        return compareAtSteps(measures, 1);
    }

    public static int countCumulativeIncreases(List<Integer> measures) {
        return compareAtSteps(measures, 3);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countSimpleIncreases(readFile("1")));
        System.out.println(countCumulativeIncreases(readFile("1")));
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
