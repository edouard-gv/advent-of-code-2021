package domain;

public class Pilot {
    private Position position;

    public Pilot() {
        this.position = new Position(0,0);
    }

    public Position position() {
        return position;
    }

    public void move(Move move) {
        switch (move.direction()) {
            case forward -> this.position = new Position(
                    this.position.h()+move.distance(),
                    this.position.depth());
            case up -> this.position = new Position(
                    this.position.h(),
                    this.position.depth()-move.distance());
            case down -> this.position = new Position(
                    this.position.h(),
                    this.position.depth()+move.distance());
        }
    }
}
