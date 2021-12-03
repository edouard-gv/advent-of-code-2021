package domain.analyser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BitStream {
    private Stream<Boolean> bits;
    private List<Boolean> streamedList;

    public BitStream(Stream<Boolean> bits) {
        this.bits = bits;
    }

    public int decimal() {
        return Integer.parseInt(getBits().map(b -> (b ? "1" : "0")).collect(Collectors.joining()), 2);
    }

    public Stream<Boolean> getBits() {
        return bits;
    }

    public BitStream invert() {
        return new BitStream(this.bits.map(b -> !b));
    }

    private List<Boolean> toList() {
        if (streamedList == null) {
            streamedList = bits.toList();
        }
        return streamedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BitStream bitStream = (BitStream) o;
        return this.toList().equals(bitStream.toList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toList());
    }

    @Override
    public String toString() {
        return this.toList().toString();
    }
}
