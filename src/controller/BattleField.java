package controller;

import model.game.*;
import model.game.ship.Ship;

public class BattleField {

    private Party party;

    public BattleField (Party party) {
        this.party = party;

    }

    public void hit (int x, int y) {
        // On touche la pièce du joueur adverse
        Player player = this.party.getCurrentPlayer();
        Piece piece = player.hit(x, y);
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

}
