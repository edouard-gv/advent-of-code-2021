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
        Path path = Paths.get("src/main/resources/day"+suffix+".txt");
        Stream<String> lines = Files.lines(path);
        return lines.map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int countSimpleIncreases(List<Integer> measures) {
        int count = 0;
        for (int i = 1; i < measures.size(); i++) {
            if (measures.get(i) > measures.get(i-1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(countSimpleIncreases(readFile("1")));
        System.out.println(countCumulativeIncreases(readFile("1")));
    }

    public static int countCumulativeIncreases(List<Integer> measures) {
        int count = 0;
        for (int i = 3; i < measures.size(); i++) {
            if (measures.get(i-2) + measures.get(i-1) + measures.get(i)
                    > measures.get(i-3) + measures.get(i-2) + measures.get(i-1)) {
                count++;
            }
        }
        return count;
    }
}
