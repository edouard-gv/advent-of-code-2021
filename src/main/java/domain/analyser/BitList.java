package domain.analyser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BitList {
    private List<Boolean> bits;

    public BitList(List<Boolean> bits) {
        this.bits = bits;
    }

    public BitList(String stringRepresentation) {
        this(stringRepresentation.chars().mapToObj(c -> (char) c).map(c -> (c == '1')).toList());
    }

    public int decimal() {
        return Integer.parseInt(bits.stream().map(b -> (b ? "1" : "0")).collect(Collectors.joining()), 2);
    }

    public BitList invert() {
        return new BitList(this.bits.stream().map(b -> !b).toList());
    }

    public Boolean get(int pos) {
        return bits.get(pos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitList bitList = (BitList) o;
        return bits.equals(bitList.bits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bits);
    }

    @Override
    public String toString() {
        return "BitStream{" +
                "bits=" + bits +
                '}';
    }
}
