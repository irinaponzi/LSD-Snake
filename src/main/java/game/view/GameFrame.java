package game.view;

import game.play.Menu;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.add(Menu.getInstance());
        this.setTitle("LSD Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
