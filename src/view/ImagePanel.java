package view;

import controller.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel(){
        try {
            this.image = ImageIO.read(new File(Game.ASSETS_PATH+"/fond2.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this); // see javadoc for more info on the parameters
    }

}
