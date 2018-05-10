package model.game;

import model.game.ship.BigShip;
import model.game.ship.Ship;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected String pseudo;
    protected List<Ship> ships;
    protected Field field;
    protected Player opponent;

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.ships = new ArrayList<>();
        this.initializeShips();
    }

    public Piece hit(int x, int y) {
        return this.opponent.getField().hit(x, y);
    }

    public void createField (int width, int height) {
        // On créer le champs de bataille avec de l'eau
        this.field = new Field(width, height);
        this.ships.forEach(ship -> {
            this.field.randomBuild(ship);
        });
    }

    public Player getOpponent() {
        return this.opponent;
    }

    public void setOpponent(Player opponent) { this.opponent = opponent; }

    public Field getOpponentField() {
        return this.opponent.getField();
    }

    public Field getField() {
        return this.field;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public abstract void initializeShips();

}
