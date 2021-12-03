package domain;

import org.junit.jupiter.api.Test;
import static java.lang.Boolean.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

public class AnalyserTest {

    private static String EXAMPLE_INPUT= """
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
    public void mostCommonBit() {
        assertFalse(Analyser.mostCommonBit(List.of(TRUE, FALSE, FALSE)));
        assertTrue(Analyser.mostCommonBit(List.of(TRUE, TRUE, FALSE)));
    }

    @Test
    public void splitStringsInCulumns() {
        Stream<String> input = """
0010
0100
0110""".lines();
        assertEquals(List.of(List.of(FALSE, FALSE, FALSE), List.of(FALSE, TRUE, TRUE), List.of(TRUE, FALSE, TRUE), List.of(FALSE, FALSE, FALSE)), Analyser.splitStringsInCulumns(input).toList());
    }

    @Test
    public void mostCommonBitList() {
        Stream<String> input = """
0010
0101
0110""".lines();
        assertEquals(List.of(FALSE, TRUE, TRUE, FALSE), Analyser.mostCommonBitStream(input).toList());
    }

    @Test
    public void convertBooleanListToDecimal() {
        assertEquals(22, Analyser.convertBooleanListToDecimal(Stream.of(TRUE, FALSE, TRUE, TRUE, FALSE)));
    }

    @Test
    public void gamma() {
        assertEquals(22, Analyser.gamma(EXAMPLE_INPUT.lines()));
    }

    @Test
    public void epsilon() {
        assertEquals(9, Analyser.epsilon(EXAMPLE_INPUT.lines()));
    }
}
