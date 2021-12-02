package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilotTest {
    @Test
    public void initialPosition() {
        Pilot pilot = new Pilot();
        assertEquals(new Position(0, 0), pilot.position());
    }

    @Test
    public void moveForward() {
        Pilot pilot = new Pilot();
        pilot.move(new Move(Direction.forward, 5));
        assertEquals(new Position(5, 0), pilot.position());
    }

    @Test
    public void moveDown() {
        Pilot pilot = new Pilot();
        pilot.move(new Move(Direction.down, 5));
        assertEquals(new Position(0, 5), pilot.position());
    }

    @Test
    public void moveUp() {
        Pilot pilot = new Pilot();
        pilot.move(new Move(Direction.up, 5));
        assertEquals(new Position(0, -5), pilot.position());
    }
}
