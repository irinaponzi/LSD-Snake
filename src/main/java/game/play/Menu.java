package game.play;

import game.keyAdapter.MenuKeyAdapter;
import game.music.Music;
import game.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu extends GamePanel implements ActionListener {

    static Menu instance;
    MenuKeyAdapter menuKeyAdapter;
    boolean paused = false;
    final char[] SNAKE_TEXT = {'L', 'S', 'D'};
    Color[] colors;
    int x;
    int y;

    public static Menu getInstance() {
        if(instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    private Menu() {
        super();
        menuKeyAdapter = new MenuKeyAdapter(this);
        music = new Music("menuSong.wav");
        startMenu();
    }

    public void startMenu() {
        this.addKeyListener(menuKeyAdapter);
        colors = new Color[SNAKE_TEXT.length];
        for(int i = 0; i < SNAKE_TEXT.length; i++) {
            colors[i] = new Color(0,0,0);
        }
        timer = new Timer(20, this);
        timer.start();
    }

    public void closeMenu() {
        setVisible(false);
        pause();
        this.removeKeyListener(menuKeyAdapter);
        requestFocusInWindow(false);
        setFocusable(false);
        music.stopMusic();
    }

    public void pause() {
        paused = true;
    }

    public void resume() {
        paused = false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // LAS POSICIONES ESTÁN HARCODEADAS, CAMBIAR
    public void draw(Graphics g) {

        // Escribe Snake
        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.BOLD, 120));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Snake", (SCREEN_WIDTH - metrics.stringWidth("Snake")) / 2, 170);

        // Escribe LSD
        x = (SCREEN_WIDTH - metrics.stringWidth("LSD")) / 2;
        y = 230;
        for (int i = 0; i < 3; i++) {
            g.setColor(colors[i]);
            g.setFont(new Font("Courier New", Font.PLAIN, 80));
            g.drawString(String.valueOf(SNAKE_TEXT[i]), x, y);
            x += metrics.charWidth(SNAKE_TEXT[i]);
        }

        // Escribe las opciones del menu
        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.PLAIN, 25));
        g.drawString("START [PRESS ENTER]", 135, 370);
        g.drawString("OPTIONS [PRESS X]", 135, 410);
        g.drawString("STATS [PRESS Z]", 135, 450);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!paused) {
            for(int i = 0; i < SNAKE_TEXT.length; i++) {
                colors[i] = new Color(
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255),
                        (int) (Math.random() * 255)
                );
            }
            repaint();
        }
    }

    public void startGame() {
        closeMenu();
        getParent().add(new GamePlay());
    }

    public void showStats() {
    }

    public void showOptions() {

    }
}