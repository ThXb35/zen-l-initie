package listener;

import java.awt.event.*;

import game.GamePlay;
import view.Game;


public class GameListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Game.bQuitter){

            GamePlay.fenetreGame.setVisible(false);

        }
        
    }
    
}