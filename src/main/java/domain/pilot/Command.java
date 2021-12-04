package domain.pilot;

import domain.pilot.Direction;

public record Command(Direction direction, int distance) {
}
