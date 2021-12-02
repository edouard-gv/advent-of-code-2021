package infrastructure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAdapter {
    public static List<Integer> readIntegersInFile(String suffix) throws IOException {
        Stream<String> lines = readStringStreamInFile(suffix);
        return lines.map(Integer::parseInt).collect(Collectors.toList());
    }

    public static Stream<String> readStringStreamInFile(String suffix) throws IOException {
        Path path = Paths.get("src/main/resources/day" + suffix + ".txt");
        return Files.lines(path);
    }
}
