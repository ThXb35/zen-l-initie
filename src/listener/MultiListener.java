package listener;

import java.awt.event.*;

import game.Difficulty;
import game.Display;
import game.GameInitializer;
import game.GamePlay;
import game.Mode;
import view.Menu;
import view.Multi;


public class MultiListener implements ActionListener{

    public static int mode;
    public static int number;

    private static boolean verif1;
    private static boolean verif2;
    private static boolean verif3;
    private static boolean verif4;


    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Multi.bQuitter){

            Menu.fenetreMulti.setVisible(false);

        }

        if(!Multi.name1.getText().equals("")){
            verif3 = true;
        }

        if(!Multi.name2.getText().equals("")){
            verif4 = true;
        }


        if(e.getSource() == Multi.bSameComputer){

            this.mode = 1; 
            verif1 = true;        

        }

        if(e.getSource() == Multi.bLocal){

            this.mode = 2;
            verif1 = true;
     

        }

        if(e.getSource() == Multi.bReseau){

            this.mode = 3;  
            verif1 = true;
       

        }

        if(e.getSource() == Multi.bTournoi){

            this.mode = 4;
            verif1 = true;
         

        }

        if(e.getSource() == Multi.b1V1){

            this.number = 1;   
            verif2 = true;
      

        }

        if(e.getSource() == Multi.b2V2){

            this.number = 2;   
            verif2 = true;
      

        }

        if(e.getSource() == Menu.bQuitter){

            System.exit(1);

        }


        Multi.config.setText("Configuration actuelle : Mode = " + this.mode + " et equipe = " + this.number);


        if(e.getSource() == Multi.bJouer){
       
            if(verif1 && verif2 && verif3 && verif4){
                Menu.fenetreMulti.setVisible(false);
                new GameInitializer(Multi.name1.getText(), Multi.name2.getText(), 1, Mode.HH, Display.GRAPHIC, Difficulty.EASY);

            }else{

                Multi.config.setText("Veuillez remplir tous les champs");

            }
        }

    }

}
    
