package io.codeforall.bootcamp.controller;

import io.codeforall.bootcamp.model.Direction;
import io.codeforall.bootcamp.model.Snake;

public class ChangeDirectionCommand implements GameCommand{

    private final Snake snake;
    private final Direction newDirection;

    public ChangeDirectionCommand(Snake snake, Direction newDirection) {
        this.snake = snake;
        this.newDirection = newDirection;
    }

    @Override
    public void execute() {
        snake.setDirection(newDirection);
    }
}
