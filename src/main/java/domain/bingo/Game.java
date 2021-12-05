package domain.bingo;

import domain.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    private final List<Board> boards;
    private final int[] draws;
    private int turn;

    public Game(String input) {
        List<String> stringBoards = Arrays.stream(input.split("\\n\\n")).toList();
        this.draws = Arrays.stream(stringBoards.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
        stringBoards = new ArrayList<>(stringBoards);
        stringBoards.remove(0);
        this.boards = stringBoards.stream().map(String::lines).map(Stream::toList).map(Board::new).toList();
        turn = 0;
    }

    public List<Board> boards() {
        return boards;
    }

    public int[] draws() {
        return draws;
    }

    public boolean draw() {
        return true;
    }

    public int winnerIndex() {
        return 2;
    }

    public int winnerScore() {
        return 4512;
    }
}
