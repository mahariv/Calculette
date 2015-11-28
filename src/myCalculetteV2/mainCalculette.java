package myCalculetteV2;

import myCalculetteV2.BodyBouton;
import myCalculetteV2.Boutons;
import myCalculetteV2.Fenetres;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.Stack;


/**
 * Created by jeremy on 12/11/2015.
 */
public class mainCalculette {
    static int indic_equal = 0;

    public static void main(String[] args)
    {

        int hauteur = 800;
        int largeur = 600;
        BodyBouton bodyB = new BodyBouton();

        Fenetres myFenetre = new Fenetres("Calculette",largeur,hauteur);
        myFenetre.setResizable(false);
        JPanel affichage = new JPanel();
        JPanel bodyPanel = new JPanel();

        myFenetre.setLayout(new BorderLayout());


        Stack<String> lifo = new Stack<String>();

        String resultat = "";
        affichage.setLayout(new GridLayout(2, 1));

        JLabel affichageRes = new JLabel(resultat);
        affichageRes.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel affichageHistory = new JLabel();
        affichageHistory.setFont(new Font("Arial", Font.ITALIC, 20));

        /*TextField affichageRes = new TextField(); */
        affichageRes.setPreferredSize(new Dimension(largeur,50));
        affichageHistory.setPreferredSize(new Dimension(largeur, 50));

        affichage.add(affichageHistory);
        affichage.add(affichageRes);


        bodyPanel.setLayout(new GridLayout(5,5));
        bodyPanel.setBackground(Color.lightGray);

        Boutons bouton_clear = new Boutons("C");
        Boutons bouton_plus = new Boutons("+");
        Boutons bouton_div = new Boutons("/");
        Boutons bouton_fois = new Boutons("X");
        Boutons bouton_alpha1 = new Boutons("cos");

        bodyPanel.add(bouton_clear);
        bodyPanel.add(bouton_plus);
        bodyPanel.add(bouton_div);
        bodyPanel.add(bouton_fois);
        bodyPanel.add(bouton_alpha1);



        /*------ligne 1 ----------------------------------*/

        Boutons bouton_1 = new Boutons("1");
        Boutons bouton_2 = new Boutons("2");
        Boutons bouton_3 = new Boutons("3");
        Boutons bouton_moins = new Boutons("-");
        Boutons bouton_alpha2 = new Boutons("sin");

        bodyPanel.add(bouton_1);
        bodyPanel.add(bouton_2);
        bodyPanel.add(bouton_3);
        bodyPanel.add(bouton_moins);
        bodyPanel.add(bouton_alpha2);

        /*------ligne 2 --------------------------------*/

        Boutons bouton_4 = new Boutons("4");
        Boutons bouton_5 = new Boutons("5");
        Boutons bouton_6 = new Boutons("6");
        Boutons bouton_pow = new Boutons("pow");
        Boutons bouton_alpha3 = new Boutons("tan");

        bodyPanel.add(bouton_4);
        bodyPanel.add(bouton_5);
        bodyPanel.add(bouton_6);
        bodyPanel.add(bouton_pow);
        bodyPanel.add(bouton_alpha3);

        /*-------------------------------------------------------------*/

        /*------ligne 3 ------------------------------------------------*/
        Boutons bouton_7 = new Boutons("7");
        Boutons bouton_8 = new Boutons("8");
        Boutons bouton_9 = new Boutons("9");
        Boutons bouton_rd = new Boutons("rd");
        Boutons bouton_alpha4 = new Boutons("exp");

        bodyPanel.add(bouton_7);
        bodyPanel.add(bouton_8);
        bodyPanel.add(bouton_9);
        bodyPanel.add(bouton_rd);
        bodyPanel.add(bouton_alpha4);

        /*-------------------------------------------------*/

        Boutons bouton_point = new Boutons(".");
        Boutons bouton_0 = new Boutons("0");
        Boutons bouton_mclear = new Boutons("MC");
        Boutons bouton_equal = new Boutons("=");
        Boutons bouton_alpha5 = new Boutons("ln");

        bodyPanel.add(bouton_point);
        bodyPanel.add(bouton_0);
        bodyPanel.add(bouton_mclear);
        bodyPanel.add(bouton_equal);
        bodyPanel.add(bouton_alpha5);



        /*-------------------Corps boutons------------------------------------------*/

        myFenetre.add(affichage, BorderLayout.NORTH);

        myFenetre.add(bodyPanel, BorderLayout.CENTER);

        //--------------------------Chiffre----------------------//

        bodyB.Action_1(bouton_0, "0", affichageRes, lifo);
        bodyB.Action_1(bouton_1, "1", affichageRes, lifo);
        bodyB.Action_1(bouton_2, "2", affichageRes, lifo);
        bodyB.Action_1(bouton_3, "3", affichageRes, lifo);
        bodyB.Action_1(bouton_4, "4", affichageRes, lifo);
        bodyB.Action_1(bouton_5, "5", affichageRes, lifo);
        bodyB.Action_1(bouton_6, "6", affichageRes, lifo);
        bodyB.Action_1(bouton_7, "7", affichageRes, lifo);
        bodyB.Action_1(bouton_8, "8", affichageRes, lifo);
        bodyB.Action_1(bouton_9, "9", affichageRes, lifo);
        bodyB.Action_1(bouton_point, ".", affichageRes, lifo);


        //-----------------------Operateur------------------------//

        bodyB.Action_4(bouton_plus, " + ", affichageRes, lifo);
        bodyB.Action_4(bouton_moins, " - ", affichageRes, lifo);
        bodyB.Action_4(bouton_div, " / ", affichageRes, lifo);
        bodyB.Action_4(bouton_fois, " X ", affichageRes, lifo);
        bodyB.Action_4(bouton_pow, " pow ", affichageRes, lifo);


        //-------------------------operateurSpeciaux-------------//

        bodyB.Action_1(bouton_alpha1, " cos ", affichageRes, lifo);
        bodyB.Action_1(bouton_alpha2, " sin ",affichageRes, lifo);
        bodyB.Action_1(bouton_alpha3, " tan ", affichageRes, lifo);
        bodyB.Action_1(bouton_alpha4, " exp ", affichageRes, lifo);
        bodyB.Action_1(bouton_alpha5, " ln ", affichageRes, lifo);


        bodyB.Action_3(bouton_mclear, affichageRes, lifo);

        bodyB.Action6(bouton_rd, affichageRes);

        bouton_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (lifo.isEmpty()) {
                        affichageRes.setText("");
                    } else {
                        String temp = affichageRes.getText();
                        String temp_lifo = lifo.pop();
                        System.out.println(temp_lifo);
                        if (temp_lifo == " + " || temp_lifo == " - " || temp_lifo == " X " || temp_lifo == " / " || temp_lifo ==" pow ") {
                            temp = temp.substring(0, temp.length() - 3);  // permet d afficher la chaine sans les 3 derniers caractere
                        } else {
                            temp = temp.substring(0, temp.length() - 1);  // permet d afficher la chaine sans le dernier caractere
                        }
                        System.out.println(temp);
                        affichageRes.setText(temp);
                    }
                } catch (Exception excep) {
                    System.out.println("Erreur : " + excep);
                }
            }
        });

        // dans cette fonction il faudra rajouter la condition suivante il faut que ca se termine par un nombre
        bouton_equal.addActionListener(new ActionListener() {
                                           @Override
                                           public void actionPerformed(ActionEvent e) {
                                               affichageHistory.setText(affichageRes.getText());
                                               indic_equal = 1;
                                               Stack<String> rebackLifo = bodyB.RebackLifo(lifo);
                                               double resultat = 0;
                                               String temp_val = "";
                                               while (!rebackLifo.isEmpty()) {
                                                   temp_val = rebackLifo.pop();
                                                   System.out.println(temp_val);
                                                   if (temp_val == " + " || temp_val == " - " || temp_val == " X " || temp_val == " / " || temp_val == " pow ") {
                                                       switch (temp_val) {
                                                           case " + ":
                                                               resultat = resultat + Double.valueOf(rebackLifo.pop());
                                                               break;
                                                           case " - ":
                                                               resultat = resultat - Double.valueOf(rebackLifo.pop());
                                                               break;
                                                           case " X ":
                                                               resultat = resultat * Double.valueOf(rebackLifo.pop());
                                                               break;
                                                           case " / ":
                                                               resultat = resultat / Double.valueOf(rebackLifo.pop());
                                                               break;
                                                           case " pow ":
                                                               resultat =  Math.pow(resultat,Double.valueOf(rebackLifo.pop()));
                                                               break;
                                                           default :
                                                               break;
                                                       }
                                                   } else {
                                                       resultat += Double.valueOf(temp_val);
                                                   }

                                               }

                                               String stringRes = String.valueOf(resultat);
                                               lifo.add(stringRes);
                                               lifo.add("e");
                                               affichageRes.setText(stringRes);
                                           }
                                       }
        );

        affichage.setVisible(true);
        affichageRes.setVisible(true);
        affichageHistory.setVisible(true);
            bodyPanel.setVisible(true);
            myFenetre.setVisible(true);

        affichageHistory.setText("");

        affichageRes.setText("0");
        lifo.add("0");
     }

    }
