package domain;

import domain.pilot.Command;
import domain.pilot.Direction;
import domain.pilot.Position;

import java.util.stream.Stream;

public class Pilot {
    private Position position;

    public Pilot() {
        this.position = new Position(0, 0, 0);
    }

    public Position position() {
        return position;
    }

    public void move(Command command) {
        switch (command.direction()) {
            case forward -> this.position = new Position(
                    this.position.h() + command.distance(),
                    this.position.depth() + this.position().aim() * command.distance(),
                    this.position().aim());
            case up -> this.position = new Position(
                    this.position.h(),
                    this.position.depth(),
                    this.position.aim() - command.distance());
            case down -> this.position = new Position(
                    this.position.h(),
                    this.position.depth(),
                    this.position.aim() + command.distance());
        }
    }

    public void batchMove(Stream<String> commands) {
        commands.map(
                l -> new Command(Direction.valueOf(l.split(" ")[0]), Integer.parseInt(l.split(" ")[1]))
                ).forEach(this::move);
    }

    public int multiplyHPerDepth() {
        return position.h() * position.depth();
    }
}
