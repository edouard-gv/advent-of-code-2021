package domain.analyser;

import domain.Analyser;
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
    public void mostCommonBit() {
        assertFalse(Report.mostCommonBit(List.of(TRUE, FALSE, FALSE)));
        assertTrue(Report.mostCommonBit(List.of(TRUE, TRUE, FALSE)));
    }

    @Test
    public void splitStringsInCulumns() {
        Stream<String> input = """
0010
0100
0110""".lines();
        assertEquals(List.of(List.of(FALSE, FALSE, FALSE), List.of(FALSE, TRUE, TRUE), List.of(TRUE, FALSE, TRUE), List.of(FALSE, FALSE, FALSE)),
                new Report(input).splitStringsInColumns().toList());
    }

    @Test
    public void mostCommonBitList() {
        Stream<String> input = """
0010
0101
0110""".lines();
        assertEquals(new BitStream(Stream.of(FALSE, TRUE, TRUE, FALSE)), new Report(input).mostCommonBitStream());
    }

    @Test
    public void convertBooleanListToDecimal() {
        Assertions.assertEquals(22, new BitStream(Stream.of(TRUE, FALSE, TRUE, TRUE, FALSE)).decimal());
    }

    @Test
    public void gamma() {
        assertEquals(22, Analyser.gamma(new Report(EXAMPLE_STRING.lines())));
    }

    @Test
    public void epsilon() {
        assertEquals(9, Analyser.epsilon(new Report(EXAMPLE_STRING.lines())));
    }
}
