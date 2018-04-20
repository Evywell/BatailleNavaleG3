package model.stats;

import java.util.ArrayList;
import java.util.List;

public class Statistiques {

    private List<Score> scores;
    private Score lastScore;
    public static String FILENAME = "resources/stats.xml";

    /**
     * Constructeur de Statistiques
     */
    public Statistiques() {
        this.scores = new ArrayList<>();
        this.initialize();
    }

    /**
     * Méthode d'initialisation des statistiques
     */
    private void initialize() {
        // Initialise les statistiques en lisant le fichier resources/stats.xml
    }

    /**
     * Récupère les 5 meilleurs scores
     * @return La liste des scores
     */
    private List<Score> getHighScores() {
        return this.scores;
    }

    /**
     * Récupère le dernier score enregistré
     * @return Score
     */
    private Score getLastScore() {
        return this.lastScore;
    }

    /**
     * Enregistre dans le fichier stats.xml les scores
     */
    private void persistScores() {

    }

    /**
     * Trie les scores
     */
    private void sortScores() {

    }

}
