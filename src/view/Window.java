package view;

import javax.swing.*;

public class Window extends JFrame {

    private int width;
    private int height;
    private String title;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;

        this.createWindow();
    }

    public Window(String title) {
        this(1280, 720, title);
    }

    public void createWindow() {
        this.setTitle(this.title);
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showWindow() {
        this.setVisible(true);
    }

    public void hideWindow() {
        this.setVisible(false);
    }

}
