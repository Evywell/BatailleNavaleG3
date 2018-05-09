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
        int width = this.getWidth(difficulte);
        int height = this.getHeight(difficulte);

        Player player = new HumanPlayer(pseudo);
        Player computer = new ComputerPlayer("Computer 1");
        Party party = new Party(player, computer, difficulte);
        // party.start();

        Window battleField = new BattleField(width, height, player.getField(), computer.getField(), new controller.BattleField(party));
        battleField.showWindow();

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

    private int getWidth (int difficulte) {
        if (difficulte == Game.DIFFICULTE_FACILE) {
            return Game.WIDTH_FIELD_FACILE;
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            return Game.WIDTH_FIELD_NORMALE;
        } else if (difficulte == Game.DIFFICULTE_DIFFICILE) {
            return Game.WIDTH_FIELD_DIFFICILE;
        }

        return Game.WIDTH_FIELD_FACILE;
    }

    private int getHeight (int difficulte) {
        if (difficulte == Game.DIFFICULTE_FACILE) {
            return Game.HEIGHT_FIELD_FACILE;
        } else if (difficulte == Game.DIFFICULTE_NORMALE) {
            return Game.HEIGHT_FIELD_NORMALE;
        } else if (difficulte == Game.DIFFICULTE_DIFFICILE) {
            return Game.HEIGHT_FIELD_DIFFICILE;
        }

        return Game.HEIGHT_FIELD_FACILE;
    }

}
