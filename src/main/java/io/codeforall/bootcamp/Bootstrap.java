package io.codeforall.bootcamp;

import io.codeforall.bootcamp.controller.GameController;
import io.codeforall.bootcamp.model.GameState;
import io.codeforall.bootcamp.view.GameView;

import javax.swing.*;
import java.awt.*;

public class Bootstrap {

    private static final int FPS = 10;

    public static void main(String[] args) {
        GameState gameState = new GameState();
        GameController controller = new GameController(gameState);
        GameView gameView = new GameView(gameState);
        gameView.addKeyListener(controller);

        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameView);
        frame.pack();
        frame.setVisible(true);

        new Timer(1000 / FPS, e -> {
            controller.update();
            gameView.repaint();

            if (gameState.isGameOver()) {
                JOptionPane.showMessageDialog(frame, "Game Over!");
                System.exit(0);
            }
        }).start();
    }
}
