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
    private int winnerIndex;
    private int winnerScore;

    public Game(String input) {
        List<String> stringBoards = Arrays.stream(input.replaceAll("\\r\\n", "\n").split("\\n\\n")).toList();
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
        winnerIndex = 0;
        for (Board board: boards) {
            winnerScore = board.draw(draws[turn]);
            if (winnerScore > -1) {
                return true;
            }
            winnerIndex ++;
        }
        turn++;
        return false;
    }

    public int winnerIndex() {
        return this.winnerIndex;
    }

    public int winnerScore() {
        return this.winnerScore;
    }
}
