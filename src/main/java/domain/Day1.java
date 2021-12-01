package domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {
    public static List<Integer> readFile() throws IOException {
        Path path = Paths.get("src/main/resources/day1.txt");
        Stream<String> lines = Files.lines(path);
        return lines.map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int countIncrease(List<Integer> measures) {
        return 0;
    }
}
