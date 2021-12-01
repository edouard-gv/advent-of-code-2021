package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import domain.Day1;

import java.io.IOException;
import java.util.List;


public class Day1Test {

    @Test
    public void getLinesOfCode() throws IOException {
        assertEquals(2000, Day1.readFile().size());
        assertEquals(8895, Day1.readFile().get(1999));
        assertEquals(149, Day1.readFile().get(0));
    }

    @Test
    public void countWithNoLines() {
        assertEquals(0, Day1.countIncrease(List.of()));
    }

    @Test
    public void countWithOneLine() {
        assertEquals(0, Day1.countIncrease(List.of(1)));
    }

    @Test
    public void countWithRwoLineIncrease() {
        assertEquals(1, Day1.countIncrease(List.of(1, 2)));
    }
}
