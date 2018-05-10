package view;

        import controller.Game;

        import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.io.File;
        import java.io.IOException;

public class ChoixDifficulte extends Window {

    private controller.ChoixDifficulte controller;

    private int difficulte;

    public ChoixDifficulte() {
        super("Choix difficulté");

        this.controller = new controller.ChoixDifficulte(this);
        // On met la difficulté par défaut
        this.difficulte = Game.DIFFICULTE_FACILE;

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

        difficultee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choix = difficultee.getItemAt(difficultee.getSelectedIndex()).toLowerCase();
                if (choix.equals("facile")) {
                    changerDifficulte(Game.DIFFICULTE_FACILE);
                } else if (choix.equals("moyen")) {
                    changerDifficulte(Game.DIFFICULTE_NORMALE);
                } else if (choix.equals("difficile")) {
                    changerDifficulte(Game.DIFFICULTE_DIFFICILE);
                }
            }
        });

        JButton buttonLancement = new JButton("Lancer la bataille !");
        buttonLancement.setPreferredSize(new Dimension(200,30));

        buttonLancement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startGame(difficulte, pseudo.getText());
            }
        });

        JButton retour = new JButton("Retour");
        retour.setPreferredSize(new Dimension(30,30));

        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.back();
            }
        });

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

    private void changerDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}