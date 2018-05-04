package view;

        import controller.Game;

        import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.io.File;
        import java.io.IOException;

public class ChoixDifficulte extends Window {

    public ChoixDifficulte() {
        super("Choix difficulté");

        this.setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        JPanel imageFond = new ImagePanel();

        menu.setLayout(new BorderLayout());
        menu.setPreferredSize(new Dimension(120, 120));

        JTextField pseudo = new JTextField(15);
        pseudo.setPreferredSize(new Dimension(30,30));

        JComboBox<String> difficultee = new JComboBox<String>();
        difficultee.addItem("Facile");
        difficultee.addItem("Moyen");
        difficultee.addItem("Difficile");
       difficultee.setPreferredSize(new Dimension(30,30));

        JButton buttonLancement = new JButton("Lancer la bataille !");
        buttonLancement.setPreferredSize(new Dimension(200,30));

        JButton retour = new JButton("Retour");
        retour.setPreferredSize(new Dimension(30,30));

        menu.add(pseudo, BorderLayout.NORTH);
        menu.add(difficultee, BorderLayout.CENTER);
        menu.add(buttonLancement, BorderLayout.EAST);
        menu.add(retour, BorderLayout.SOUTH);

        //this.setContentPane(imageFond);
        this.getContentPane().add(imageFond);
        this.getContentPane().add(menu, BorderLayout.SOUTH);
    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, getWidth(), getHeight());

        try {
            Image image = ImageIO.read(new File(Game.ASSETS_PATH + "/fond2.png"));
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}