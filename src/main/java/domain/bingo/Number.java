package domain.bingo;

import java.util.Objects;

public final class Number {
    private final Integer value;
    private Boolean marked;

    public Number(Integer value) {
        this.value = value;
        this.marked = false;
    }

    public Integer value() {
        return value;
    }

    public Boolean marked() {
        return marked;
    }

    public void setMarked() {
        this.marked = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Number) obj;
        return Objects.equals(this.value, that.value) &&
                Objects.equals(this.marked, that.marked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, marked);
    }

    @Override
    public String toString() {
        return "Number[" +
                "value=" + value + ", " +
                "marked=" + marked + ']';
    }

}
