package model.game;

import model.stats.Score;

public class HumanPlayer extends Player {

    private Score score;

    public HumanPlayer(String pseudo) {
        super(pseudo);
        this.score = new Score();
    }

}
