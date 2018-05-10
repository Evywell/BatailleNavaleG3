package controller;

import model.game.ComputerPlayer;
import model.game.HumanPlayer;
import model.game.Party;
import model.game.Player;
import view.BattleField;
import view.Window;

public class ChoixDifficulte {

    private view.ChoixDifficulte view;

    public ChoixDifficulte (view.ChoixDifficulte view) {
        this.view = view;
    }

    public void startGame (int difficulte, String pseudo) {
        Player player = new HumanPlayer(pseudo);
        Player computer = new ComputerPlayer("Computer 1");
        player.setOpponent(computer);
        computer.setOpponent(player);
        controller.BattleField bController = new controller.BattleField(player, computer, difficulte);

        // On ferme la view de sélection de la difficultée
        this.view.dispose();
    }

    public void back () {
        // On ouvre le menu principal
        Window menuPrincipal = new view.MainMenu();
        menuPrincipal.showWindow();

        // On ferme la view
        this.view.dispose();
    }

}
