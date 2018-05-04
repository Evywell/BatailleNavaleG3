package view;

import controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Stats extends Window {

    public Stats() {
        super("Stats");

        String newLine = System.getProperty("line.separator");

        this.setLayout(new BorderLayout());
        JPanel Stats = new JPanel();

        Stats.setLayout(new BorderLayout());
        Stats.setPreferredSize(new Dimension(90, 90));

        JButton buttonRetour = new JButton("Retour au Menu Principal");
        buttonRetour.setPreferredSize(new Dimension(30, 30));
        Stats.add(buttonRetour, BorderLayout.CENTER);
        this.setLayout(new GridLayout(2,3));



        this.getContentPane().add(new JLabel("Nombre de parties jouées"));
        this.getContentPane().add(new JLabel("34"));
        this.getContentPane().add(new JLabel("Pourcentage de parties gagnées"));
        this.getContentPane().add(new JLabel("31%"));
        this.getContentPane().add(new JLabel("Top 10 des scores"));
        this.getContentPane().add(new JLabel("Jeremy 321 points"));

        this.getContentPane().add(Stats,BorderLayout.SOUTH);
        Stats.add(buttonRetour);

    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());

        try {
            Image image = ImageIO.read(new File(Game.ASSETS_PATH+"/gameOver.png"));
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

