package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Menu extends JPanel implements ActionListener, IWindow {

    Timer timer;
    Random random;
    Music music;

    Menu() {
        random = new Random();
        music = new Music("menuMusic.wav");
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        startMenu();
    }

    public void startMenu() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {

        g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
        g.setFont(new Font("Courier New", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Snake", (SCREEN_WIDTH - metrics.stringWidth("Snake")) / 2, g.getFont().getSize());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
