package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import listener.SaveListener;

public class Saves extends JPanel {
    
    public static JLabel title;
    public static JLabel logo;

    public static JButton backButton;

    public static JButton bSave1;
    public static JButton bSave2;
    public static JButton bSave3;


    public Saves(){

        initComponents();

    }

    public void initComponents(){

        Saves.title = new JLabel("Parties sauvegardees");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,45));

        logo = new JLabel(new ImageIcon("data/zenlogo"));


        Saves.backButton = new JButton("<");
        backButton.addActionListener(new SaveListener());

        Saves.bSave1 = new JButton("Restaurer la sauvegarde");
 

        this.setLayout(null);

        logo.setBounds(590, 100, 100, 100);
        title.setBounds(340,100,600,70);

        bSave1.setBounds(140, 230 , 1000, 115);
        bSave1.addActionListener(new SaveListener());

        backButton.setBounds(30, 30, 50, 50);


        this.add(title);
        this.add(logo);
        this.add(bSave1);
        this.add(backButton);


    }

}