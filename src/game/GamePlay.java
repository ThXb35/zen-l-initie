package game;

import java.awt.Dimension;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import view.Solo;
import view.Game;
import view.ImageCellRenderer;
import view.Menu;
import view.Multi;
import view.Saves;

/**
 * @author Herard Thibault The class which control all the game
 */
public class GamePlay implements Serializable {

	public static Board board;
	public static Player current;
	public static Player player2;
	public static Player player1;
	public static int variante;
	public static int numberOfMove;
	public static Display display;
	public static JFrame fenetreMenu;
	public static JTable tableau;
	public static JFrame fenetreGame;
	public static Mode mode;

	/**
	 * Constructor of the class Create two players (HH, AA, AH) An arraylist with
	 * all the pawns
	 * 
	 * @param player1       The name of the first player
	 * @param player2       The name of the second player
	 * @param variante      The variant
	 * @param mode          The mode
	 * @param botDifficulty The difficulty of the bot
	 * @param display       The display mode
	 */
	public GamePlay(String player1, String player2, int variante, Mode mode, Difficulty botDifficulty,
			Display display) {

		this.display = display;
		this.variante = variante;
		this.mode = mode;

		Board gameBoard = new Board();
		this.board = gameBoard;

		this.numberOfMove = 0;

		if (mode == Mode.HH) {

			this.player1 = new HumanPlayer(player1, "WHITE");
			this.player2 = new HumanPlayer(player2, "BLACK");

		} else if (mode == Mode.HA) {

			this.player1 = new HumanPlayer(player1, "WHITE");
			this.player2 = new AutoPlayer(player2, "BLACK", botDifficulty);

		} else if (mode == Mode.AA) {

			this.player1 = new AutoPlayer(player1, "WHITE", botDifficulty);
			this.player2 = new AutoPlayer(player2, "BLACK", botDifficulty);

		}

		this.start();

	}

	/**
	 * Return the current player
	 * 
	 * @return the current player
	 */
	public Player getCurrent() {

		return this.current;

	}

	/**
	 * Return the first player
	 * 
	 * @return the first player
	 */
	public Player getPlayer1() {

		return this.player1;

	}

	/**
	 * Return the second player
	 * 
	 * @return the second player
	 */
	public Player getPlayer2() {

		return this.player2;

	}

	/**
	 * Ask the player to make a move
	 */
	public void askPawnMoveShell() {

		int xPawnCord = 0;
		int yPawnCord = 0;
		int xPlaceCord = 0;
		int yPlaceCord = 0;

		boolean verifMove = false;
		while (!verifMove) {

			boolean verifValue = false;
			while (!verifValue) {

				verifValue = true;
				try {

					Scanner sc = new Scanner(System.in);

					this.board.printBoard();
					System.out.println("\n");
					System.out.println("Selectionner un pion");
					System.out.println("");
					System.out.println("Entrez des coordonnees X = ");
					xPawnCord = sc.nextInt();
					System.out.println("");
					System.out.println("Entrez des ooordonnees Y = ");
					yPawnCord = sc.nextInt();

					if(xPawnCord == 99 || yPawnCord == 99){

						System.out.println("Partie quitte et enregistre");
						this.save();
						System.exit(1);

					}

					if (xPawnCord > 11 || xPawnCord < 0 || yPawnCord < 0 || xPawnCord > 11) {

						verifValue = false;

					}

					if (this.board.selectPawn(xPawnCord, yPawnCord).getColor() != this.current.getColor()
							&& this.board.selectPawn(xPawnCord, yPawnCord).getColor() != Color.ZEN) {

						verifValue = false;
						System.out.println("Ce pion appartient a l adversaire !");

					}

				} catch (InputMismatchException e) {

					System.out.println("Veuillez rentrer une valeur entiere");
					verifValue = false;

				} catch (NullPointerException e) {

					System.out.println("Il n'y a pas de pions sur cette case");
					verifValue = false;

				} catch (IndexOutOfBoundsException e) {

					System.out.println("Veuillez choisir des valeurs dans le tableau");
					verifValue = false;

				}
			}
			boolean verifPlace = false;
			while (!verifPlace) {

				verifPlace = true;
				try {

					Scanner sc = new Scanner(System.in);

					System.out.println("\n");
					System.out.println("Selectionnez une case");
					System.out.println("");
					System.out.println("Coordonnée X");
					xPlaceCord = sc.nextInt();
					System.out.println("");
					System.out.println("Coordonnée Y");
					yPlaceCord = sc.nextInt();

				} catch (InputMismatchException e) {

					System.out.println("Veuillez rentrer une valeur entiere");
					verifPlace = false;

				}
			}

			// On verifie que le deplacement est conforme aux regles
			Pawn currentPawn = this.board.selectPawn(xPawnCord, yPawnCord);
			Direction shotDirection = this.analyzeDirection(xPawnCord, yPawnCord, xPlaceCord, yPlaceCord);
			Line shotLine = this.analyzeLine(xPawnCord, yPawnCord, xPlaceCord, yPlaceCord);
			int distance = 0;

			if (shotLine == Line.VERT) {

				distance = Math.abs(xPawnCord - xPlaceCord);

			} else {

				distance = Math.abs(yPawnCord - yPlaceCord);

			}

			if (this.board.isValid(currentPawn, shotDirection, distance, shotLine)) {

				// Le placement est valide !
				verifMove = true;

				this.playerMove(currentPawn, xPlaceCord, yPlaceCord);

			} else {

				verifMove = false;
				System.out.println("Tu ne peux pas te déplacer ici");

			}

		}

	}

