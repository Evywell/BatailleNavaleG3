package model.game;

import model.game.ship.BigShip;
import model.game.ship.HiddenShip;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String pseudo) {
        super(pseudo);
    }

    @Override
    public void initializeShips() {
        this.ships.add(new HiddenShip(this));
        this.ships.add(new HiddenShip(this));
        this.ships.add(new HiddenShip(this));
    }

    public void choixOrdinateur() {
    }

}
