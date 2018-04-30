package view;

import model.game.ComputerPlayer;
import model.game.Piece;
import view.textures.Texture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleField extends Window {

    private int width;
    private int height;
    private Piece[][] playerField;
    private Piece[][] computerField;

    /**
     * Créer un champ de bataille
     * @param width le nombre de case en longueur
     * @param height le nombre de case en hauteur
     */
    public BattleField(int width, int height, Piece[][] playerField, Piece[][] computerField) {
        super("BattleField");
        this.width = width;
        this.height = height;
        this.playerField = playerField;
        this.computerField = computerField;
        this.drawFields();
    }

    private void drawPlayerField(JPanel panel) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Texture texture = this.playerField[x][y].getTexture();
                panel.add(texture);
            }
        }
    }

    private void drawComputerField(JPanel panel) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Texture texture = this.computerField[x][y].getTexture();
                panel.add(texture);
            }
        }
    }

    private void drawFields() {
        this.setLayout(new GridLayout(1, 2));
        JPanel playerPan = new JPanel();
        JPanel computerPan = new JPanel();
        playerPan.setLayout(new GridLayout(this.height, this.width));
        computerPan.setLayout(new GridLayout(this.height, this.width));
        playerPan.setBackground(Color.BLUE);
        computerPan.setBackground(Color.YELLOW);
        this.getContentPane().add(playerPan);
        this.getContentPane().add(computerPan);
        this.drawPlayerField(playerPan);
        this.drawComputerField(computerPan);
    }

}
