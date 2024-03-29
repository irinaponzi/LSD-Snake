package game.view;

import game.music.Music;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    protected static final int SCREEN_WIDTH = 600;
    protected static final int SCREEN_HEIGHT = 600;
    protected static final int UNIT_SIZE = 25;
    protected static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    protected static final int DELAY = 95;
    protected final int[] x = new int[GAME_UNITS];
    protected final int[] y = new int[GAME_UNITS];
    protected Random random;
    protected Timer timer;
    protected Music music;


    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
    }

}
