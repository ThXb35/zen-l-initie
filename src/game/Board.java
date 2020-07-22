package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Herard Thibault Simulate the board of the game
 */
public class Board implements Serializable{

	public ArrayList<Pawn> pawns;
	public static Pawn[][] board;
	private int numberWhite;
	private int numberBlack;
	private int numberRed;
	private boolean isZenMove;
	private int[] lastZenPosition;

	/**
	 * Constructor of the class
	 */
	public Board() {

		this.initialCondition();
		this.numberWhite = 12;
		this.numberBlack = 12;
		this.numberRed = 1;
		this.lastZenPosition = new int[2];

	}

	/**
	 * Set the last position of the zen pawn
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public void setLastZenPosition(int x, int y) {

		this.lastZenPosition[0] = x;
		this.lastZenPosition[1] = y;

	}

	/**
	 * Get the last position of the zen pawn
	 * 
	 * @return A tab with the coordinates
	 */
	public int[] getLastZenPosition() {

		return this.lastZenPosition;

	}

	/**
	 * Get the number of white pawn
	 * 
	 * @return The number of white pawn
	 */
	public int getNumberWhite() {

		return this.numberWhite;

	}

	/**
	 * Get the number of black pawn
	 * 
	 * @return The number of black pawn
	 */
	public int getNumberBlack() {

		return this.numberBlack;

	}

	/**
	 * Get the number of zen pawn
	 * 
	 * @return The number of zen pawn
	 */
	public int getNumberZen() {

		return this.numberRed;

	}

	/**
	 * Tell if the last pawn moved is the zen pawn
	 * 
	 * @return true if the last pawn moved is the zen pawn
	 */
	public boolean getIsZenLastMove() {

		return this.isZenMove;

	}

	/**
	 * Set that the last pawn moved is the zen
	 * 
	 * @param isZen a boolean
	 */
	public void setIsZenLastMove(boolean isZen) {

		this.isZenMove = isZen;

	}

	/**
	 * Decrement the number of alive panw
	 * 
	 * @param color The color of the pawns
	 */
	public void decrPawnNumber(Color color) {

		if (color == Color.WHITE) {

			this.numberWhite--;

		} else if (color == Color.BLACK) {

			this.numberBlack--;

		} else if (color == Color.ZEN) {

			this.numberRed--;

		}

	}

