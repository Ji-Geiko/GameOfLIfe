package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class BoutonStart extends JButton implements MouseListener {
    private String name;
    private Image img;

    public BoutonStart(String str) {
        super(str);
        this.name = str;

        // Grâce à cette instruction, notre objet va s'écouter
        // Dès qu'un événement de la souris sera intercepté, il en sera averti
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.setColor(Color.black);
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 / 4), (this.getHeight() / 2) + 5);
    }

    // Méthode appelée lors du clic de souris
    public void mouseClicked(MouseEvent event) {
        System.out.println("clique");
    }

    // Méthode appelée lors du survol de la souris
    public void mouseEntered(MouseEvent event) {
        System.out.println("mouseEntered");

    }

    // Méthode appelée lorsque la souris sort de la zone du bouton
    public void mouseExited(MouseEvent event) {
        System.out.println("mouseExited");

    }

    // Méthode appelée lorsque l'on presse le bouton gauche de la souris
    public void mousePressed(MouseEvent event) {
        System.out.println("mousePressed");

    }

    // Méthode appelée lorsque l'on relâche le clic de souris
    public void mouseReleased(MouseEvent event) {
        System.out.println("mouseReleased");

    }

}