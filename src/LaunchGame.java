import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import game.Difficulty;
import game.Display;
import game.GameInitializer;
import game.GamePlay;
import game.Mode;

import view.Saves;
import view.Game;
import view.Menu;

/**
 * @author Herard Thibault
 * The launcher of the game
 */
public class LaunchGame{

	/**
	 * The main class, it creates an GameInitialize object
	 * @param args The args of the command
	 */

	private String name1;
	private String name2;
	public static int variante;
	public static Mode mode;
	public static Display display;
	public static Difficulty difficulty;
	public static JFrame fenetreMenu;


	public static void main(String[] args) {

		Object[] options = { "Graphique", "Console" };
		int affichage = JOptionPane.showOptionDialog(null, "Mode d'affichage ?", "Warning", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);

		if (affichage == 0) {

			LaunchGame.display = Display.GRAPHIC;

			Menu menu = new Menu();
			fenetreMenu = new JFrame("Menu");
			
        	fenetreMenu.setPreferredSize(new Dimension(1280, 720));
        	fenetreMenu.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        	fenetreMenu.setVisible(true);
        	fenetreMenu.pack();
			fenetreMenu.add(menu);

		} else if (affichage == 1) {

			LaunchGame.display = Display.SHELL;
			System.out.println("#########################################################################");
			System.out.println("  ____________ _   _   _      _ _____ _   _ _____ _______ _____ ______ ");
			System.out.println("|___  /|  ____| \\ | | | |    ( )_   _| \\ | |_   _|__   __|_   _|  ____|");
			System.out.println("    / /| |__  |  \\| | | |    |/  | | |  \\| | | |    | |    | | | |__   ");
			System.out.println("   / / |  __| | . ` | | |        | | | . ` | | |    | |    | | |  __|  ");
			System.out.println("  / /__| |____| |\\  | | |____   _| |_| |\\  |_| |_   | |   _| |_| |____ ");
			System.out.println(" /_____|______|_| \\_| |______| |_____|_| \\_|_____|  |_|  |_____|______|");
			System.out.println("");
			System.out.println("Par Herard Thibault");
			System.out.println("#########################################################################");
			System.out.println("");
			System.out.println("Selectionnez une option :");
			System.out.println("");
			System.out.println("1. Solo");
			System.out.println("2. Multijoueurs");
			System.out.println("3. Restaurer la sauvegarde");
			System.out.println("4. Option (Pas encore disponible)");
			System.out.println("5. Statistiques (Pas encore disponible)");
			System.out.println("6. QUitter");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch (choice) {

				case 1:
					LaunchGame.mode = Mode.HA;

					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("#########################################################################");
					System.out.println("  ____________ _   _   _      _ _____ _   _ _____ _______ _____ ______ ");
					System.out.println("|___  /|  ____| \\ | | | |    ( )_   _| \\ | |_   _|__   __|_   _|  ____|");
					System.out.println("    / /| |__  |  \\| | | |    |/  | | |  \\| | | |    | |    | | | |__   ");
					System.out.println("   / / |  __| | . ` | | |        | | | . ` | | |    | |    | | |  __|  ");
					System.out.println("  / /__| |____| |\\  | | |____   _| |_| |\\  |_| |_   | |   _| |_| |____ ");
					System.out.println(" /_____|______|_| \\_| |______| |_____|_| \\_|_____|  |_|  |_____|______|");
					System.out.println("");
					System.out.println("Par Herard Thibault");
					System.out.println("#########################################################################");
					System.out.println("");
					System.out.println("Mode de jeu selectionne : Solo");
					System.out.println("");
					System.out.println("Selectionnez le pseudo du joueur");
					
					Scanner sc1 = new Scanner(System.in);
					String name1 = sc1.nextLine();

					System.out.println("");
					System.out.println("");
					System.out.println("Selectionnez la difficulte");
					System.out.println("");
					System.out.println("1. Facile");
					System.out.println("2. Moyen (Pas encore disponible)");
					System.out.println("3. Difficile (Pas encore disponible)");

					int diff = sc.nextInt();

					if (diff == 1) {

						LaunchGame.difficulty = Difficulty.EASY;
						System.out.println("########################");
						System.out.println("Vous avez choisis FACILE");
						System.out.println("########################");

					} else if (diff == 2) {

						LaunchGame.difficulty = Difficulty.MEDIUM;
						System.out.println("#######################");
						System.out.println("Vous avez choisis MOYEN");
						System.out.println("#######################");

					} else if (diff == 3) {

						LaunchGame.difficulty = Difficulty.HARD;
						System.out.println("###########################");
						System.out.println("Vous avez choisis DIFFICILE");
						System.out.println("###########################");

					}

					System.out.println("");
					System.out.println("Selectionnez la variante de jeu");
					System.out.println("");
					System.out.println("1. Jeu de base");
					System.out.println("2. Variante 1");
					System.out.println("3. Variante 2");
					System.out.println("4. Variante 3");
					System.out.println("");
					int vari = sc.nextInt();

					if (vari == 1) {

						LaunchGame.variante = 4;
						System.out.println("#############################");
						System.out.println("Vous avez choisis JEU DE BASE");
						System.out.println("#############################");


					}else if(vari == 2){

						LaunchGame.variante = 1;
						System.out.println("############################");
						System.out.println("Vous avez choisis VARIANTE 1");
						System.out.println("############################");

					}else if(vari == 3){

						LaunchGame.variante = 2;
						System.out.println("############################");
						System.out.println("Vous avez choisis VARIANTE 2");
						System.out.println("############################");

					}else if(vari == 4){

						LaunchGame.variante = 3;
						System.out.println("############################");
						System.out.println("Vous avez choisis VARIANTE 3");
						System.out.println("############################");

					}

					
					
					new GameInitializer(name1, "Robot", variante, mode, display, difficulty);


				case 2:
					LaunchGame.mode = Mode.HH;

					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("");
					System.out.println("#########################################################################");
					System.out.println("  ____________ _   _   _      _ _____ _   _ _____ _______ _____ ______ ");
					System.out.println("|___  /|  ____| \\ | | | |    ( )_   _| \\ | |_   _|__   __|_   _|  ____|");
					System.out.println("    / /| |__  |  \\| | | |    |/  | | |  \\| | | |    | |    | | | |__   ");
					System.out.println("   / / |  __| | . ` | | |        | | | . ` | | |    | |    | | |  __|  ");
					System.out.println("  / /__| |____| |\\  | | |____   _| |_| |\\  |_| |_   | |   _| |_| |____ ");
					System.out.println(" /_____|______|_| \\_| |______| |_____|_| \\_|_____|  |_|  |_____|______|");
					System.out.println("");
					System.out.println("Par Herard Thibault");
					System.out.println("#########################################################################");
					System.out.println("");
					System.out.println("Mode de jeu selectionne : Multi");
					System.out.println("");
					System.out.println("Selectionnez un mode multijoueur");
					System.out.println("");
					System.out.println("1. Meme machine");
					System.out.println("2. Reseau (Pas encore disponible)");
					System.out.println("3. Tournoi (Pas encore disponible)");
					System.out.println("3. Local (Pas encore disponible)");


					int multi = sc.nextInt();

					if(multi == 1){

						System.out.println("");
						System.out.println("Selectionnez le pseudo du premier joueur");
						System.out.println("");
						Scanner sc2 = new Scanner(System.in);
						name1 = sc2.nextLine();
						System.out.println("");
						System.out.println("Selectionnez le pseudo du deuxieme joueur");
						System.out.println("");
						Scanner sc3 = new Scanner(System.in);
						String name2 = sc3.nextLine();

						new GameInitializer(name1, name2, variante, mode, display, difficulty);


					}
				
				case 3:

					System.out.println("Restauration de la sauvegarde en cours");
					GameInitializer.readSaves();
					
					

			}





		}

		

	}

	/**
	 * The method allow us the read the statistic file
	 * @param fileName The statistic file
	 */
	public void readStatistic(String fileName) {
		// TODO - implement LaunchGame.readStatistic
		throw new UnsupportedOperationException();
	}

	
}

