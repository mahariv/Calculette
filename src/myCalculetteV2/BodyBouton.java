package myCalculetteV2;

import myCalculetteV2.Boutons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
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
                if(!lifo.isEmpty())
                {
                    String val_temp= lifo.pop();
                    if (val_temp =="e")
                    {
                        lab.setText("");
                        lifo.clear();
                        lifo.add("0");
                    }
                    else
                        lifo.add(val_temp);
                    if(val_temp =="0")
                    {
                        System.out.println(lifo.pop());
                        if (lifo.isEmpty())
                        {
                            lab.setText("");
                        }

                    }
                }
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
                    String val_temp = lifo.pop();
                    if (val_temp != "e")
                    {
                        lifo.add(val_temp);
                    }
                    try {
                        String temp_lifo = lifo.pop();
                        lifo.add(temp_lifo);
                        if (temp_lifo == " + " || temp_lifo == " - " || temp_lifo == " X " || temp_lifo == " / " || temp_lifo ==" pow ")
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
        int indicOpSpe = 0; // cosinus sinus tan
        int tailleChiffre = 0;
        Stack<String> rebackLifo = new Stack<String>();

        while (!lifo.isEmpty()) {
            temp = lifo.pop();
            System.out.println(temp);

            if (temp == ".")
            {
                if(indicVirgul == 0) {
                    System.out.println("chiffre apres la virgule :" + resultat + " nb chiffre :" + tailleChiffre);
                    indicVirgul = tailleChiffre;
                    System.out.println("indicVirgul = " + indicVirgul);
                }else
                {System.out.println("un chiffre ne peut avoir qu'une virgule");}
            }

            else {
                if (temp == " + " || temp == " - " || temp == " X " || temp == " / " || temp == " pow ") {
                    System.out.println("op use et indicvirg = " + indicVirgul);

                    if( indicVirgul != 0)
                    {
                        System.out.println("1    " + resultat);
                        // si on a un operateur speciale a la fin cette fonction ne doit pas etre utilisé
                        // sinon le resultat sera faussé a cause d'un decalage de la virgule
                        // car le decalage deja etait effecué precedement lors du calcule de l operateur special
                        if (indicOpSpe != 1) {
                            resultat = (resultat / Math.pow(10, indicVirgul));
                            System.out.println("2 bis    " + resultat);
                        }
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
                        if (temp == " cos " || temp == " sin " || temp == " tan " || temp == " exp " || temp == " ln ") {
                            indicOpSpe = 1;
                            resultat = (resultat / Math.pow(10, indicVirgul));
                            System.out.println("le resultat avant "+ temp +"  "+ resultat);
                            switch (temp)
                            {
                                case " cos ":
                                    resultat = Math.cos(Double.valueOf(resultat));
                                    break;
                                case " sin ":
                                    resultat = Math.sin(Double.valueOf(resultat));
                                    break;
                                case " tan ":
                                    resultat = Math.tan(Double.valueOf(resultat));
                                    break;
                                case " exp ":
                                    resultat = Math.exp(Double.valueOf(resultat));
                                    break;
                                case " ln ":
                                    resultat = Math.log(Double.valueOf(resultat));
                                    break;
                            }

                            //resultat = Math.cos(Double.valueOf(resultat));
                            System.out.println("le resultat apres "+ temp +" " + resultat);

                        }
                        else
                        {
                            resultat += indic * Double.valueOf(temp);
                            indic *= 10;
                            tailleChiffre++;
                        }
                    }
                }

            }

        //--------------------------------------------------------------------------

        // Cette partie concerne le traitement du dernier chiffre de la pile
        if( indicVirgul != 0)
        {
            System.out.println(" non op use et indicvirg = " + indicVirgul);
            System.out.println("1 bis    " + resultat);
            // si on a un operateur speciale a la fin cette fonction ne doit pas etre utilisé
            // sinon le resultat sera faussé a cause d'un decalage de la virgule
            // car le decalage deja etait effecué precedement lors du calcule de l operateur special
            if (indicOpSpe != 1) {
                resultat = (resultat / Math.pow(10, indicVirgul));
                System.out.println("2 bis    " + resultat);
            }
            indicVirgul = 0 ;
        }

        rebackLifo.add(String.valueOf(resultat));
        System.out.println(String.valueOf(resultat));
        //----------------------------------------------------------------------------
        return rebackLifo;
    }

    public void Action6(Boutons bt, JLabel lab) {
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lotonum ="";
                for (int i = 0; i< 12; i++)
                {
                    Random rand = new Random();
                    int nombre = rand.nextInt(10);
                    lotonum += Integer.toString(nombre);
                }
                lab.setText(lotonum);

            }
        });
    }
}
