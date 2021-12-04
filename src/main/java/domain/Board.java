package domain;

import domain.bingo.Number;

import java.util.Arrays;
import java.util.List;

public class Board {
    private final int width;
    private final List<Number> numbers;

    public Board(List<String> lines) {
        this.width = lines.size();
        this.numbers = lines.stream().flatMapToInt(s -> Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt)).mapToObj(num -> new Number(num, Boolean.FALSE)).toList();
    }

    public int draw(int i) {
        return -1;
    }
}
