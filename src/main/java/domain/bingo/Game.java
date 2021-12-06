package domain.bingo;

import domain.Board;

import java.util.*;
import java.util.stream.Stream;

public class Game {
    private final List<Board> boards;
    private final List<Number> draws;
    private Board winner;
    private Optional<Score> winnerScore;

    public Game(String input) {
        List<String> stringBoards = Arrays.stream(input.replaceAll("\\r\\n", "\n").split("\\n\\n")).toList();
        this.draws = Arrays.stream(stringBoards.get(0).split(",")).mapToInt(Integer::parseInt).mapToObj(Number::new).toList();
        stringBoards = new ArrayList<>(stringBoards);
        stringBoards.remove(0);
        this.boards = stringBoards.stream().map(String::lines).map(Stream::toList).map(Board::new).toList();
        this.winnerScore = Optional.empty();
    }

    public List<Board> boards() {
        return boards;
    }

    public List<Number> draws() {
        return draws;
    }

    public Optional<Score> winnerScore() {
        return this.winnerScore;
    }

    public void stopAtFirstWinner() {
        for (Number numberDrawn : draws) {
            for (Board board : boards) {
                winnerScore = board.draw(numberDrawn);
                if (winnerScore.isPresent()) {
                    winner = board;
                    return;
                }
            }
        }
    }

    public void stopAtLastWinner() {
        Set<Board> winners = new HashSet<>();
        for (Number numberDrawn : draws) {
            List<Board> losers = new ArrayList<>(this.boards);
            losers.removeAll(winners);
            for (Board board : losers) {
                Optional<Score> score = board.draw(numberDrawn);
                if (score.isPresent()) {
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
