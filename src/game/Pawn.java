package game;

import java.io.Serializable;

/**
 * @author Herard Thibault
 * This class simulates a pawn
 */
public class Pawn implements Serializable{

	private Color color;
	private int x;
	private int y;
	private boolean alive;

	/**
	 * Constructor of the class
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param color the color of the pawn
	 */
	public Pawn(int x, int y, Color color) {

		if(color != null){

			this.x = x;
			this.y = y;
			this.color = color;
			this.alive = true;


		}

	}


	/**
	 * Print some information about the pawns
	 * @return a string with all the information
	 */
	public String toString() {

		String pawnString = (this.color + "pawn is at the coordinates (" + this.x + ";" + this.y + ")"  );
		return pawnString;

	}

	/**
	 * Set the position of a pawn
	 * @param x The x coordinate
	 * @param y The y coordinate
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * get the x coordinate
	 * @return x coordinate
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * get the y coordinate
	 * @return the y coordinate
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Tell is a pawn is alive
	 * @return true if the pawn is alive
	 */
	public boolean isAlive() {
		return this.alive;
	}

	/**
	 * Set x position
	 * @param x X postion to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Set y position
	 * @param y Y position to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	
	/**
	 * Move a pawn in a direction with a distance 
	 * @param direction The direction where the pawn is moving
	 * @param distance The distance of moving
	 */
	public void move(Direction direction, int distance) {

		switch(direction){

			case N:
				this.setX(this.getX()-distance);
				break;

			case S:
				this.setX(this.getX()+distance);
				break;

			case W:
				this.setY(this.getY()-distance);
				break;

			case E:
				this.setY(this.getX()+distance);
				break;

			case NE:
				this.setX(this.getX()-distance);
				this.setY(this.getX()+distance);
				break;

			case NW:
				this.setX(this.getX()-distance);
				this.setY(this.getY()-distance);
				break;

			case SE:
				this.setX(this.getX()+distance);
				this.setY(this.getX()+distance);
				break;

			case SW:
				this.setX(this.getX()+distance);
				this.setY(this.getY()-distance);
				break;

			default:
				System.out.println("Incorrect move");
				break;
		}
	
	}

	/**
	 * Move a pawn to coordinates
	 * @param x X coordinates
	 * @param y Y coordinates
	 */
	public void move(int x, int y){

		this.x = x;
		this.y = y;

	}

	
	/**
	 * Return the color of the pawn
	 * @return the color
	 */
	public Color getColor(){

		return this.color;

	}


}