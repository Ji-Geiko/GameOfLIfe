package ui;
import javax.swing.*;
import javax.swing.plaf.*;

import cellule.*;

import java.awt.*;

/**
 * UI
 */
public class UI extends JFrame{
    private MyCanvas canvas;
    private static Graphics g;

    CelluleManager manager;

    private TabbedPaneUI TabbePane;

    private int width;
    private int height;
    private JPanel pan = new JPanel();

    public UI(int w, int h){
        this.width = w;
        this.height = h;

/*
        setLayout(new BorderLayout());
        setSize(w, h);
        setTitle("jeu de la vie");
        pan.add("Center",canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Ajout du bouton
                pan.add(bouton2);
                this.setContentPane(pan);

        canvas.setBackground(Color.black);
        */
        manager = new CelluleManager(this,30,30);

        TabbePane.
        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.PAGE_AXIS));

        canvas = new MyCanvas();
        mainContainer.add(canvas);

        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        mainContainer.add(startButton);

        this.setContentPane(mainContainer);
        this.setSize(w, h);
        this.setTitle("jeu de la vie");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //place la fenètre au centre de l'écrant
        this.setLocationRelativeTo(null);

        //fenetre visible
        this.setVisible(true);
    }

    public Graphics getGraphics(){
        return canvas.getGraphics();
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public class MyCanvas extends Canvas{
        @Override
            public void paint (Graphics g){
                /*g.drawString("------------------", 100, 50);
                g.drawString("life Cicle:"+LifeCycle, 100, 60);
                g.drawString("------------------", 100, 70);*/
                //je fais une boucle
                    //ici je dois printer le state de la cellule			



                /*g.drawString("ceci est un test", 10, 20);
                g.drawOval(50, 50, 101, 24);
                g.drawRect(100, 100, 50, 60);
                g.setColor(Color.BLACK);
                g.fillOval(75, 75, 50, 50);
                g.fillRect(200, 111, 90, 90);
                g.setColor(Color.PINK);
                g.setFont(new Font("Arial Black",Font.BOLD, 30));
                g.drawString("c'est fini", 10, 250);*/
           }
    }
}