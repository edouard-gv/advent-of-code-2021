package domain;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SonarTest {

    @Test
    public void simpleCountWithNoLines() {
        assertEquals(0, Sonar.countSimpleIncreases(List.of()));
    }

    @Test
    public void simpleCountWithOneLine() {
        assertEquals(0, Sonar.countSimpleIncreases(List.of(1)));
    }

    @Test
    public void simpleCountWithTwoLineIncrease() {
        assertEquals(1, Sonar.countSimpleIncreases(List.of(1, 2)));
    }

    @Test
    public void simpleCountWithTwoLineDecrease() {
        assertEquals(0, Sonar.countSimpleIncreases(List.of(2, 1)));
    }

    @Test
    public void simpleCountInGeneral() {
        assertEquals(7, Sonar.countSimpleIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)));
    }

    @Test
    public void cumulativeCountWithZeroToTwoLines_shouldReturn0() {
        assertEquals(0, Sonar.countCumulativeIncreases(List.of()));
        assertEquals(0, Sonar.countCumulativeIncreases(List.of(1)));
        assertEquals(0, Sonar.countCumulativeIncreases(List.of(1, 2)));
        assertEquals(0, Sonar.countCumulativeIncreases(List.of(1, 2, 3)));
    }

    @Test
    public void cumulativeCountWithFourLinesDecrease_shouldReturn0() {
        assertEquals(0, Sonar.countCumulativeIncreases(List.of(1, 2, 1, 1)));
    }

    @Test
    public void cumulativeCountWithFourLinesFlat_shouldReturn0() {
        assertEquals(0, Sonar.countCumulativeIncreases(List.of(1, 2, 2, 1)));
    }

    @Test
    public void cumulativeCountWithFourLinesDecrease_shouldReturn1() {
        assertEquals(1, Sonar.countCumulativeIncreases(List.of(1, 2, 2, 2)));
    }

    @Test
    public void cumulativeCountInGeneral() {
        assertEquals(5, Sonar.countCumulativeIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)));
    }
}
