package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class Day1Test {

    @Test
    public void readMeasuresInFileA() throws IOException {
        assertEquals(2000, Day1.readFile("a").size());
        assertEquals(8895, Day1.readFile("a").get(1999));
        assertEquals(149, Day1.readFile("a").get(0));
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


}
