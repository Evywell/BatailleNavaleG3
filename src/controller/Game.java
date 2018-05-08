package controller;

import model.game.*;
import model.stats.Score;
import model.stats.Statistiques;
import view.*;
import view.BattleField;
import view.MainMenu;

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
        Statistiques stats = new Statistiques();
        Window mainMenu = new MainMenu();
        mainMenu.showWindow();
    }
}
