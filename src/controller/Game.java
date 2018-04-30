package controller;

import model.game.*;
import model.stats.Statistiques;
import view.BattleField;
import view.Window;

public class Game {

    public static String ASSETS_PATH = "resources/assets";
    public static int DIFFICULTE_FACILE = 0;
    public static int DIFFICULTE_NORMALE = 1;
    public static int DIFFICULTE_DIFFICILE = 2;
    public static int WIDTH_FIELD_FACILE = 20;
    public static int HEIGHT_FIELD_FACILE = 20;

    public static void main(String[] args) {
        Field playerField = new Field(WIDTH_FIELD_FACILE, HEIGHT_FIELD_FACILE);
        Field computerField = new Field(WIDTH_FIELD_FACILE, HEIGHT_FIELD_FACILE);

        Window battleField = new BattleField(WIDTH_FIELD_FACILE, HEIGHT_FIELD_FACILE, playerField.getPieces(), computerField.getPieces());
        battleField.showWindow();

        new Statistiques();
        Player playerOne = new HumanPlayer("Evywell");
        Player playerTwo = new ComputerPlayer("Computer");
        Party party = new Party(playerOne, playerTwo, DIFFICULTE_NORMALE);
        party.setCurrentPlayer(playerOne);
    }

}
