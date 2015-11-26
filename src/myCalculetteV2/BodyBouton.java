package myCalculetteV2;

import myCalculetteV2.Boutons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by jeremy on 15/11/2015.
 */
public class BodyBouton {

    BodyBouton()
    {}

    public void Action_1 (Boutons bt, String value, JLabel lab, Stack<String> lifo)
    {
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = lab.getText();
                String Val = value;
                lab.setText(temp + Val);
                lifo.add(Val);
            }
        });
    }

    //-----------------clear--------------------------//

    //ce code genere des anomalies si il n'est pas dans le main
    public void Action_2 (Boutons bt,JLabel lab,Stack<String> lifo)
    {
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = lab.getText();
                System.out.println(temp + temp.length());
                temp = temp.substring(0,temp.length()-1);  // permet d afficher la chaine sans le dernier caractere
                System.out.println(temp);
                lab.setText(temp);
                lifo.pop();
            }
        });
    }
    //------------------------------------------------------

    //-----------------------MC   Mega Clear-----------------------
    public void Action_3 (Boutons bt,JLabel lab,Stack<String> lifo)
    {
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lab.setText("0");
                lifo.clear();
                lifo.add("0");
            }
        });
    }
    //---------------------------------------------------------------
    //pour les operateur

    public void Action_4 (Boutons bt, String value, JLabel lab, Stack<String> lifo)
    {
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lifo.isEmpty()){
                    System.out.println("Erreur il faut d'abord renseigner un nombre");
                }
                else {
                    try {
                        String temp_lifo = lifo.pop();
                        lifo.add(temp_lifo);
                        if (temp_lifo == " + " || temp_lifo == " - " || temp_lifo == " X " || temp_lifo == " / ")
                        {
                            System.out.println("il faut qu'il ait un chiffre entre deux operateurs");
                        }
                        else {
                            String temp = lab.getText();
                            String Val = value;
                            lab.setText(temp + Val);
                            lifo.add(Val);
                        }
                    }catch (Exception exep)
                    {
                        System.out.println("Erreur : " + exep);
                    }
                }
            }
        });
    }

    public int resultExe(Stack<String> lifo)
    {
        int result = 0;
        return  result;
    }

    public Stack<String> RebackLifo(Stack<String> lifo)
    {
        double resultat = 0;
        String temp = "";
        String tempCalc = "";
        int indic = 1;
        int indicVirgul = 0;
        int tailleChiffre = 0;
        Stack<String> rebackLifo = new Stack<String>();

        while (!lifo.isEmpty()) {
            temp = lifo.pop();
            System.out.println(temp);

            if (temp == ".")
            {
                System.out.println("chiffre apres la virgule :" + resultat + " nb chiffre :" + tailleChiffre);

                indicVirgul = tailleChiffre;
                System.out.println("indicVirgul = " + indicVirgul);
            }

            else {
                if (temp == ".")
                {
                    System.out.println("chiffre apres la virgule :" + resultat + " nb chiffre :" + tailleChiffre);

                    indicVirgul = tailleChiffre;
                    System.out.println("indicVirgul = " + indicVirgul);
                }
                if (temp == " + " || temp == " - " || temp == " X " || temp == " / ") {
                    System.out.println("op use et indicvirg = " + indicVirgul);
                    if( indicVirgul != 0)
                    {
                        System.out.println("1    " + resultat);
                        resultat = (resultat / Math.pow(10, indicVirgul));
                        System.out.println("2    " + resultat);
                        indicVirgul = 0 ;
                    }
                    rebackLifo.add(String.valueOf(resultat));
                    rebackLifo.add(temp);
                    System.out.println(String.valueOf(resultat));
                    System.out.println(temp);
                    indic = 1;
                    resultat = 0;
                    tailleChiffre = 0;
                } else {
                        resultat += indic * Double.valueOf(temp);
                        indic *= 10;
                        tailleChiffre++;
                    }
                }
            }
        if( indicVirgul != 0)
        {
            System.out.println(" non op use et indicvirg = " + indicVirgul);
            System.out.println("1    " + resultat);
            resultat = (resultat / Math.pow(10, indicVirgul));
            System.out.println("2    " + resultat);
            indicVirgul = 0 ;
        }
        rebackLifo.add(String.valueOf(resultat));
        System.out.println(String.valueOf(resultat));
        return rebackLifo;
    }

}
