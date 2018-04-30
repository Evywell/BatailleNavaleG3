package model.game;

import view.textures.Texture;

public class ShipPiece extends FieldPiece {

    public ShipPiece(int x, int y, Texture texture, Ship parent) {
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
