package model.game;

import controller.Game;
import model.game.ship.Ship;
import view.textures.Texture;

import java.util.concurrent.ThreadLocalRandom;

public class Field {

    private int width, height;
    private Piece[][] boardPieces;

    public Field(int width, int height) {
        this.boardPieces = new Piece[width][height];
        this.width = width;
        this.height = height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // On initialise le plateau de jeu avec des cases d'eau
                Texture texture = new Texture(Game.ASSETS_PATH + "/water.png");
                this.boardPieces[x][y] = new WaterPiece(x, y, texture, null);
            }
        }
    }

    /**
     * Récupère la pièce touchée avec ces coordonnées
     * @param x int
     * @param y int
     * @return Piece La Pièce touchée
     */
    public Piece hit(int x, int y) {
        return this.boardPieces[x][y];
    }

    public void build(int x, int y, Piece piece) {
        if (this.canBuildOnIt(x, y))
            this.boardPieces[x][y] = piece;
    }

    public boolean build(int x, int y, Ship ship) {
        int width = ship.getWidth();
        int height = ship.getHeight();
        if (this.canBuildShipOnIt(x, y, width, height)) {
            ship.getPieces().forEach(piece -> {
                this.boardPieces[x + piece.getX()][y + piece.getY()] = piece;
            });
            System.out.println("Bateau construit en x:" + x + " y:" + y);
            return true;
        }
        return false;
    }

    public void randomBuild(Ship ship) {
        // On choisit des positions randoms
        int x = this.getRandomPosition(this.width);
        int y = this.getRandomPosition(this.height);
        if (!this.build(x, y, ship)) {
            // Si on ne peut pas le construire à la position souhaitée, on recommence la manoeuvre
            this.randomBuild(ship);
        }
    }

    public Piece[][] getPieces() {
        return this.boardPieces;
    }

    private boolean canBuildOnIt(int x, int y) {
        if (x >= this.width || y >= this.height || x < 0 || y < 0) {
            return false;
        }

        Piece p = this.hit(x, y);
        return (p instanceof WaterPiece);
    }

    /**
     * Vérifie si on peut construire un bateau à l'endroit indiqué
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    private boolean canBuildShipOnIt(int x, int y, int width, int height) {
        // On regarde si on peut construire sur la case en haut à gauche
        if (this.canBuildOnIt(x, y) == false) {
            return false;
        }
        // Pour chaque case que va constituer le bateau, on regarde si on peut construire dessus
        for (int i = 1; i < width + 1; i++) {
            for (int j = 1; j < height + 1; j++) {
                if (this.canBuildOnIt(x + i, y + j) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getRandomPosition(int width) {
        return ThreadLocalRandom.current().nextInt(0, width + 1);
    }

}
