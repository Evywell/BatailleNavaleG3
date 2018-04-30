package model.game;

import view.textures.Texture;

public abstract class FieldPiece implements Piece {

    protected int x;
    protected int y;
    protected Ship parent;
    protected boolean hit;
    protected Texture texture;

    public FieldPiece(int x, int y, Texture texture, Ship parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.hit = false;
        this.texture = texture;
    }

    public Texture getTexture() {
        return this.texture;
    }

}
