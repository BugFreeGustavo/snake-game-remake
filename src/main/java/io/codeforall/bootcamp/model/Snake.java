package io.codeforall.bootcamp.model;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final LinkedList<SnakeSegment> segments = new LinkedList<>();
    private Direction currentDirection = Direction.RIGHT;
    private boolean growOnNextMove = false;

    public Snake(int startX, int startY) {
        segments.add(new SnakeSegment(startX, startY));
    }

    public void setDirection(Direction newDirection) {
        if(!newDirection.isOpposite(currentDirection)) {
            currentDirection = newDirection;
        }
    }

    public void move() {
        SnakeSegment head = getHead();
        SnakeSegment newHead = new SnakeSegment(
                head.getX() + currentDirection.dx,
                head.getY() + currentDirection.dy
        );
        segments.addFirst(newHead);

        if(!growOnNextMove) {
            segments.removeLast();

        } else {
            growOnNextMove = false;
        }
    }

    public void grow() {
        growOnNextMove = true;
    }

    public SnakeSegment getHead() {
        return segments.getFirst();
    }

    public List<SnakeSegment> getSegments() {
        return List.copyOf(segments);
    }

    public boolean checkSelfCollition() {
        SnakeSegment head = getHead();
        return segments.stream().skip(1).anyMatch(seg -> seg.equals(head));
    }
}
