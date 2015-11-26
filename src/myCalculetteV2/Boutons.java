package myCalculetteV2;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by jeremy on 21/04/2015.
 */
public class Boutons extends JButton{
    public Boutons(String name)
    {
        super(name);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setPreferredSize(new Dimension(150,65));

    };


    public Boutons (String name, int height, int weight)
    {
        super(name);
        this.setFont(new Font("Arial",Font.BOLD,20));
        this.setPreferredSize(new Dimension(weight, height));
        this.setSize(new Dimension(height,weight));
    }

    //
    public static String cinString(String description, String box_name)
    {
        return (String)JOptionPane.showInputDialog( null, description, box_name, JOptionPane.PLAIN_MESSAGE);
    }


}