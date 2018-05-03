package controller;

import model.game.*;
import model.stats.Score;
import model.stats.Statistiques;
import view.BattleField;
import view.MainMenu;
import view.Window;

public class Game {

    public static String ASSETS_PATH = "resources/assets";
    public static int DIFFICULTE_FACILE = 0;
    public static int DIFFICULTE_NORMALE = 1;
    public static int DIFFICULTE_DIFFICILE = 2;
    public static int WIDTH_FIELD_FACILE = 20;
    public static int HEIGHT_FIELD_FACILE = 20;
    public static int WIDTH_FIELD_NORMALE = 20;
    public static int HEIGHT_FIELD_NORMALE = 20;
    public static int WIDTH_FIELD_DIFFICILE = 20;
    public static int HEIGHT_FIELD_DIFFICILE = 20;

    public static void main(String[] args) {
       /* Statistiques stats = new Statistiques();

        Score score = new Score(800);
        score.setPseudo("Test Persist");
        score.setTemps("20:00");
        score.setDifficulte("difficile");

        stats.addScore(score);
        stats.persistScores();

        Player playerOne = new HumanPlayer("Evywell");
        Player playerTwo = new ComputerPlayer("Computer");
        Party party = new Party(playerOne, playerTwo, DIFFICULTE_FACILE);
        party.setCurrentPlayer(playerOne);

        Window battleField = new BattleField(WIDTH_FIELD_FACILE, HEIGHT_FIELD_FACILE, playerOne.getField(), playerTwo.getField(), new controller.BattleField());
        battleField.showWindow();
    }*/

        Window MainMenu = new MainMenu();
        MainMenu.showWindow();
    }
}
