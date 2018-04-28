package view;

import model.game.ComputerPlayer;

import javax.swing.*;
import java.awt.*;

public class BattleField extends Window {

    private int width;
    private int height;

    /**
     * Créer un champ de bataille
     * @param width le nombre de case en longueur
     * @param height le nombre de case en hauteur
     */
    public BattleField(int width, int height) {
        super("BattleField");
        this.width = width;
        this.height = height;
        this.drawFields();
    }

    private void drawPlayerField(JPanel panel) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Ajout du quadrillage
            }
        }
    }

    private void drawComputerField(JPanel panel) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Ajout du quadrillage
            }
        }
    }

    private void drawFields() {
        this.setLayout(new GridLayout(1, 2));
        JPanel playerPan = new JPanel();
        JPanel computerPan = new JPanel();
        playerPan.setBackground(Color.BLUE);
        computerPan.setBackground(Color.YELLOW);
        this.getContentPane().add(playerPan);
        this.getContentPane().add(computerPan);
        this.drawPlayerField(playerPan);
        this.drawComputerField(computerPan);
    }

}
