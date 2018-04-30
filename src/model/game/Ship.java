package model.game;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String id;
    private Player player;
    private List<Piece> pieces;
    private int width, height;
    private boolean destroyed;

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
