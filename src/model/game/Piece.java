package model.game;

import view.textures.Texture;

public interface Piece {

    public Ship getParent();
    public void handler();
    public Texture getTexture();
    public int getX();
    public int getY();

}
