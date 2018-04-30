package model.game;

import controller.Game;
import view.textures.Texture;

import java.util.List;

public class Field {

    private int width, height;
    private Piece[][] boardPieces;

    public Field(int width, int height) {
        this.boardPieces = new Piece[width][height];
        this.width = width;
        this.height = height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Texture texture = new Texture(Game.ASSETS_PATH + "/water.png");
                this.boardPieces[x][y] = new WaterPiece(x, y, texture, null);
            }
        }
    }

    public Piece hit(int x, int y) {
        return this.boardPieces[x][y];
    }

    public void build(int x, int y, Piece piece) {
        if (this.canBuildOnIt(x, y))
            this.boardPieces[x][y] = piece;
    }

    public Piece[][] getPieces() {
        return this.boardPieces;
    }

    private boolean canBuildOnIt(int x, int y) {
        return (x >= 0 && x < this.width) &&  (y >= 0 && y < this.height);
    }

}
