package listener;

import java.awt.event.*;

import view.Menu;



public class MenuListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Menu.bSolo){

            Menu.fenetreSolo.setVisible(true);

        }

        if(e.getSource() == Menu.bMulti){

            Menu.fenetreMulti.setVisible(true);

        }

        if(e.getSource() == Menu.bSaves){

            Menu.fenetreSave.setVisible(true);

        }

    }
    

}