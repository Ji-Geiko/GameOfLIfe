package ui;

import javax.swing.*;

import cellule.*;

import java.awt.*;

/**
 * UI
 */
public class UI extends JFrame {
    private MyCanvas canvas;
    private static Graphics g;

    CelluleManager manager;

    private int width;
    private int height;
    private JPanel pan = new JPanel();

    public UI(int w, int h) {
        this.width = w;
        this.height = h;

        this.setTitle("jeu de la vie");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.getContentPane().add(new BoutonStart("start"));
        this.setVisible(true);
    }

    /*public Graphics getGraphics() {
        return canvas.getGraphics();
    }*/

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public class MyCanvas extends Canvas{   }
}