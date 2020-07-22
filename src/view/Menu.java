package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GamePlay;
import listener.MenuListener;
import listener.SaveListener;

public class Menu extends JPanel {
    
    public static JLabel logoPicture;

    public static JButton bSolo;
    public static JButton bMulti;
    public static JButton bSaves;
    public static JButton bOptions;
    public static JButton bStats;
    public static JButton bQuitter;

    public static ImageIcon test;

    public static JFrame fenetreSave;
    public static JFrame fenetreMulti;
    public static JFrame fenetreSolo;



    public Menu(){

        Saves save = new Saves();
        Multi multi = new Multi();
        Solo solo = new Solo();

        fenetreSave = new JFrame("Parties sauvegardees");
        fenetreMulti = new JFrame("Multijoueurs");
        fenetreSolo = new JFrame("Solo");

        fenetreSave.setPreferredSize(new Dimension(1280, 720));
        fenetreSave.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fenetreSave.setVisible(false);
        fenetreSave.pack();
        fenetreSave.add(save);

        fenetreMulti.setPreferredSize(new Dimension(1280, 720));
        fenetreMulti.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fenetreMulti.setVisible(false);
        fenetreMulti.pack();
        fenetreMulti.add(multi);

        fenetreSolo.setPreferredSize(new Dimension(1280, 720));
        fenetreSolo.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fenetreSolo.setVisible(false);
        fenetreSolo.pack();
        fenetreSolo.add(solo);


        
        initComponents();

    }

    public void initComponents(){

        //On initialise les boutons et logos
        logoPicture = new JLabel(new ImageIcon("data/zenlogo.png"));
        bSolo = new JButton("Jouer en solo");
        bMulti = new JButton("Jouer en multijoueurs");
        bSaves = new JButton("Parties sauvegardees");
        bOptions = new JButton(new ImageIcon("data/option.png"));
        bOptions.setEnabled(false);
        bStats = new JButton(new ImageIcon("data/coupe.png"));
        bStats.setEnabled(false);
        bQuitter =  new JButton("Quitter");
        bQuitter.addActionListener(new MenuListener());

        //On met le layer à null pour permettre d'utiliser setBounds
        this.setLayout(null);

        //On place tous les éléments
        logoPicture.setBounds(590, 100, 100, 100);
        bSolo.setBounds(440, 200, 400, 70);
        bMulti.setBounds(440, 300, 400, 70);
        bSaves.setBounds(440, 400, 400, 70);
        bQuitter.setBounds(440,500,400,70);

        //ON ajoute les listener
        bSolo.addActionListener(new MenuListener());
        bMulti.addActionListener(new MenuListener());
        bSaves.addActionListener(new MenuListener());

        //On ajoute tous les éléments au panel
        this.add(logoPicture);
        this.add(bSolo);
        this.add(bOptions);
        this.add(bMulti);
        this.add(bStats);
        this.add(bSaves);
        this.add(bQuitter);

    }

    public void hideorShow(boolean hideOrShow){

        this.setVisible(hideOrShow);

    }
}