package domain;

public class Pilot {
    private Position position;

    public Pilot() {
        this.position = new Position(0,0);
    }

    public Position position() {
        return position;
    }
}
