package domain;

import domain.bingo.Game;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingoTest {

    public static final String UNIT_INPUT = """
            1 2 3 4 5
            6 7 8 9 10
            11 12 13 14 15
            16 17 18 19 20
            21 22 23 24 25""";

    public static final String ACCEPTANCE_INPUT = """
            7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
                        
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
                        
             3 15  0  2 22
             9 18 13 17  5
            19  8  7 25 23
            20 11 10 24  4
            14 21 16 12  6
                        
            14 21 17 24  4
            10 16 15  9 19
            18  8 23 26 20
            22 11 13  6  5
             2  0 12  3  7""";

    @Test
    public void bingoFirst() {
        Board board = new Board(UNIT_INPUT.lines().toList());
        assertEquals(-1, board.draw(1));
    }

    @Test
    public void bingoFirstLine() {
        Board board = new Board(UNIT_INPUT.lines().toList());
        board.draw(1);
        board.draw(2);
        board.draw(3);
        board.draw(4);
        assertEquals(31 * 4 * 5 / 2 * 5, board.draw(5));
    }

    @Test
    public void bingoThirdLine() {
        Board board = new Board(UNIT_INPUT.lines().toList());
        board.draw(11);
        board.draw(12);
        board.draw(13);
        board.draw(14);
        assertEquals(26 * 4 * 5 / 2 * 15, board.draw(15));
    }

    @Test
    public void bingoNoLines() {
        Board board = new Board(UNIT_INPUT.lines().toList());
        board.draw(1);
        board.draw(12);
        board.draw(3);
        board.draw(14);
        assertEquals(-1, board.draw(5));
    }

    @Test
    public void bingoColumns() {
        Board board = new Board(UNIT_INPUT.lines().toList());
        board.draw(2);
        board.draw(7);
        board.draw(12);
        board.draw(17);
        assertEquals((26*25/2-2-7-12-17-22)*22, board.draw(22));
    }

    @Test
    public void acceptanceTest() {
        Game game = new Game(ACCEPTANCE_INPUT);
        assertArrayEquals(new int[]{7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1}, game.draws());
        assertEquals(3, game.boards().size());
        while (!game.draw());
        assertEquals(2, game.winnerIndex());
        assertEquals(4512, game.winnerScore());
    }
}
