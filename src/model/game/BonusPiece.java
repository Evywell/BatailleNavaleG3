package model.game;

public class BonusPiece extends FieldPiece {

    public BonusPiece(int x, int y, Ship parent) {
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