	/**
	 * Ask the IA to make a move
	 */
	public void askPawnMoveShellIA() {

		int xPawnCord = 0;
		int yPawnCord = 0;
		int xPlaceCord = 0;
		int yPlaceCord = 0;

		boolean verifMove = false;
		boolean verifPawn = false;
		boolean verifSame = false;

		Pawn p = null;

		int[][] validMove = null;

		while (!verifPawn) {

			int random = (int) (Math.random() * this.board.pawns.size());
			p = this.board.pawns.get(random);

			if (p != null && p.getColor() == current.getColor()) {

				verifPawn = true;
				xPawnCord = p.getX();
				yPawnCord = p.getY();

			}

		}

		while (!verifSame) {
			int random1 = (int) (Math.random() * this.board.validMoves(p).size());
			validMove = this.board.validMoves(p).get(random1);
			if ((validMove[0][0] != p.getX() || validMove[0][1] != p.getY())
					&& (validMove[0][0] >= 0 && validMove[0][0] < 11 && validMove[0][1] > 0 && validMove[0][1] < 11)) {

				verifSame = true;

			}

		}

		this.playerMove(p, validMove[0][0], validMove[0][1]);

		if (this.mode == Mode.HA) {
			System.out.println("Le robot a bouge le pion (" + xPawnCord + ";" + yPawnCord + ") en  (" + validMove[0][0]
					+ ";" + validMove[0][1] + ")");
		}

	}

	/**
	 * Ask the player to make a move
	 */
	public void askPawnMoveGraphic() {

		int xPawnCord = 0;
		int yPawnCord = 0;
		int xPlaceCord = 0;
		int yPlaceCord = 0;

		boolean verifMove = false;

		while (!verifMove) {

			boolean verifValue = false;

			while (!verifValue) {

				verifValue = true;
				try {
					xPawnCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Selectionnez le x de votre pion"));
					yPawnCord = Integer.parseInt(JOptionPane.showInputDialog(null, "Selectionnez le y de votre pion"));

					if (xPawnCord > 11 || xPawnCord < 0 || yPawnCord < 0 || xPawnCord > 11) {

						JOptionPane.showMessageDialog(null, "Veuillez choisir des valeurs dans le tableau", "Erreur",
								JOptionPane.PLAIN_MESSAGE);
						verifValue = false;

					}

					if (this.board.selectPawn(xPawnCord, yPawnCord).getColor() != this.current.getColor()
							&& this.board.selectPawn(xPawnCord, yPawnCord).getColor() != Color.ZEN) {

						verifValue = false;
						JOptionPane.showMessageDialog(null, "Ce pion appartient à l'adversaire", "Erreur",
								JOptionPane.PLAIN_MESSAGE);
					}
				} catch (NullPointerException e) {

					verifValue = false;
					JOptionPane.showMessageDialog(null, "Il n'y a pas de pion sur cette case", "Erreur",
							JOptionPane.PLAIN_MESSAGE);

				} catch (NumberFormatException f) {

					verifValue = false;
					JOptionPane.showMessageDialog(null, "Veuillez rentrer des valeurs numériques", "Erreur",
							JOptionPane.PLAIN_MESSAGE);

				}
			}
			boolean verifPlace = false;
			while (!verifPlace) {

				verifPlace = true;
				try {
					xPlaceCord = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Selectionnez le x de la case ou vous voulez deplacer le pion"));
					yPlaceCord = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Selectionnez le x de la case ou vous voulez deplacer le pion"));
				} catch (NumberFormatException g) {

					verifPlace = false;
					JOptionPane.showMessageDialog(null, "Veuiller rentrer des valeurs numeriques", "Erreur",
							JOptionPane.PLAIN_MESSAGE);

				}
			}

			// On verifie que le deplacement est conforme aux regles
			Pawn currentPawn = this.board.selectPawn(xPawnCord, yPawnCord);
			Direction shotDirection = this.analyzeDirection(xPawnCord, yPawnCord, xPlaceCord, yPlaceCord);
			Line shotLine = this.analyzeLine(xPawnCord, yPawnCord, xPlaceCord, yPlaceCord);
			int distance = 0;

			if (shotLine == Line.VERT) {

				distance = Math.abs(xPawnCord - xPlaceCord);

			} else {

				distance = Math.abs(yPawnCord - yPlaceCord);

			}

			if (this.board.isValid(currentPawn, shotDirection, distance, shotLine)) {

				// Le placement est valide !
				verifMove = true;

				this.playerMove(currentPawn, xPlaceCord, yPlaceCord);

			} else {

				verifMove = false;
				JOptionPane.showMessageDialog(null, "Tu ne peux pas te deplacer ici", "Information",
						JOptionPane.PLAIN_MESSAGE);

			}

		}

	}

