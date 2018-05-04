package view;

import controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameOver extends Window {

    public GameOver() {
        super("Game Over");

        this.setLayout(new BorderLayout());
        JPanel gameOver = new JPanel();
        JPanel imageFond = new GameOverPanel();

        gameOver.setLayout(new BorderLayout());
        gameOver.setPreferredSize(new Dimension(90, 90));

        JButton buttonRetour = new JButton("Retour au Menu Principal");
        buttonRetour.setPreferredSize(new Dimension(30, 30));
        gameOver.add(buttonRetour, BorderLayout.CENTER);

        this.getContentPane().add(imageFond);
        this.getContentPane().add(gameOver,BorderLayout.SOUTH);

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

