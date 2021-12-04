package domain;

import domain.Analyser;
import domain.analyser.BitList;
import domain.analyser.Report;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static java.lang.Boolean.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

public class AnalyserTest {

    private static String EXAMPLE_STRING = """
00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010""";

    @Test
    public void gamma() {
        assertEquals(22, new Analyser(new Report(EXAMPLE_STRING.lines())).gamma());
    }

    @Test
    public void epsilon() {
        assertEquals(9, new Analyser(new Report(EXAMPLE_STRING.lines())).epsilon());
    }

    @Test
    public void oxygenRating() {
        assertEquals(23, new Analyser(new Report(EXAMPLE_STRING.lines())).rating(TRUE));
    }

    @Test
    public void CO2Rating() {
        assertEquals(10, new Analyser(new Report(EXAMPLE_STRING.lines())).rating(FALSE));
    }

    @Test
    public void bitListConstructor() {
        assertEquals(new BitList("0010"), new BitList(List.of(FALSE, FALSE, TRUE, FALSE)));
    }
}
