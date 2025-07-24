package io.codeforall.bootcamp.controller;

import io.codeforall.bootcamp.model.Direction;
import io.codeforall.bootcamp.model.GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GameController extends KeyAdapter {

    private final GameState gameState;
    private final Queue<GameCommand> commandQueue = new LinkedList<>();

    private static final Map<Integer, Direction> keyToDirection = Map.of(
            KeyEvent.VK_W, Direction.UP,
            KeyEvent.VK_S, Direction.DOWN,
            KeyEvent.VK_A, Direction.LEFT,
            KeyEvent.VK_D, Direction.RIGHT,
            KeyEvent.VK_UP, Direction.UP,
            KeyEvent.VK_DOWN, Direction.DOWN,
            KeyEvent.VK_LEFT, Direction.LEFT,
            KeyEvent.VK_RIGHT, Direction.RIGHT
    );

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Direction dir = keyToDirection.get(e.getKeyCode());

        if(dir != null) {
            commandQueue.offer(new ChangeDirectionCommand(gameState.getSnake(), dir));
        }
    }

    public void update() {
        while(!commandQueue.isEmpty()) {
            commandQueue.poll().execute();
        }

        gameState.update();
    }
}
