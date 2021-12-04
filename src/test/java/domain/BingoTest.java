package domain;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BingoTest {
    @Test
    public void bingo() {
        String input = """
1 2 3 4 5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0""";
        Board board = new Board(input.lines().toList());
        assertEquals(-1, board.draw(1));
    }
}