	/**
	 * Start the game
	 */
	public void start() {

		this.current = this.player1;

		if (this.display == Display.SHELL) {

			while (!this.board.isAligned(Color.WHITE) && !this.board.isAligned(Color.BLACK)) {

				System.out.println("Au tour de " + this.current.getName() + " | Color = " + this.current.getColor());
				System.out.println("Black = O");
				System.out.println("White = X");

				// JOptionPane.showMessageDialog(null, "Au tour de " + current.getName(),
				// "Information",JOptionPane.PLAIN_MESSAGE);

				if (this.current.getName().equals("Robot")) {

					this.askPawnMoveShellIA();

				} else {

					this.askPawnMoveShell();

				}

				this.changeCurrent();
				this.save();

			}
		}

		if (this.display == Display.GRAPHIC) {

			Game game = new Game();

			fenetreGame = new JFrame("Jeu");
			fenetreGame.setPreferredSize(new Dimension(1280, 720));
			fenetreGame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			fenetreGame.setVisible(true);
			fenetreGame.pack();
			fenetreGame.add(game);

			while (!this.board.isAligned(Color.WHITE) && !this.board.isAligned(Color.BLACK)) {
				

				Pawn[][] pawns = this.board.getBoard();
				Object[][] donnees = new ImageIcon[11][11];

				String[] entete = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

				// On initialise les pions
				for (int i = 0; i < 11; i++) {

					for (int j = 0; j < 11; j++) {

						if (pawns[i][j] == null) {

							donnees[i][j] = new ImageIcon("data/empty.png");

						} else {

							if (pawns[i][j].getColor() == Color.WHITE) {

								donnees[i][j] = new ImageIcon("data/white.png");

							} else if (pawns[i][j].getColor() == Color.BLACK) {

								donnees[i][j] = new ImageIcon("data/black.png");

							} else if (pawns[i][j].getColor() == Color.ZEN) {

								donnees[i][j] = new ImageIcon("data/zen.png");
							}
						}
					}
				}

				GamePlay.tableau = new JTable(donnees, entete);

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

				Game.tableau = GamePlay.tableau;

				Game.infoTurn.setText("Au tour de " + current.getName() + " ( Couleur " + current.getColor() + " ) ");

				JOptionPane.showMessageDialog(null, "Au tour de " + current.getName(), "Information",
						JOptionPane.PLAIN_MESSAGE);

				if (this.current.getName().equals("Robot")) {

					this.askPawnMoveShellIA();

				} else {

					this.askPawnMoveGraphic();
				}

				fenetreGame.setVisible(false);

				game = new Game();
				fenetreGame = new JFrame("Jeu");
				fenetreGame.setPreferredSize(new Dimension(1280, 720));
				fenetreGame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
				fenetreGame.setVisible(true);
				fenetreGame.pack();
				fenetreGame.add(game);

				Object[] options = { "Continuer", "Sauvegarder et quitter" };
				int affichage = JOptionPane.showOptionDialog(null, "Que voulez vous faire ?", "Warning", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);

				if(affichage == 1){

					this.save();
					this.fenetreGame.setVisible(false);
					System.exit(1);

				}
				this.changeCurrent();

			}

		}

	}

