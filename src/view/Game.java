package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;

import game.Board;
import game.Color;
import game.Pawn;
import listener.GameListener;

public class Game extends JPanel {
    
    public static JButton bBack;
    public static JButton bPlay;

    public static JLabel info;
    public static JTable plateau;
    public static JTable tableau;

    public static JTextField xPawn;
    public static JTextField yPawn;

    public static JTextField xCase;
    public static JTextField yCase;

    public static JButton bSave;
    public static JButton bQuitter;

    public static JLabel logo;

    public static JLabel infoTurn;

    public static JLabel infoPlay;


    public Game(){

        initComponents();

    }

    public void initComponents(){

        Game.xCase = new JTextField();
        Game.yCase = new JTextField();

        Game.xPawn = new JTextField();
        Game.yPawn = new JTextField();

        Game.logo = new JLabel(new ImageIcon("data/zenlogo.png"));

        Game.infoTurn = new JLabel(" ");
        Game.infoPlay = new JLabel("");

        Game.bSave = new JButton("Sauvegarder la partie");
        Game.bQuitter = new JButton("Quitter la partie");


        Game.bBack = new JButton("<");
        Game.bPlay = new JButton("JOUER !");

        Game.info = new JLabel("");


        Pawn[][] pawns = Board.board;
        Object[][]donnees = new ImageIcon[11][11];

        String[] entete =  {"0","1","2","3","4","5","6","7","8","9","10"};

        


        //On initialise les pions
        for(int i = 0 ; i < 11 ; i++){

            for(int j = 0 ; j < 11 ; j++){

                if(pawns[i][j] == null){

                    donnees[i][j] = new ImageIcon("data/empty.png");

                }else{

                    if(pawns[i][j].getColor() == Color.WHITE){

                        donnees[i][j] = new ImageIcon("data/white.png");


                    }else if(pawns[i][j].getColor() == Color.BLACK){

                        donnees[i][j] = new ImageIcon("data/black.png");

                    }else if(pawns[i][j].getColor() == Color.ZEN){

                        donnees[i][j] = new ImageIcon("data/zen.png");
                    }
                }
            }
        }

        this.setLayout(null);

        this.tableau = new JTable(donnees, entete);

        tableau.getColumnModel().getColumn(0).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(1).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(2).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(3).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(4).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(5).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(6).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(7).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(8).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(9).setCellRenderer(new ImageCellRenderer());
        tableau.getColumnModel().getColumn(10).setCellRenderer(new ImageCellRenderer());

        tableau.getColumnModel().getColumn(0).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(1).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(2).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(3).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(4).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(5).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(6).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(7).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(8).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(9).setPreferredWidth(35);
        tableau.getColumnModel().getColumn(10).setPreferredWidth(35);
     



        tableau.setRowHeight(35); 
        
        bSave.setBounds(900, 296, 200,50);

        bQuitter.setBounds(900, 354, 200,50);
        bQuitter.addActionListener(new GameListener());

        logo.setBounds(200, 220, 100, 100);

        infoTurn.setBounds(540, 50, 300, 20);
        infoTurn.setFont(new java.awt.Font("Arial",java.awt.Font.BOLD,15));
        infoPlay.setBounds(730, 630, 200, 20);


        tableau.setBounds(447, 117, 385, 385);
        bBack.setBounds(40, 40,40, 40);

        this.add(bBack);

        this.add(infoTurn);

        this.add(logo);

        this.add(tableau);
        

    }

}