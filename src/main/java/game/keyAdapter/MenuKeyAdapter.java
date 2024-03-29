package game.keyAdapter;

import game.play.Menu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuKeyAdapter extends KeyAdapter {
    Menu menu;
    public MenuKeyAdapter(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                menu.startGame();
                break;
            case KeyEvent.VK_X:
                menu.showStats();
                break;
            case KeyEvent.VK_Z:
                menu.showOptions();
                break;
        }
    }
}






