package io.codeforall.bootcamp.view;

import io.codeforall.bootcamp.model.Food;
import io.codeforall.bootcamp.model.GameState;
import io.codeforall.bootcamp.model.SnakeSegment;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private final GameState gameState;
    private final int cellSize = 20;

    public GameView(GameState gameState) {
        this.gameState = gameState;

        setPreferredSize(new Dimension(GameState.WIDTH * cellSize, GameState.HEIGHT * cellSize));
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawSnake(g);
        drawFood(g);
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.DARK_GRAY);

        for (int x = 0; x <= GameState.WIDTH; x++) {
            g.drawLine(x * cellSize, 0, x * cellSize, GameState.HEIGHT * cellSize);
        }

        for (int y = 0; y <= GameState.HEIGHT; y++) {
            g.drawLine(0, y * cellSize, GameState.WIDTH * cellSize, y * cellSize);
        }
    }

    private void drawSnake(Graphics g) {
        g.setColor(Color.GREEN);

        for (SnakeSegment segment : gameState.getSnake().getSegments()) {
            g.fillRect(segment.getX() * cellSize, segment.getY() * cellSize, cellSize, cellSize);
        }
    }

    private void drawFood(Graphics g) {
        g.setColor(Color.RED);
        Food food = gameState.getFood();
        g.fillOval(food.getX() * cellSize, food.getY() * cellSize, cellSize, cellSize);
    }
}
