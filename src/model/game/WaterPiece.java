package model.game;

import model.game.ship.Ship;
import view.textures.Texture;

public class WaterPiece extends FieldPiece {

    public WaterPiece(int x, int y, Texture texture, Ship parent) {
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
