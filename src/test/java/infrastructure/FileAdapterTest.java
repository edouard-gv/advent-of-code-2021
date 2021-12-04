package infrastructure;

import domain.Analyser;
import domain.Pilot;
import domain.Sonar;
import domain.analyser.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAdapterTest {

    @Test
    public void readMeasuresInFileA() throws IOException {
        assertEquals(2000, FileAdapter.readIntegersInFile("1").size());
        assertEquals(8895, FileAdapter.readIntegersInFile("1").get(1999));
        assertEquals(149, FileAdapter.readIntegersInFile("1").get(0));
    }

    @Test
    public void exerciseDay1Solution() throws IOException {
        Assertions.assertEquals(1616, Sonar.countSimpleIncreases(FileAdapter.readIntegersInFile("1")));
        assertEquals(1645, Sonar.countCumulativeIncreases(FileAdapter.readIntegersInFile("1")));
    }

    @Test
    public void exerciseDay2Solution() throws IOException {
        Pilot pilot = new Pilot();
        pilot.batchMove(FileAdapter.readStringStreamInFile("2"));
        assertEquals(1698850445, pilot.multiplyHPerDepth());
    }

    @Test
    public void exerciseDay3SolutionA() throws IOException {
        Analyser analyser = new Analyser(new Report(FileAdapter.readStringStreamInFile("3")));
        assertEquals(3242606,analyser.epsilon() * analyser.gamma());
    }

    @Test
    public void exerciseDay3SolutionB() throws IOException {
        Analyser analyser = new Analyser(new Report(FileAdapter.readStringStreamInFile("3")));
        assertEquals(4856080,analyser.rating(Boolean.TRUE) * analyser.rating(Boolean.FALSE));
    }
}
