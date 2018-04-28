package model.game;

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
                this.boardPieces[x][y] = new WaterPiece(x, y, null);
            }
        }
    }

    public Piece hit(int x, int y) {
        return new WaterPiece(x, y, null);
    }

    public void build(int x, int y, Piece piece) {
        if (this.canBuildOnIt(x, y))
            this.boardPieces[x][y] = piece;
    }

    private boolean canBuildOnIt(int x, int y) {
        return (x >= 0 && x < this.width) &&  (y >= 0 && y < this.height);
    }

}
