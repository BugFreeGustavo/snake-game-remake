package io.codeforall.bootcamp.model;

public class SnakeSegment {

    private final int x;
    private final int y;

    public SnakeSegment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SnakeSegment)) {
            return false;
        }

        SnakeSegment other = (SnakeSegment) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
       return 31 * x + y;
    }
}
