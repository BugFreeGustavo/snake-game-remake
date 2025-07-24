package io.codeforall.bootcamp.model;

import io.codeforall.bootcamp.service.CollisionService;

public class GameState {

    private final Snake snake;
    private Food food;
    private boolean gameOver = false;
    private final CollisionService collisionService;

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;

    public GameState() {
        this.snake = new Snake(WIDTH / 2, HEIGHT / 2);
        this.collisionService = new CollisionService(this);
        spawnFood();
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void update() {
        if(gameOver) return;

        snake.move();
        SnakeSegment head = snake.getHead();

        if(collisionService.checkWallCollision() || collisionService.checkSelfCollision()) {
            gameOver = true;
            return;
        }

        if(collisionService.checkFoodCollision()) {
            snake.grow();
            spawnFood();
        }
    }

    private void spawnFood() {
        int x = (int) (Math.random() * WIDTH);
        int y = (int) (Math.random() * HEIGHT);
        food = new Food(x,y);
    }
}