	/**
	 * This method places all the pawns at the beginning position
	 */
	public void initialCondition() {

		this.board = new Pawn[11][11];
		this.pawns = new ArrayList<Pawn>();

		//////////////////////////////////////////////

		board[0][5] = new Pawn(0, 5, Color.WHITE);
		board[0][10] = new Pawn(0, 10, Color.WHITE);

		board[2][3] = new Pawn(2, 3, Color.WHITE);
		board[2][7] = new Pawn(2, 7, Color.WHITE);

		board[4][1] = new Pawn(4, 1, Color.WHITE);
		board[4][9] = new Pawn(4, 9, Color.WHITE);

		board[6][1] = new Pawn(6, 1, Color.WHITE);
		board[6][9] = new Pawn(6, 9, Color.WHITE);

		board[8][3] = new Pawn(8, 3, Color.WHITE);
		board[8][7] = new Pawn(8, 7, Color.WHITE);

		board[10][0] = new Pawn(10, 0, Color.WHITE);
		board[10][5] = new Pawn(10, 5, Color.WHITE);

		///////////////////////////////////////////////

		board[0][0] = new Pawn(0, 0, Color.BLACK);
		board[10][10] = new Pawn(10, 10, Color.BLACK);

		board[1][4] = new Pawn(1, 4, Color.BLACK);
		board[1][6] = new Pawn(1, 6, Color.BLACK);

		board[3][2] = new Pawn(3, 2, Color.BLACK);
		board[3][8] = new Pawn(3, 8, Color.BLACK);

		board[5][0] = new Pawn(5, 0, Color.BLACK);
		board[5][10] = new Pawn(5, 10, Color.BLACK);

		board[7][2] = new Pawn(7, 2, Color.BLACK);
		board[7][8] = new Pawn(7, 8, Color.BLACK);

		board[9][4] = new Pawn(9, 4, Color.BLACK);
		board[9][6] = new Pawn(9, 6, Color.BLACK);

		//////////////////////////////////////////////

		board[5][5] = new Pawn(5, 5, Color.ZEN);

		/////////////////////////////////////////////

		/////////////////////////////////////////////

		this.pawns.add(new Pawn(0, 5, Color.WHITE));
		this.pawns.add(new Pawn(0, 10, Color.WHITE));

		this.pawns.add(new Pawn(2, 3, Color.WHITE));
		this.pawns.add(new Pawn(2, 7, Color.WHITE));

		this.pawns.add(new Pawn(4, 1, Color.WHITE));
		this.pawns.add(new Pawn(4, 9, Color.WHITE));

		this.pawns.add(new Pawn(6, 1, Color.WHITE));
		this.pawns.add(new Pawn(6, 9, Color.WHITE));

		this.pawns.add(new Pawn(8, 3, Color.WHITE));
		this.pawns.add(new Pawn(8, 7, Color.WHITE));

		this.pawns.add(new Pawn(10, 0, Color.WHITE));
		this.pawns.add(new Pawn(10, 5, Color.WHITE));

		///////////////////////////////////////////////

		this.pawns.add(new Pawn(0, 0, Color.BLACK));
		this.pawns.add(new Pawn(10, 10, Color.BLACK));

		this.pawns.add(new Pawn(1, 4, Color.BLACK));
		this.pawns.add(new Pawn(1, 6, Color.BLACK));

		this.pawns.add(new Pawn(3, 2, Color.BLACK));
		this.pawns.add(new Pawn(3, 8, Color.BLACK));

		this.pawns.add(new Pawn(5, 0, Color.BLACK));
		this.pawns.add(new Pawn(5, 10, Color.BLACK));

		this.pawns.add(new Pawn(7, 2, Color.BLACK));
		this.pawns.add(new Pawn(7, 8, Color.BLACK));

		this.pawns.add(new Pawn(9, 4, Color.BLACK));
		this.pawns.add(new Pawn(9, 6, Color.BLACK));

		//////////////////////////////////////////////

		this.pawns.add(new Pawn(5, 5, Color.ZEN));

		/////////////////////////////////////////////

	}

	/**
	 * Remove a pawn from the board
	 * 
	 * @param x The x coordinate of the pawn that we want to remove
	 * @param y The y coordinate of the pawn that we want to remove
	 */
	public void remove(int x, int y) {

		if (this.selectPawn(x, y).getColor() == Color.BLACK) {

			this.numberBlack--;

		} else if (this.selectPawn(x, y).getColor() == Color.WHITE) {

			this.numberWhite--;

		} else if (this.selectPawn(x, y).getColor() == Color.ZEN) {

			this.numberRed--;

		}

		this.board[x][y] = null;
		for (Pawn p : this.pawns) {

			if (p.getX() == x && p.getY() == y) {

				p = null;
				this.pawns.remove(this.selectPawn(x, y));

			}

		}

	}

	/**
	 * Get the board of the game
	 * 
	 * @return The board
	 */
	public Pawn[][] getBoard() {

		return Board.board;

	}

	/**
	 * Add a pawn to the board
	 * 
	 * @param p The pawn to add
	 */
	public void add(Pawn p) {

		if (p != null) {

			this.board[p.getX()][p.getY()] = p;
			this.pawns.add(p);

		} else {

			System.out.println("The pawn is null");

		}
	}

