package domain;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BingoTest {

    public static final String INPUT = """
            1 2 3 4 5
            6 7 8 9 10
            11 12 13 14 15
            16 17 18 19 20
            21 22 23 24 25""";

    @Test
    public void bingo() {
        Board board = new Board(INPUT.lines().toList());
        assertEquals(-1, board.draw(1));
    }

    @Test
    public void bingoFirstLine() {
        Board board = new Board(INPUT.lines().toList());
        board.draw(1);
        board.draw(2);
        board.draw(3);
        board.draw(4);
        assertEquals(31*4*5/2*5, board.draw(5));
    }
}
