package model.game;

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
    }

    public Player getNextPlayer() {
        return this.currentPlayer.getOpponent();
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public void gameOver() {
        this.over = true;
    }

}
