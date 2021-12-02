package infrastructure;

import domain.Sonar;
import infrastructure.FileAdapter;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAdapterTest {

    @Test
    public void readMeasuresInFileA() throws IOException {
        assertEquals(2000, FileAdapter.readFile("1").size());
        assertEquals(8895, FileAdapter.readFile("1").get(1999));
        assertEquals(149, FileAdapter.readFile("1").get(0));
    }

    @Test
    public void exerciseASolution() throws IOException {
        Assertions.assertEquals(1616, Sonar.countSimpleIncreases(FileAdapter.readFile("1")));
        assertEquals(1645, Sonar.countCumulativeIncreases(FileAdapter.readFile("1")));
    }
}
