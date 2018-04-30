package model.stats;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
     * Ajoute un score
     */
    public void addScore(Score score) {
        this.lastScore = score;
        this.scores.add(score);
    }


    /**
     * Enregistre dans le fichier stats.xml les scores
     */
    public void persistScores() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.newDocument();

            // Elément racine
            Element root = xml.createElement("stats");

            // Last score
            Element lastScore = xml.createElement("lastScore");
            lastScore.setAttribute("pseudo", this.lastScore.getPseudo());
            lastScore.setAttribute("temps", this.lastScore.getTemps());
            lastScore.setAttribute("difficulte", this.lastScore.getDifficulte());
            lastScore.setAttribute("score", String.valueOf(this.lastScore.getScore()));

            // Les scores
            // On classe les scores
            this.sortScores();
            Element scores = xml.createElement("scores");
            this.scores.forEach(score -> {
                Element scoreElement = xml.createElement("score");
                scoreElement.setAttribute("pseudo", score.getPseudo());
                scoreElement.setAttribute("temps", score.getTemps());
                scoreElement.setAttribute("difficulte", score.getDifficulte());
                scoreElement.setAttribute("score", String.valueOf(score.getScore()));
                scores.appendChild(scoreElement);
            });

            // On ajoute tout à l'élément racine
            root.appendChild(scores);
            root.appendChild(lastScore);

            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult XML = new StreamResult(FILENAME);

            t.transform(new DOMSource(root), XML);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
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
    public List<Score> getHighScores() {
        this.sortScores();
        return this.scores;
    }

    /**
     * Récupère le dernier score enregistré
     * @return Score
     */
    public Score getLastScore() {
        return this.lastScore;
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
