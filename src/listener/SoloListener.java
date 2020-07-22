package listener;

import java.awt.event.*;

import game.Difficulty;
import game.Display;
import game.GameInitializer;
import game.Mode;
import view.Menu;
import view.Solo;

public class SoloListener implements ActionListener {
    
    private Difficulty difficulty;
    private int variante;
    private static boolean verif1;
    private static boolean verif2;
    private static boolean verif3;


    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == Solo.bQuitter){

            Menu.fenetreSolo.setVisible(false);

        }

        if(e.getSource() == Solo.bEasy){

            this.difficulty = Difficulty.EASY; 
            verif1 = true;        

        }

        if(e.getSource() == Solo.bMedium){

            this.difficulty = Difficulty.MEDIUM;    
            verif1 = true;
     

        }

        if(e.getSource() == Solo.bHard){

            this.difficulty = Difficulty.HARD;  
            verif1 = true;
       

        }

        if(e.getSource() == Solo.bBase){

            this.variante = 4;
            verif2 = true;
         

        }

        if(e.getSource() == Solo.bVariante1){

            this.variante = 1;   
            verif2 = true;
      

        }

        if(e.getSource() == Solo.bVariante2){

            this.variante = 2;   
            verif2 = true;
      

        }

        if(e.getSource() == Solo.bVariante3){

            this.variante = 3;  
            verif2 = true;
       

        }

        if(!Solo.name.getText().equals("")){
            verif3 = true;
        }

        Solo.config.setText("Configuration actuelle : Variante = " + this.variante + " et difficulte = " + this.difficulty);


        if(e.getSource() == Solo.bJouer){
            if(verif1 && verif2 && verif3){
                Menu.fenetreSolo.setVisible(false);
                //GamePlay.fenetreGame.setVisible(true);
                new GameInitializer(Solo.name.getText(), "Robot", variante, Mode.HA, Display.GRAPHIC, this.difficulty);

            }else{

                Solo.config.setText("Veuillez remplir tous les champs");


            }
        }

    }

}