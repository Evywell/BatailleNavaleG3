package view;

import model.game.ComputerPlayer;
import model.game.Field;
import model.game.Piece;
import view.textures.Texture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleField extends Window {

    private int width;
    private int height;
    private Field playerField;
    private Field computerField;
    private controller.BattleField controller;

    /**
     * Créer un champ de bataille
     * @param width le nombre de case en longueur
     * @param height le nombre de case en hauteur
     */
    public BattleField(int width, int height, Field playerField, Field computerField, controller.BattleField controller) {
        super("BattleField");
        this.width = width;
        this.height = height;
        this.playerField = playerField;
        this.computerField = computerField;
        this.controller = controller;
        this.drawFields();
    }

    private void drawPlayerField(JPanel panel) {
        Piece[][] board = this.playerField.getPieces();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Texture texture = board[x][y].getTexture();
                panel.add(texture);
            }
        }
    }

    private void drawComputerField(JPanel panel) {
        Piece[][] board = this.computerField.getPieces();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Texture texture = board[x][y].getTexture();
                Piece p = board[x][y];
                panel.add(texture);
                texture.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        controller.hit(p);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
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
