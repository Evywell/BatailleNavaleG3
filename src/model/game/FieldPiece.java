package model.game;

public abstract class FieldPiece implements Piece {

    protected int x;
    protected int y;
    protected Ship parent;
    protected boolean hit;

    public FieldPiece(int x, int y, Ship parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.hit = false;
    }

}
