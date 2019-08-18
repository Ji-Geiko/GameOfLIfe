package ui;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.*;


public class StartInterface extends JFrame{
    private MyCanvas canvas = new MyCanvas();

    private JPanel pan = new JPanel();
    JButton bouton2 = new JButton("start");
    private int width;
    private int height;
    private Boolean startPressed=false;

    public StartInterface(int w, int h){
        width=w;
        height=h;
        this.setTitle("jeu de la vie : séléction");
        this.setSize(w, h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //Ajout du bouton
        pan.add(bouton2);
        this.setContentPane(pan);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) { 
        //code that reacts to the action... 
        startPressed=true;
    }
    
    public boolean getStartPressed(){
        return this.startPressed;
    }

    public class MyCanvas extends Canvas{
        @Override
            public void paint(Graphics g) {
                super.paint(g);
            }
    }
}