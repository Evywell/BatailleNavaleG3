package model.game;

import controller.BattleField;
import controller.Game;

public class Party implements Runnable {

    private Player playerOne;
    private Player playerTwo;
    private Timer timer;
    private Player currentPlayer;
    private boolean over;

    private BattleField controller;

    public Party(Player playerOne, Player playerTwo, int difficulte, BattleField controller) {
        this.over = false;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.timer = new Timer(difficulte, this);
        this.timer.start();
        this.controller = controller;
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

    public synchronized void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public synchronized Player getCurrentPlayer () { return this.currentPlayer; }

    public synchronized void gameOver() {
        this.over = true;
    }

    public synchronized void updateTimer(int time) {
        this.controller.updateTimer(time);
    }

    @Override
    public void run() {
        while (!this.over) {
            // C'est au tour de l'ordinateur
            if (this.getCurrentPlayer() instanceof ComputerPlayer) {
                System.out.println("L'ordinateur joue");
                ((ComputerPlayer) this.getCurrentPlayer()).choixOrdinateur();
                this.setCurrentPlayer(this.getNextPlayer());
            }
        }
        this.controller.gameOver();
    }
}
