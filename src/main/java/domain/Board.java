package domain;

import domain.bingo.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Board {
    private final int width;
    private final List<Number> numbers;

    public Board(List<String> lines) {
        this.width = lines.size();
        this.numbers = lines.stream().flatMap(s -> Arrays.stream(s.split(" ")).map(Integer::parseInt)).map(Number::new).toList();
    }

    public int draw(int i) {
        Optional<Number> found = this.numbers.stream().filter(n -> n.value() == i).findFirst();
        if (found.isEmpty()) {
            return -1;
        }

        found.get().setMarked();

        for (int l = 0; l < width; l++) {
            boolean bingo = true;
            for (int c = 0; c < width; c++) {
                if (!numbers.get(l * width + c).marked()) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                return numbers.stream().filter(n -> !n.marked()).mapToInt(Number::value).sum() * i;
            }
        }

        for (int c = 0; c < width; c++) {
            boolean bingo = true;
            for (int l = 0; l < width; l++) {
                if (!numbers.get(l * width + c).marked()) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                return numbers.stream().filter(n -> !n.marked()).mapToInt(Number::value).sum() * i;
            }
        }
        return -1;
    }
}
