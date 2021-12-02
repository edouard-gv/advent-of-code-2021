package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilotTest {
    @Test
    public void initialPosition() {
        Pilot pilot = new Pilot();
        assertEquals(new Position(0, 0), pilot.position());
    }
}
