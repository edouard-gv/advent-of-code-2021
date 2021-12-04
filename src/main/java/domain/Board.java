package domain;

import domain.bingo.Number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {
    private final int width;
    private final Map<Integer, Boolean> numbers;

    public Board(List<String> lines) {
        this.width = lines.size();
        this.numbers = lines.stream().flatMap(s -> Arrays.stream(s.split(" ")).map(Integer::parseInt)).collect(Collectors.toMap(i -> i, i -> Boolean.FALSE));
    }

    public int draw(int i) {
        numbers.put(i, Boolean.TRUE);
        if (numbers.get(1) && numbers.get(2) && numbers.get(3) && numbers.get(4) && numbers.get(5)) {
            return numbers.entrySet().stream().filter(e -> !e.getValue()).mapToInt(Map.Entry::getKey).sum()*i;
        }
        return -1;
    }
}
