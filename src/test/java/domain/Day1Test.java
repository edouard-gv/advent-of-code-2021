package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class Day1Test {

    @Test
    public void readMeasuresInFileA() throws IOException {
        assertEquals(2000, Day1.readFile("1").size());
        assertEquals(8895, Day1.readFile("1").get(1999));
        assertEquals(149, Day1.readFile("1").get(0));
    }

    @Test
    public void simpleCountWithNoLines() {
        assertEquals(0, Day1.countSimpleIncreases(List.of()));
    }

    @Test
    public void simpleCountWithOneLine() {
        assertEquals(0, Day1.countSimpleIncreases(List.of(1)));
    }

    @Test
    public void simpleCountWithTwoLineIncrease() {
        assertEquals(1, Day1.countSimpleIncreases(List.of(1, 2)));
    }

    @Test
    public void simpleCountWithTwoLineDecrease() {
        assertEquals(0, Day1.countSimpleIncreases(List.of(2, 1)));
    }

    @Test
    public void simpleCountInGeneral() {
        assertEquals(7, Day1.countSimpleIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)));
    }

    @Test
    public void cumulativeCountWithZeroToTwoLines_shouldReturn0() {
        assertEquals(0, Day1.countCumulativeIncreases(List.of()));
        assertEquals(0, Day1.countCumulativeIncreases(List.of(1)));
        assertEquals(0, Day1.countCumulativeIncreases(List.of(1, 2)));
        assertEquals(0, Day1.countCumulativeIncreases(List.of(1, 2, 3)));
    }

    @Test
    public void cumulativeCountWithFourLinesDecrease_shouldReturn0() {
        assertEquals(0, Day1.countCumulativeIncreases(List.of(1, 2, 1, 1)));
    }

    @Test
    public void cumulativeCountWithFourLinesFlat_shouldReturn0() {
        assertEquals(0, Day1.countCumulativeIncreases(List.of(1, 2, 2, 1)));
    }

    @Test
    public void cumulativeCountWithFourLinesDecrease_shouldReturn1() {
        assertEquals(1, Day1.countCumulativeIncreases(List.of(1, 2, 2, 2)));
    }

    @Test
    public void cumulativeCountInGeneral() {
        assertEquals(5, Day1.countCumulativeIncreases(List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)));
    }

    @Test
    public void exerciseASolution() throws IOException {
        assertEquals(1616, Day1.countSimpleIncreases(Day1.readFile("1")));
        assertEquals(1645, Day1.countCumulativeIncreases(Day1.readFile("1")));
    }

}
