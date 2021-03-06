package view;

import controller.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenu extends Window {

    private controller.MainMenu controller;

    public MainMenu() {
        super("Menu");

        this.controller = new controller.MainMenu(this);

        this.setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        JPanel imageFond = new ImagePanel();

        menu.setLayout(new BorderLayout());
        menu.setPreferredSize(new Dimension(90,90));

        JButton buttonJouer = new JButton("Jouer");
        JButton buttonScore = new JButton("Mes scores");
        JButton buttonQuitter = new JButton("Quitter");

        buttonJouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.launchGameView();
            }
        });

        buttonScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.launchStatsView();
            }
        });

        buttonQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.quitGame();
            }
        });

        buttonJouer.setPreferredSize(new Dimension(30,30));
        buttonScore.setPreferredSize(new Dimension(30,30));
        buttonQuitter.setPreferredSize(new Dimension(30,30));
        menu.add(buttonJouer, BorderLayout.NORTH);
        menu.add(buttonScore, BorderLayout.CENTER);
        menu.add(buttonQuitter, BorderLayout.SOUTH);

        //this.setContentPane(imageFond);
        this.getContentPane().add(imageFond);
        this.getContentPane().add(menu, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());

        try {
            Image image = ImageIO.read(new File(Game.ASSETS_PATH+"/fond2.png"));
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
