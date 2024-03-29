package game.keyAdapter;

import game.play.GamePlay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayKeyAdapter extends KeyAdapter {

    GamePlay gamePlay;
    public PlayKeyAdapter(GamePlay gamePlay) {
        this.gamePlay = gamePlay;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gamePlay.handleKeyPress(e.getKeyCode());
    }
}
