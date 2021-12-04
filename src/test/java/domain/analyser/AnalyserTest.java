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
        assertTrue(Report.mostCommonBit(List.of(TRUE, TRUE, FALSE)));
    }

    @Test
    public void leastCommonBit() {
        assertTrue(!Report.mostCommonBit(List.of(TRUE, FALSE, FALSE)));
    }

    @Test
    public void mostCommonBitBorderCases() {
        assertTrue(Report.mostCommonBit(List.of(TRUE, FALSE, FALSE, TRUE)));

        //Vérifions que !mostCommonBit est bien leastCommonBit : en cas d'égalité, on doit trouver 0 comme bit le moins commun
        assertFalse(!Report.mostCommonBit(List.of(TRUE, FALSE, FALSE, TRUE)));
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
0001
0011
0110""".lines();
    assertEquals(new BitList(List.of(FALSE, FALSE, TRUE, TRUE)), new Report(input).mostCommonBitStream());
    }

    @Test
    public void leastCommonBitList() {
        Stream<String> input = """
0010
0001
0011
0110""".lines();
        assertEquals(new BitList(List.of(TRUE, TRUE, FALSE, FALSE)), new Report(input).leastCommonBitStream());
    }

    @Test
    public void convertBooleanListToDecimal() {
        Assertions.assertEquals(22, new BitList(List.of(TRUE, FALSE, TRUE, TRUE, FALSE)).decimal());
    }

    @Test
    public void gamma() {
        assertEquals(22, new Analyser(new Report(EXAMPLE_STRING.lines())).gamma());
    }

    @Test
    public void epsilon() {
        assertEquals(9, new Analyser(new Report(EXAMPLE_STRING.lines())).epsilon());
    }

    @Test
    public void filterLinesWithBitAtPosition() {
        String input ="""
000
010
011
101
                """;

        assertEquals(List.of("010", "011"), new Report(input.lines()).filterLinesWithBitAtPosition(TRUE, 1));
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
