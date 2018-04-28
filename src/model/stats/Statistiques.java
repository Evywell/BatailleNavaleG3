package model.stats;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
        this.sortScores();
    }

    /**
     * Méthode d'initialisation des statistiques
     */
    private void initialize() {
        // Initialise les statistiques en lisant le fichier resources/stats.xml
        File fXmlFile = new File(FILENAME);
        if (fXmlFile.exists()) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);
                // On récupère les derniers scores
                NodeList scores = doc.getElementsByTagName("score");
                for (int i = 0; i < scores.getLength(); i++) {
                    Node node = scores.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element scoreElement = (Element) node;
                        Score score = new Score();
                        score.setPseudo(scoreElement.getAttribute("pseudo"));
                        score.setScore(Integer.parseInt(scoreElement.getAttribute("score")));
                        score.setTemps(scoreElement.getAttribute("temps"));
                        score.setDifficulte(scoreElement.getAttribute("difficulte"));
                        this.scores.add(score);
                    }
                }
                // On récupère le dernier score
                NodeList scoreNodes = doc.getElementsByTagName("lastScore");
                Node scoreNode = scoreNodes.item(0);
                Element scoreElement = (Element) scoreNode;
                Score lastScore = new Score();
                lastScore.setPseudo(scoreElement.getAttribute("pseudo"));
                lastScore.setScore(Integer.parseInt(scoreElement.getAttribute("score")));
                lastScore.setTemps(scoreElement.getAttribute("temps"));
                lastScore.setDifficulte(scoreElement.getAttribute("difficulte"));
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        this.scores.sort(new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o1.getScore() < o2.getScore() ? 1 : -1;
            }
        });
    }

}
