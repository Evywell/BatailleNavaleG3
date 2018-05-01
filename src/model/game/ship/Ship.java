package model.game.ship;

import model.game.Field;
import model.game.Piece;
import model.game.Player;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String id;
    private Player player;
    private int width, height;
    private boolean destroyed;

    protected List<Piece> pieces;

    public Ship(Player player, int width, int height) {
        this.player = player;
        this.width = width;
        this.height = height;
        this.id = this.player.getPseudo() + "#" + this.width + "x" + this.height;
        this.destroyed = false;
        this.pieces = new ArrayList<>();
    }

    public void move() {}

    public void build(int x, int y) {
        Field field = this.player.getField();
        this.pieces.forEach(piece -> {
            field.build(x + piece.getX(), y + piece.getY(), piece);
        });
    }

    public int getWidth () {
        return this.width;
    }

    public int getHeight () {
        return this.height;
    }

    public List<Piece> getPieces () {
        return this.pieces;
    }

}
