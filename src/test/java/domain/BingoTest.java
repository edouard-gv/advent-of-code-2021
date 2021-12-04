package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(31 * 4 * 5 / 2 * 5, board.draw(5));
    }

    @Test
    public void bingoThirdLine() {
        Board board = new Board(INPUT.lines().toList());
        board.draw(11);
        board.draw(12);
        board.draw(13);
        board.draw(14);
        assertEquals(26 * 4 * 5 / 2 * 15, board.draw(15));
    }
}
