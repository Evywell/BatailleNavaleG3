package model.game.ship;

import controller.Game;
import model.game.Player;
import view.textures.Texture;

import java.util.ArrayList;
import java.util.Arrays;

public class BigShip extends Ship {

    public BigShip(Player player) {
        super(player, 3, 1);
        this.pieces = new ArrayList<>(Arrays.asList(new ShipPiece[]{
                new ShipPiece(0, 0, new Texture(Game.ASSETS_PATH + "/texture.jpg"), this),
                new ShipPiece(1, 0, new Texture(Game.ASSETS_PATH + "/texture.jpg"), this),
                new ShipPiece(2, 0, new Texture(Game.ASSETS_PATH + "/texture.jpg"), this)
        }));
    }

}
