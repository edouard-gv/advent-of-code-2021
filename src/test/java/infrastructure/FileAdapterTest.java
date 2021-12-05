package infrastructure;

import domain.Analyser;
import domain.Pilot;
import domain.Sonar;
import domain.analyser.Report;
import domain.bingo.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileAdapterTest {

    @Test
    public void readMeasuresInFileA() throws IOException {
        assertEquals(2000, FileAdapter.readIntegersFromFile("1").size());
        assertEquals(8895, FileAdapter.readIntegersFromFile("1").get(1999));
        assertEquals(149, FileAdapter.readIntegersFromFile("1").get(0));
    }

    @Test
    public void exerciseDay1Solution() throws IOException {
        Assertions.assertEquals(1616, Sonar.countSimpleIncreases(FileAdapter.readIntegersFromFile("1")));
        assertEquals(1645, Sonar.countCumulativeIncreases(FileAdapter.readIntegersFromFile("1")));
    }

    @Test
    public void exerciseDay2Solution() throws IOException {
        Pilot pilot = new Pilot();
        pilot.batchMove(FileAdapter.readStringStreamfromFile("2"));
        assertEquals(1698850445, pilot.multiplyHPerDepth());
    }

    @Test
    public void exerciseDay3SolutionA() throws IOException {
        Analyser analyser = new Analyser(new Report(FileAdapter.readStringStreamfromFile("3")));
        assertEquals(3242606,analyser.epsilon() * analyser.gamma());
    }

    @Test
    public void exerciseDay3SolutionB() throws IOException {
        Analyser analyser = new Analyser(new Report(FileAdapter.readStringStreamfromFile("3")));
        assertEquals(4856080,analyser.rating(Boolean.TRUE) * analyser.rating(Boolean.FALSE));
    }

    @Test
    public void exerciseDay4Solution() throws IOException {
        Game game = new Game(FileAdapter.readStringfromFile("4"));
        while (!game.draw());
        assertEquals(48, game.winnerIndex());
        assertEquals(31424, game.winnerScore());
    }


}
