package domain.bingo;

import domain.Board;

import java.util.*;
import java.util.stream.Stream;

public class Game {
    private final List<Board> boards;
    private final int[] draws;
    private int turn;
    private Board winner;
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
        for (Board board: boards) {
            winnerScore = board.draw(draws[turn]);
            if (winnerScore > -1) {
                winner = board;
                return true;
            }
        }
        turn++;
        return false;
    }

    public Board winner() {
        return this.winner;
    }

    public int winnerScore() {
        return this.winnerScore;
    }

    public void stopAtFirstWinner() {
        while (!draw());
    }

    public void stopAtLastWinner() {
        Set<Board> winners = new HashSet<>();
        for (int i = 0; i < draws.length; i++) {
            List<Board> losers = new ArrayList<>(this.boards);
            losers.removeAll(winners);
            for (Board board : losers) {
                int score = board.draw(draws[i]);
                if (score > -1) {
                    winners.add(board);
                    winner = board;
                    winnerScore = score;
                }
            }
        }
    }

    public int winnerIndex() {
        return boards.indexOf(winner);
    }
}
