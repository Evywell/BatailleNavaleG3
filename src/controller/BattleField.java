package controller;

import model.game.BonusPiece;
import model.game.Piece;
import model.game.Player;
import model.game.WaterPiece;
import model.game.ship.Ship;

public class BattleField {

    private int difficulte;
    private Player player, computer;

    public BattleField (int difficulte, Player player, Player computer) {
        this.difficulte = difficulte;
        this.player = player;
        this.computer = computer;
    }

    public void hit (Piece piece) {
        // plouf
        if (piece instanceof WaterPiece) {
            System.out.println("PLOUF !");
        // Bonus ?
        } else if (piece instanceof BonusPiece) {
            System.out.println("BONUS !");
        } else {
            // C'est un bateau
            Ship parent = piece.getParent();
            System.out.println("Bateau touché: " + parent.getId());
        }
    }

    public void test () {
        System.out.println("TEST");
    }

}
