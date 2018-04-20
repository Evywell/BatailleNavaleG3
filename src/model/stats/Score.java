package model.stats;

public class Score {

    private String pseudo;
    private int score;
    private String difficulte;
    private String temps;

    /**
     * Constructeur de Score
     * @param score
     */
    public Score(int score) {
        this.score = score;
    }

    /**
     * Constructeur de Score avec un score par défaut de 100
     */
    public Score() {
        this(100);
    }

    /**
     * Retire un certain nombre de point au score
     * @param value La valeur à décrémenter
     */
    public void minus(int value) {
        this.score += value;
    }

    /**
     * Ajoute un certain nombre de point au score
     * @param value
     */
    public void bonus(int value) {
        this.score += value;
    }

    /**
     * @return String Le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo Le pseudo du joueur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return int Le score de la partie
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score Le score de la partie
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return String la difficulté de la partie
     */
    public String getDifficulte() {
        return difficulte;
    }

    /**
     * @param difficulte La difficulté de la partie
     */
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }

    /**
     * @return String Le temps de la partie
     */
    public String getTemps() {
        return temps;
    }

    /**
     * @param temps Le temps de la partie
     */
    public void setTemps(String temps) {
        this.temps = temps;
    }
}
