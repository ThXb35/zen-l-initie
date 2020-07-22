package listener;

import java.awt.event.*;

import game.Difficulty;
import game.Display;
import game.GameInitializer;
import game.Mode;
import view.Game;
import view.Menu;
import view.Saves;
import view.Solo;


public class SaveListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Saves.bSave1){

            GameInitializer.readSaves();

        }

        if(e.getSource() == Saves.backButton){

            Menu.fenetreSave.setVisible(false);

        }

    }
    
}