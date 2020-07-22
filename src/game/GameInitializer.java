package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 * @author Herard Thibault
 * Initialize the game
 */
public class GameInitializer {

	private Display display;
	public static GamePlay gamePlay;
	private int variante;
	private Mode mode;
	private ArrayList<Pawn> pawns;
	private int LINES = 11;
	private int COLUMNS = 11;

	/**
	 * Constructor of the class, configure a game with a save file.
	 * @param saveFile The savefile to configure
	 */
	public GameInitializer(String saveFile) {
		
	}

	/**
	 * Configure a new game
	 * @param player1 Name of the player one
	 * @param player2 Name of the player two
	 * @param variante The variant of the game
	 * @param mode The mode of the game (Multiplayer or not)
	 * @param display The way to display the game
	 * @param botDifficulty the difficulty of the bot
	 */
	public GameInitializer(String player1, String player2, int variante, Mode mode, Display display, Difficulty botDifficulty) {

		this.mode = mode;
		this.display = display;

		this.gamePlay = new GamePlay(player1, player2, variante, mode, botDifficulty, display);


		
	}

	/**
	 * Print some information about the game
	 * @return a string with the informations
	 */
	public String toString() {

		String gameInitializer = ("The game mode is " + this.mode + " and the variante is " + this.variante);
		return gameInitializer;

	}

	/**
	 * This method allow to read the saved game
	 */
	public static void readSaves() {
		ObjectInputStream ois = null;

    	try {
      		final FileInputStream fichier = new FileInputStream("data/GamePlay.ser");
			  ois = new ObjectInputStream(fichier);
			  
			final GamePlay gamePlaySave = (GamePlay) ois.readObject();
			final Board boardSave = (Board) ois.readObject();
			final Player player1Save = (Player) ois.readObject();
			final Player player2Save = (Player) ois.readObject();
			final Player currentSave = (Player) ois.readObject();
			final Display displaySave = (Display) ois.readObject();
			final JFrame menuSave = (JFrame) ois.readObject();
			final JTable tableauSave = (JTable) ois.readObject();
			final JFrame gameSave = (JFrame) ois.readObject();
			final Mode modeSave = (Mode) ois.readObject();
			final Pawn[][] pawnSave = (Pawn[][]) ois.readObject();

			

			GameInitializer.gamePlay = gamePlaySave;
			GameInitializer.gamePlay.board = boardSave;
			GameInitializer.gamePlay.player1 = player1Save;
			GameInitializer.gamePlay.player2 = player2Save;
			GameInitializer.gamePlay.current = currentSave;
			GameInitializer.gamePlay.display = displaySave;
			GameInitializer.gamePlay.fenetreMenu = menuSave;
			GameInitializer.gamePlay.fenetreGame = gameSave;
			GameInitializer.gamePlay.tableau = tableauSave;
			GameInitializer.gamePlay.mode = modeSave;
			GameInitializer.gamePlay.board.board = pawnSave;

			

			GameInitializer.gamePlay.start();





      		
    	} catch (final java.io.IOException e) {
      		e.printStackTrace();
    	} catch (final ClassNotFoundException e) {
      		e.printStackTrace();
    	} finally {	
      		try {
        		if (ois != null) {
         			ois.close();
        		}
      		} catch (final IOException ex) {
        ex.printStackTrace();
      }
	}
  }

	

}