package domain.analyser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {
    @Test
    public void mostCommonBit() {
        Assertions.assertTrue(Report.mostCommonBit(List.of(TRUE, TRUE, FALSE)));
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
    public void mostCommonBitList() {
        Stream<String> input = """
0010
0001
0011
0110""".lines();
        Assertions.assertEquals(new BitList(List.of(FALSE, FALSE, TRUE, TRUE)), new Report(input).mostCommonBitStream());
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
}
