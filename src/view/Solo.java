package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import listener.SoloListener;

public class Solo extends JPanel{
    
    public static JLabel difficulty;
    public static JLabel variante;
    public static JLabel title;
    public static JLabel logo;
    public static JLabel config;
    public static JLabel enterName;


    public static JButton bEasy;
    public static JButton bMedium;
    public static JButton bHard;

    public static JButton bBase;
    public static JButton bVariante1;
    public static JButton bVariante2;
    public static JButton bVariante3;

    public static JButton bJouer;
    public static JButton bQuitter;

    public static JTextField name;






    public Solo(){

        initComponents();

    }

    public void initComponents(){
        
        SoloListener listener = new SoloListener();

        //On initialise les attributs
        Solo.difficulty = new JLabel("Choix du niveau de difficulte");
        difficulty.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        Solo.variante = new JLabel("Choix de la variante");
        variante.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        Solo.config = new JLabel("Configuration actuelle : ");
        config.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        Solo.name = new JTextField();

        Solo.enterName = new JLabel("Pseudo du joueur");
        enterName.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));



        Solo.title = new JLabel("Jouer en solo");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,45));

        Solo.bQuitter = new JButton("Quitter");
        bQuitter.addActionListener(listener);
        
        Solo.bJouer = new JButton("Jouer");
        bJouer.addActionListener(listener);

        Solo.bEasy = new JButton("Facile");
        bEasy.addActionListener(listener);

        Solo.bMedium = new JButton("Moyen");
        bMedium.addActionListener(listener);
        bMedium.setEnabled(false);

        Solo.bHard = new JButton("Hard");
        bHard.addActionListener(listener);
        bHard.setEnabled(false);

        Solo.bBase = new JButton("Jeu de base");
        bBase.addActionListener(listener);

        Solo.bVariante1 = new JButton("Variante 1");
        bVariante1.addActionListener(listener);
        bVariante1.setEnabled(false);

        Solo.bVariante2 = new JButton("Variante 2");
        bVariante2.addActionListener(listener);
        bVariante2.setEnabled(false);

        Solo.bVariante3 = new JButton("Variante 3");
        bVariante3.addActionListener(listener);
        bVariante3.setEnabled(false);


        Solo.logo = new JLabel(new ImageIcon("data/zenlogo"));

        this.setLayout(null);

        //ON organise le placement
        logo.setBounds(590, 60, 100, 100);
        title.setBounds(440,180,400,70);

        difficulty.setBounds(170, 270, 320, 70);
        bEasy.setBounds(420, 307, 170, 50);
        bMedium.setBounds(630, 307, 170, 50);
        bHard.setBounds(840, 307, 170, 50);
        config.setBounds(400, 500, 470, 70);

        variante.setBounds(190 ,390, 170, 70);
        bBase.setBounds(420, 400, 120, 50);
        bVariante1.setBounds(590, 400, 120, 50);
        bVariante2.setBounds(760, 400, 120, 50);
        bVariante3.setBounds(930, 400, 120, 50);

        enterName.setBounds(190, 460, 265, 70);
        name.setBounds(400, 480, 200, 30);

        bQuitter.setBounds(390,550,230,100);

        bJouer.setBounds(660,550,230,100);


        this.add(title);

        this.add(difficulty);
        this.add(bEasy);
        this.add(bMedium);
        this.add(bHard);
        this.add(config);

        this.add(variante);
        this.add(bBase);
        this.add(bVariante1);
        this.add(bVariante2);
        this.add(bVariante3);

        this.add(bQuitter);
        this.add(bJouer);

        this.add(enterName);
        this.add(name);



    }

}