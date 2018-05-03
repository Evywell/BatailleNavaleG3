package model.game;

import model.game.ship.BigShip;
import model.game.ship.Ship;
import model.stats.Score;

public class HumanPlayer extends Player {

    private Score score;

    public HumanPlayer(String pseudo) {
        super(pseudo);
        this.score = new Score();
    }

    @Override
    public void initializeShips() {
        this.ships.add(new BigShip(this, Ship.HORIZONTALE));
        this.ships.add(new BigShip(this, Ship.VERTICALE));
        this.ships.add(new BigShip(this, Ship.HORIZONTALE));
    }

}
