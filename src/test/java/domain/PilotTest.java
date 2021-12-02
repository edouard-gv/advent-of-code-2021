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
        pilot.move(new Command(Direction.forward, 5));
        assertEquals(new Position(5, 0), pilot.position());
    }

    @Test
    public void moveDown() {
        Pilot pilot = new Pilot();
        pilot.move(new Command(Direction.down, 5));
        assertEquals(new Position(0, 5), pilot.position());
    }

    @Test
    public void moveUp() {
        Pilot pilot = new Pilot();
        pilot.move(new Command(Direction.up, 5));
        assertEquals(new Position(0, -5), pilot.position());
    }

    @Test
    public void acceptanceTest() {
        String commands = """
forward 5
down 5
forward 8
up 3
down 8
forward 2""";
        Pilot pilot = new Pilot();
        pilot.batchMove(commands.lines());
        assertEquals(new Position(15,10), pilot.position());
    }

}
