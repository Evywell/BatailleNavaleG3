package controller;

import view.ChoixDifficulte;
import view.Window;

public class MainMenu {

    private view.MainMenu mainMenuView;

    public MainMenu (view.MainMenu mainMenuView) {
        this.mainMenuView = mainMenuView;
    }

    public void launchGameView () {
        // On charge la vue du jeu
        Window choixDifficulte = new ChoixDifficulte();
        choixDifficulte.showWindow();

        // On ferme la vue du menu
        mainMenuView.dispose();
    }

    public void launchStatsView () {
        // On charge la vue des stats
        Window stats = new view.Stats();
        stats.showWindow();

        // On ferme la vue du menu
        mainMenuView.dispose();
    }

    public void quitGame () {
        mainMenuView.dispose();
        System.exit(0);
    }

}
