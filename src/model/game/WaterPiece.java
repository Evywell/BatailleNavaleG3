package model.game;

public class WaterPiece extends FieldPiece {

    public WaterPiece(int x, int y, Ship parent) {
        super(x, y, parent);
    }

    @Override
    public Ship getParent() {
        return null;
    }

    @Override
    public void handler() {

    }
}
