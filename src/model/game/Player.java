package model.game;

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

        });
    }

    public Player getOpponent() {
        return this.opponent;
    }

    public Field getOpponentField() {
        return this.opponent.getField();
    }

    public Field getField() {
        return this.field;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    private void initializeShips() {
        // Bateau 2x1
        Ship shipOne = new Ship(this, 2, 1);
        // Bateau 3x1
        Ship shipTwo = new Ship(this, 3, 1);
        // Bateau 2x2
        Ship shipThree = new Ship(this, 2, 2);
        // Bateau 2x3
        Ship shipFour = new Ship(this, 2, 3);
        // Bateau 4x2
        Ship shipFive = new Ship(this, 4, 2);

        this.ships.add(shipOne);
        this.ships.add(shipTwo);
        this.ships.add(shipThree);
        this.ships.add(shipFour);
        this.ships.add(shipFive);
    }

}
