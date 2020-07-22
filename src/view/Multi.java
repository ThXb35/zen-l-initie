package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.multi.MultiLabelUI;

import javafx.scene.text.Font;
import listener.MultiListener;

public class Multi extends JPanel{
    
    public static JLabel team;
    public static JLabel mode;
    public static JLabel title;
    public static JLabel logo;
    public static JLabel config;
    public static JLabel enterName1;
    public static JLabel enterName2;

    public static JButton bSameComputer;
    public static JButton bLocal;
    public static JButton bReseau;
    public static JButton bTournoi;
    public static JButton b1V1;
    public static JButton b2V2;

    public static JTextField name1;
    public static JTextField name2;

    public static JButton bJouer;
    public static JButton bQuitter;






    public Multi(){

        initComponents();

    }

    public void initComponents(){
        
        MultiListener listen = new MultiListener();

        //On initialise les attributs
        Multi.enterName1 = new JLabel("Pseudo du joueur 1");
        enterName1.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        Multi.enterName2 = new JLabel("Pseudo du joueur 1");
        enterName2.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        name1 = new JTextField();
        name2 = new JTextField();

        this.mode = new JLabel("Choix du mode");
        mode.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        this.team = new JLabel("Choix des equipes");
        team.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        Multi.config = new JLabel("Configuration actuelle : ");
        config.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));

        this.title = new JLabel("Jouer en multijoueurs");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,45));

        this.bQuitter = new JButton("Quitter");
        this.bQuitter.addActionListener(listen);

        this.bJouer = new JButton("Jouer");
        this.bJouer.addActionListener(listen);

        this.b1V1 = new JButton("1 contre 1");
        this.b1V1.addActionListener(listen);

        this.b2V2 = new JButton("2 contre 2");
        this.b2V2.addActionListener(listen);
        b2V2.setEnabled(false);
        

        this.bSameComputer = new JButton("Meme ordinateur");
        this.bSameComputer.addActionListener(listen);


        this.bLocal = new JButton("Local");
        this.bLocal.addActionListener(listen);
        bLocal.setEnabled(false);

        this.bReseau = new JButton("Reseau");
        this.bReseau.addActionListener(listen);
        bReseau.setEnabled(false);

        this.bTournoi = new JButton("Tournoi");
        this.bTournoi.addActionListener(listen);
        bTournoi.setEnabled(false);

        this.logo = new JLabel(new ImageIcon("data/zenlogo.png"));

        this.setLayout(null);

        //ON organise le placement
        logo.setBounds(590, 20, 100, 100);
        title.setBounds(340,130,600,70);

        enterName1.setBounds(190, 380, 265, 70);
        enterName2.setBounds(190, 430, 265, 70);

        name1.setBounds(500, 400, 200, 30);
        name2.setBounds(500, 460, 200, 30);



        team.setBounds(170, 200, 300, 70);
        b1V1.setBounds(420, 207, 200, 50);
        b2V2.setBounds(630, 207, 200, 50);
        
        config.setBounds(400, 500, 470, 70);


        mode.setBounds(190,300,300,70);
        bSameComputer.setBounds(420, 300, 150, 50);
        bLocal.setBounds(590, 300, 150, 50);
        bReseau.setBounds(760, 300, 150, 50);
        bTournoi.setBounds(930, 300, 150, 50);

        bQuitter.setBounds(390,550,230,100);

        bJouer.setBounds(660,550,230,100);


        this.add(title);

        this.add(team);
        this.add(b1V1);
        this.add(b2V2);

        this.add(mode);
        this.add(bSameComputer);
        this.add(bLocal);
        this.add(bReseau);
        this.add(bTournoi);

        this.add(enterName1);
        this.add(enterName2);

        this.add(logo);

        this.add(config);

        this.add(bQuitter);
        this.add(bJouer);

        this.add(name1);
        this.add(name2);



    }

}