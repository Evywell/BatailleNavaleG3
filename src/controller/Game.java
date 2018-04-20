package controller;

import model.game.ComputerPlayer;
import model.game.HumanPlayer;
import model.game.Party;
import model.game.Player;
import model.stats.Statistiques;

public class Game {

    public static int DIFFICULTE_FACILE = 0;
    public static int DIFFICULTE_NORMALE = 1;
    public static int DIFFICULTE_DIFFICILE = 2;

    public static void main(String[] args) {
        new Statistiques();
        Player playerOne = new HumanPlayer("Evywell");
        Player playerTwo = new ComputerPlayer("Computer");
        Party party = new Party(playerOne, playerTwo, DIFFICULTE_NORMALE);
        party.setCurrentPlayer(playerOne);
    }

}
