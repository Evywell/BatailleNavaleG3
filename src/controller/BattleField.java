package controller;

import model.game.*;
import model.game.ship.Ship;
import view.GameOver;
import view.Window;

public class BattleField {

    private Party party;
    private Player player, computer;
    private int difficulte;

    private view.BattleField view;

    public BattleField (Player player, Player computer, int difficulte) {
        System.out.println("DIFFICULTE " + difficulte);
        this.player = player;
        this.computer = computer;
        this.difficulte = difficulte;
        int width = this.getWidth(this.difficulte);
        int height = this.getHeight(this.difficulte);

        this.party = new Party(this.player, this.computer, this.difficulte, this);
        this.view = new view.BattleField(width, height, this.player.getField(), this.computer.getField(), this);
        this.view.showWindow();
        // On démarre la partie
        (new Thread(this.party)).start();
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
        // On passe au joueur suivant
        this.party.setCurrentPlayer(player.getOpponent());
    }

    public void gameOver() {
        // On enregistre les stats

        // On charge le gameover
        Window gameover = new GameOver();
        gameover.showWindow();

        this.view.dispose();
    }

    public Party getParty() {
        return party;
    }

    public synchronized void updateTimer(int time) {
        if (this.view != null) {
            this.view.updateTimer(time);
        }
    }


    private int getWidth (int difficulte) {
        if (difficulte == Game.DIFFICULTE_FACILE) {
            return Game.WIDTH_FIELD_FACILE;
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            return Game.WIDTH_FIELD_NORMALE;
        } else if (difficulte == Game.DIFFICULTE_DIFFICILE) {
            return Game.WIDTH_FIELD_DIFFICILE;
        }

        return Game.WIDTH_FIELD_FACILE;
    }

    private int getHeight (int difficulte) {
        if (difficulte == Game.DIFFICULTE_FACILE) {
            return Game.HEIGHT_FIELD_FACILE;
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            return Game.HEIGHT_FIELD_NORMALE;
        } else if (difficulte == Game.DIFFICULTE_DIFFICILE) {
            return Game.HEIGHT_FIELD_DIFFICILE;
        }

        return Game.HEIGHT_FIELD_FACILE;
    }
}
