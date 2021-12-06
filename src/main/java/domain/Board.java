package domain;

import domain.bingo.Number;
import domain.bingo.Score;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Board {
    private final int width;
    private final List<Number> numbers;

    public Board(List<String> lines) {
        this.width = lines.size();
        this.numbers = lines.stream().map(String::trim).flatMap(s -> Arrays.stream(s.split(" +")).map(Integer::parseInt)).map(Number::new).toList();
    }

    public Optional<Score> draw(Number numberDrawn) {
        Optional<Number> optionalFound = numberDrawn.findIn(this.numbers);
        if (optionalFound.isEmpty()) {
            return Optional.empty();
        }

        optionalFound.get().setMarked();

        Optional<Score> score = checkIfWonAndThenReturnScore(numberDrawn, true);
        if (score.isPresent()) return score;

        score = checkIfWonAndThenReturnScore(numberDrawn, false);
        if (score.isPresent()) return score;

        return Optional.empty();
    }

    private Optional<Score> checkIfWonAndThenReturnScore(Number numberDrawn, boolean direction) {
        for (int i = 0; i < width; i++) {
            boolean bingo = true;
            for (int j = 0; j < width; j++) {
                if (!getNumberAt(direction ? j : i, direction ? i : j).marked()) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                return Optional.of(computeScore(numberDrawn));
            }
        }
        return Optional.empty();
    }

    private Number getNumberAt(int i, int j) {
        return numbers.get(j * width + i);
    }

    private Score computeScore(Number number) {
        return new Score(numbers.stream().filter(n -> !n.marked()).mapToInt(Number::value).sum() * number.value());
    }

    @Override
    public String toString() {
        return "Board{" +
                "numbers=" + numbers +
                '}';
    }
}
