package model.game;

import view.textures.Texture;

public class BonusPiece extends FieldPiece {

    public BonusPiece(int x, int y, Texture texture, Ship parent) {
        super(x, y, texture, parent);
    }

    @Override
    public Ship getParent() {
        return null;
    }

    @Override
    public void handler() {

    }
}
