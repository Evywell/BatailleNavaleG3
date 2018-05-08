package model.game;

import controller.Game;

public class Party {

    private Player playerOne;
    private Player playerTwo;
    private Timer timer;
    private Player currentPlayer;
    private boolean over;

    public Party(Player playerOne, Player playerTwo, int difficulte) {
        this.over = false;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.timer = new Timer(difficulte);
        this.timer.start();
        this.setCurrentPlayer(playerOne);
        if (difficulte == Game.DIFFICULTE_FACILE) {
            this.playerOne.createField(Game.WIDTH_FIELD_FACILE, Game.HEIGHT_FIELD_FACILE);
            this.playerTwo.createField(Game.WIDTH_FIELD_FACILE, Game.HEIGHT_FIELD_FACILE);
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            this.playerOne.createField(Game.WIDTH_FIELD_NORMALE, Game.HEIGHT_FIELD_NORMALE);
            this.playerTwo.createField(Game.WIDTH_FIELD_NORMALE, Game.HEIGHT_FIELD_NORMALE);
        } else if (difficulte == Game.DIFFICULTE_DIFFICILE) {
            this.playerOne.createField(Game.WIDTH_FIELD_DIFFICILE, Game.HEIGHT_FIELD_DIFFICILE);
            this.playerTwo.createField(Game.WIDTH_FIELD_DIFFICILE, Game.HEIGHT_FIELD_DIFFICILE);
        }
    }

    public Player getNextPlayer() {
        return this.currentPlayer.getOpponent();
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer () { return this.currentPlayer; }

    public void gameOver() {
        this.over = true;
    }

}