	/**
	 * It can tell you if the move is valid (out of the board or not) and if there
	 * is an other of your pawn.
	 * 
	 * @param p         The pawn to test the moves
	 * @param direction The direction of the move
	 * @param distance  The number of square to move
	 * @param line      The line where we count the pawn
	 * @return true if the square is valid
	 */
	public boolean isValid(Pawn p, Direction direction, int distance, Line line) {

		boolean isValid = true;
		int newX = p.getX();
		int newY = p.getY();

		if (distance == this.numberOfPawn(line, p)) {

			// On verifie que le déplacement respecte les règles
			switch (direction) {

				case N:
					newX = (p.getX() - distance);
					for (int i = p.getX(); i < newX; i--) {

						if (newX >= 0 && newX < 11 && newY >= 0 && newY < 11) {

							if (Board.board[i][newY] != null) {

								if (Board.board[i][newY].getColor() != p.getColor()
										&& (Board.board[i][newY].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}
							}

						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
					}
					break;

				case S:

					newX = (p.getX() + distance);
					for (int i = p.getX(); i < newX; i++) {

						if (newX >= 0 && newX < 11 && newY >= 0 && newY < 11) {

							if (this.board[i][newY] != null) {

								if (this.board[i][newY].getColor() != p.getColor()
										&& (this.board[i][newY].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}
							}
						} else {
							if(GamePlay.mode == Mode.HH){
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
					}
					break;

				case W:

					newY = (p.getY() - distance);
					for (int i = p.getY(); i < newY; i--) {

						if (newX >= 0 && newX < 11 && newY >= 0 && newY < 11) {

							if (this.board[newX][i] != null) {

								if (this.board[newX][i].getColor() != p.getColor()
										&& (this.board[newX][i].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}
							}
						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
					}

					break;

				case E:

					newY = (p.getY() + distance);
					for (int i = p.getY(); i < newY; i++) {

						if (newX >= 0 && newX < 11 && newY >= 0 && newY < 11) {

							if (this.board[newX][i] != null) {

								if (this.board[newX][i].getColor() != p.getColor()
										&& (this.board[newX][i].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}
							}
						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
					}
					break;

				case NE:

					newX = (p.getX() - distance);
					newY = (p.getX() + distance);

					int a = p.getX();
					int b = p.getY();

					while (a >= newX && b <= newY) {

						if (a >= 0 && a < 11 && b >= 0 && b < 11) {

							if (this.board[a][b] != null) {

								if (this.board[a][b].getColor() != p.getColor()
										&& (this.board[a][b].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}

							}

						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
						b++;
						a--;

					}

					break;

				case NW:

					newX = (p.getX() - distance);
					newY = (p.getY() - distance);

					a = p.getX();
					b = p.getY();

					while (a >= newX && b >= newY) {

						if (a >= 0 && a < 11 && b >= 0 && b < 11) {

							if (this.board[a][b] != null) {

								if (this.board[a][b].getColor() != p.getColor()
										&& (this.board[a][b].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}

							}

						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
						b--;
						a--;

					}

					break;

				case SE:

					newX = (p.getX() + distance);
					newY = (p.getX() + distance);

					a = p.getX();
					b = p.getY();

					while (a <= newX && b <= newY) {

						if (a >= 0 && a < 11 && b >= 0 && b < 11) {

							if (Board.board[a][b] != null) {

								if (Board.board[a][b].getColor() != p.getColor()
										&& Board.board[a][b].getColor() != Color.ZEN) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}

							}

						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
						b++;
						a++;

					}

					break;

				case SW:

					newX = (p.getX() + distance);
					newY = (p.getY() - distance);

					a = p.getX();
					b = p.getY();

					while (a <= newX && b >= newY) {

						if (a >= 0 && a < 11 && b >= 0 && b < 11) {

							if (this.board[a][b] != null) {

								if (this.board[a][b].getColor() != p.getColor()
										&& (this.board[a][b].getColor() != Color.ZEN)) {
									if (GamePlay.mode == Mode.HH) {
										System.out.println("Tu ne peux pas passer au dessus des pions de l'adversaire");
									}
									isValid = false;

								}
							}
						} else {
							if (GamePlay.mode == Mode.HH) {
								System.out.println("La case saisie n'est pas dans le tableau");
							}
							isValid = false;

						}
						b--;
						a++;

					}

					break;
			}

		} else {

			isValid = false;

		}

		// Est ce que la règle du pion zen est respectée ?
		if (p.getColor() == Color.ZEN) {

			if (newX == this.getLastZenPosition()[0] && newY == this.getLastZenPosition()[1] && this.isZenMove) {
				if (GamePlay.mode == Mode.HH) {
					System.out.println("Le pion ZEN ne peut pas etre replace au meme endroit");
				}
				isValid = false;

			}

			int numberCase = 0;
			for (int i = newX - 1; i <= newX + 1; i++) {

				for (int j = newX - 1; j <= newY + 1; j++) {

					if (this.board[i][j] != null) {

						numberCase++;

					}

				}

			}

			if (numberCase == 0) {

				isValid = false;
				if (GamePlay.mode == Mode.HH) {
					System.out.println("Le pion ZEN n'est en contact avec aucun autre pion.");
				}

			}

		}

		return isValid;

	}

	/**
	 * Move a pawn to coordinates
	 * 
	 * @param p The pawn to move
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public void movePawn(Pawn p, int x, int y) {

		this.board[x][y] = p;

	}

	/**
	 * Tell if a case is free
	 * 
	 * @param x The x coordinate
	 * @param y The y coordinate
	 * @return true if the square is free
	 */
	public boolean isFree(int x, int y) {

		boolean free = false;

		if (this.board[x][y] == null) {

			free = true;

		}

		return free;

	}

	/**
	 * Give a tab with valid moves
	 * 
	 * @param p The pawn that we want to check its valid moves
	 * @return A tab with all the valid moves
	 */
	public ArrayList<int[][]> validMoves(Pawn p) {

		int newX = p.getX();
		int newY = p.getY();
		ArrayList<int[][]> validMoves = new ArrayList<int[][]>();

		if (this.isValid(p, Direction.N, this.numberOfPawn(Line.VERT, p), Line.VERT)) {

			newX = (p.getX() - this.numberOfPawn(Line.VERT, p));
			newY = p.getY();

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.S, this.numberOfPawn(Line.VERT, p), Line.VERT)) {

			newX = (p.getX() + this.numberOfPawn(Line.VERT, p));
			newY = p.getY();

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;
			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.E, this.numberOfPawn(Line.HORI, p), Line.HORI)) {

			newY = (p.getY() + this.numberOfPawn(Line.HORI, p));
			newX = p.getX();

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.W, this.numberOfPawn(Line.HORI, p), Line.HORI)) {

			newY = (p.getY() - this.numberOfPawn(Line.HORI, p));
			newX = p.getX();

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.NE, this.numberOfPawn(Line.DIAGDG, p), Line.DIAGDG)) {

			newX = (p.getX() - this.numberOfPawn(Line.DIAGDG, p));
			newY = (p.getY() + this.numberOfPawn(Line.DIAGDG, p));

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.NW, this.numberOfPawn(Line.DIAGGD, p), Line.DIAGGD)) {

			newX = (p.getX() - this.numberOfPawn(Line.DIAGGD, p));
			newY = (p.getY() - this.numberOfPawn(Line.DIAGGD, p));

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.SE, this.numberOfPawn(Line.DIAGGD, p), Line.DIAGGD)) {

			newX = (p.getX() + this.numberOfPawn(Line.DIAGGD, p));
			newY = (p.getY() + this.numberOfPawn(Line.DIAGGD, p));

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		if (this.isValid(p, Direction.SW, this.numberOfPawn(Line.DIAGDG, p), Line.DIAGDG)) {

			newX = (p.getX() + this.numberOfPawn(Line.DIAGDG, p));
			newY = (p.getY() - this.numberOfPawn(Line.DIAGDG, p));

			int[][] valid = new int[1][2];
			valid[0][0] = newX;
			valid[0][1] = newY;

			validMoves.add(valid);

		}

		return validMoves;

	}

	/**
	 * Select a pawn with its coordinate
	 * 
	 * @param x The x-coordonate of the pawn that we want to select
	 * @param y The y-coordonate of the pawn that we want to select
	 * @return the pawn selected
	 */
	public Pawn selectPawn(int x, int y) {

		Pawn p = null;

		if (this.board[x][y] != null) {

			p = this.board[x][y];

		}

		return p;
	}

	/**
	 * return true if all the pawn is align
	 * 
	 * @param color The color of the pawn that we wants to check
	 * @return true if the pawn is align
	 */
	public boolean isAligned(Color color) {

		boolean ret = false;
		ArrayList<int[]> test = new ArrayList<int[]>();
		boolean testAligned = true;
		int[] tab;

		for (Pawn p : this.pawns) {

			if (p.getColor() == color || p.getColor() == Color.ZEN) {

				tab = new int[] { p.getX(), p.getY() - 1 };
				test.add(tab);
				tab = new int[] { p.getX() + 1, p.getY() - 1 };
				test.add(tab);
				tab = new int[] { p.getX() + 1, p.getY() };
				test.add(tab);
				tab = new int[] { p.getX() + 1, p.getY() + 1 };
				test.add(tab);
				tab = new int[] { p.getX(), p.getY() + 1 };
				test.add(tab);
				tab = new int[] { p.getX() - 1, p.getY() + 1 };
				test.add(tab);
				tab = new int[] { p.getX() - 1, p.getY() };
				test.add(tab);
				tab = new int[] { p.getX() - 1, p.getY() - 1 };
				test.add(tab);
			}
		}

		for (Pawn p : this.pawns) {
			if (p.getColor() == color || p.getColor() == Color.ZEN) {
				boolean testPawn = false;
				for (int[] tests : test) {
					if (p.getX() == tests[0] && p.getY() == tests[1]) {
						testPawn = true;
					}
				}
				if (!testPawn) {
					testAligned = false;
				}
			}
		}

		if (testAligned) {
			ret = true;
		}

		return ret;
	}

	/**
	 * It return the number of pawn on a line
	 * 
	 * @param line The line where we can count
	 * @param pawn The pawn selected
	 * @return the number of pawn on the line
	 */
	public int numberOfPawn(Line line, Pawn pawn) {

		int count = 0;

		if (line == Line.HORI) {

			int ligne = pawn.getX();

			for (int i = 0; i < 11; i++) {

				if (this.board[ligne][i] != null) {

					count++;

				}

			}

		} else if (line == Line.VERT) {

			int ligne = pawn.getY();

			for (int i = 0; i < 11; i++) {

				if (this.board[i][ligne] != null) {

					count++;

				}

			}

		} else if (line == Line.DIAGGD) {

			int i = pawn.getX();
			int j = pawn.getY();

			while (i < 11 && j < 11) {

				if (this.board[i][j] != null) {

					count++;

				}

				i++;
				j++;

			}

			i = pawn.getX();
			j = pawn.getY();

			while (i >= 0 && j >= 0) {

				if (this.board[i][j] != null) {

					count++;

				}

				i--;
				j--;

			}

			count--;

		} else if (line == Line.DIAGDG) {

			int i = pawn.getX();
			int j = pawn.getY();

			while (i >= 0 && j < 11) {

				if (this.board[i][j] != null) {

					count++;

				}

				i--;
				j++;

			}

			i = pawn.getX();
			j = pawn.getY();

			while (i < 11 && j >= 0) {

				if (this.board[i][j] != null) {

					count++;

				}

				i++;
				j--;

			}

			count--;

		}

		return count;
	}

	/**
	 * Print the board on the shell
	 */
	public void printBoard() {

		System.out.println("");
		System.out.println("         0   " + "   1   " + "   2   " + "   3   " + "   4   " + "   5   " + "   6   "
				+ "   7   " + "   8   " + "   9   " + "   10");
		System.out.println("      ==============================================================================");

		for (int i = 0; i < 11; i++) {

			System.out.println("");

			if (i != 0) {
				System.out.println(
						"      |-----------------------------------------------------------------------------");
				if (i == 10) {

					System.out.print("   " + i + " |");

				} else {

					System.out.print("   " + i + "  |");

				}

			} else {

				System.out.print("   " + i + "  |");

			}

			for (int j = 0; j < 11; j++) {

				System.out.print("   ");
				if (Board.board[i][j] != null) {

					if (Board.board[i][j].getColor() == Color.BLACK) {

						System.out.print("O  |");

					} else if (Board.board[i][j].getColor() == Color.WHITE) {

						System.out.print("X  |");

					} else {

						System.out.print("#  |");

					}

				} else {

					System.out.print("   |");

				}
			}
		}
	}
}