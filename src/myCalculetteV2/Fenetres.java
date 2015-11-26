package myCalculetteV2;

import javax.swing.*;

import java.awt.*;

/**
 * Created by jeremy on 21/04/2015.
 */
public class Fenetres extends JFrame {

    public Fenetres() {
        this.setTitle("MY WINDOWS");
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public Fenetres(String name) {
        this.setTitle(name);
        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public Fenetres(String name, int height, int weight) {
        this.setTitle(name);
        this.setSize(height, weight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
