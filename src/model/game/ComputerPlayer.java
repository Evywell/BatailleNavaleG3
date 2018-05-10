package model.game;

import model.game.ship.BigShip;
import model.game.ship.HiddenShip;

import java.util.concurrent.ThreadLocalRandom;

import static controller.Game.HEIGHT_FIELD_FACILE;
import static controller.Game.WIDTH_FIELD_FACILE;

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

    public void choixOrdinateur(int difficulte) {

        int width = 10*difficulte;
        int height = 10*difficulte;

        int x = ThreadLocalRandom.current().nextInt(0, width);
        int y = ThreadLocalRandom.current().nextInt(0, height);

        hit(x, y);
    }

}
