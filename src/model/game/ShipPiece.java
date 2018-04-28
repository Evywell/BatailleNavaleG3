package model.game;

public class ShipPiece extends FieldPiece {

    public ShipPiece(int x, int y, Ship parent) {
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