	/**
	 * Return the grid
	 * 
	 * @return the grid
	 */

	/**
	 * End the game
	 */
	public void end() {

	}

	/**
	 * Guess the direction of a move
	 * 
	 * @param oldX The old x position
	 * @param oldY The old y position
	 * @param newX The new x position
	 * @param newY The new y position
	 * @return the direction analyzed
	 */
	public Direction analyzeDirection(int oldX, int oldY, int newX, int newY) {

		Direction result = null;

		if (newX > oldX && newY > oldY) {

			result = Direction.SE;

		} else if (newX > oldX && newY < oldY) {

			result = Direction.SW;

		} else if (newX < oldX && newY < oldY) {

			result = Direction.NW;

		} else if (newX < oldX && newY > oldY) {

			result = Direction.NE;

		} else if (newX == oldX && newY < oldY) {

			result = Direction.W;

		} else if (newX == oldX && newY > oldY) {

			result = Direction.E;

		} else if (newY == oldY && newX < oldX) {

			result = Direction.N;

		} else if (newY == oldY && newX > oldX) {

			result = Direction.S;

		}

		return result;

	}

	/**
	 * Guess the line of a move
	 * 
	 * @param oldX The old X of the pawn
	 * @param oldY The old Y of the pawn
	 * @param newX The new X ccordinate of the pawn
	 * @param newY The new X ccordinate of the pawn
	 * @return the line analyzed
	 */
	public Line analyzeLine(int oldX, int oldY, int newX, int newY) {

		Line result = null;

		if ((newX > oldX && newY > oldY) || (newX < oldX && newY < oldY)) {

			result = Line.DIAGGD;

		} else if ((newX > oldX && newY < oldY) || (newX < oldX && newY > oldY)) {

			result = Line.DIAGDG;

		} else if ((newX == oldX && newY < oldY) || (newX == oldX && newY > oldY)) {

			result = Line.HORI;

		} else if ((newY == oldY && newX < oldX) || (newY == oldY && newX > oldX)) {

			result = Line.VERT;

		}

		return result;

	}

	/**
	 * Save the game
	 */
	public void save() {

		ObjectOutputStream oos = null;

		try {

			final FileOutputStream fichier = new FileOutputStream("data/GamePlay.ser");
			oos = new ObjectOutputStream(fichier);

			
			oos.writeObject(this);
			oos.writeObject(this.board);
			oos.writeObject(this.player1);
			oos.writeObject(this.player2);
			oos.writeObject(this.current);
			oos.writeObject(this.display);
			oos.writeObject(this.fenetreMenu);
			oos.writeObject(this.tableau);
			oos.writeObject(this.fenetreGame);
			oos.writeObject(this.mode);
			oos.writeObject(this.board.getBoard());



			
		} catch (final java.io.IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (oos != null) {
					oos.flush();
					oos.close();
				}

			} catch (final IOException ex) {

				ex.printStackTrace();

			}
		}

	}

	/**
	 * Allow a player to make a move
	 * 
	 * @param p The pawn to move
	 * @param x La position X
	 * @param y La position Y
	 */
	public void playerMove(Pawn p, int x, int y) {

		// On empeche le joueur suivant de bouger le pion ZEN au meme endroit
		if (p.getColor() == Color.ZEN) {

			this.board.setLastZenPosition(p.getX(), p.getY());
			this.board.setIsZenLastMove(true);

		} else {

			this.board.setIsZenLastMove(false);

		}

		// Si il y a un pion sur la case ou on veut déplacer notre pion
		if (this.board.getBoard()[x][y] != null) {

			// Si le pion appartient à l'adversaire, on le capture
			if (this.board.getBoard()[x][y].getColor() != p.getColor()) {

				this.board.decrPawnNumber(this.board.getBoard()[p.getX()][p.getY()].getColor());
				this.board.getBoard()[p.getX()][p.getY()] = null;
				this.board.getBoard()[x][y] = p;
				this.board.pawns.remove(this.board.selectPawn(x, y));

			}

			// Si le case est vide
		} else {

			this.board.getBoard()[p.getX()][p.getY()] = null;
			this.board.getBoard()[x][y] = p;
			this.board.getBoard()[x][y].move(x, y);

		}

	}

	/**
	 * Change the current player
	 */
	public void changeCurrent() {

		if (this.current == this.player1) {

			this.current = this.player2;

		} else if (this.current == this.player2) {

			this.current = player1;

		}

	}

}