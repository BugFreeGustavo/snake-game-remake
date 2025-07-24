package io.codeforall.bootcamp.service;

import io.codeforall.bootcamp.model.Food;
import io.codeforall.bootcamp.model.GameState;
import io.codeforall.bootcamp.model.SnakeSegment;

public class CollisionService {

    private final GameState gameState;

    public CollisionService(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean checkWallCollision() {
        SnakeSegment head = gameState.getSnake().getHead();

        return head.getX() < 0 ||
                head.getY() < 0 ||
                head.getX() >= GameState.WIDTH ||
                head.getY() >= GameState.HEIGHT;
    }

    public boolean checkSelfCollision() {
        return gameState.getSnake().checkSelfCollition();
    }

    public boolean checkFoodCollision() {
        SnakeSegment head = gameState.getSnake().getHead();
        Food food = gameState.getFood();

        return head.getX() == food.getX() && head.getY() == food.getY();
    }
}
