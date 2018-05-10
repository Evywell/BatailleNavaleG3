package controller;

import model.game.*;
import model.stats.Score;
import model.stats.Statistiques;
import view.*;
import view.BattleField;
import view.MainMenu;

public class Game {

    public static String ASSETS_PATH = "resources/assets";
    public static int DIFFICULTE_FACILE = 1;
    public static int DIFFICULTE_NORMALE = 2;
    public static int DIFFICULTE_DIFFICILE = 3;
    public static int WIDTH_FIELD_FACILE = 10;
    public static int HEIGHT_FIELD_FACILE = 10;
    public static int WIDTH_FIELD_NORMALE = 20;
    public static int HEIGHT_FIELD_NORMALE = 20;
    public static int WIDTH_FIELD_DIFFICILE = 30;
    public static int HEIGHT_FIELD_DIFFICILE = 30;

    public static void main(String[] args) {
        Statistiques stats = new Statistiques();
        Window mainMenu = new MainMenu();
        mainMenu.showWindow();
    }
}
