package game;

import java.io.Serializable;
import java.util.*;

/**
 * @author Herard Thibault
 * This class simulates a player
 */
public abstract class Player implements Serializable{

	private Board board;
	private String name;
	private String color;
	private boolean isWinner;


	/**
	 * Constructor of the class
	 * @param name The name of the player
	 * @param color The color of the pawns of the players.
	 */
	public Player(String name, String color){

		this.name = name;
		this.color = color;
		this.isWinner = false;

	}
	
	/**
	 * Configure the arraylist of the player
	 */
	public void configure() {
		
	}

	/**
	 * Return the name of the player
	 * @return a string of the name
	 */
	public String getName(){

		return this.name;

	}

	/**
	 * Get the color of the player
	 * @return The color of the player
	 */
	public Color getColor(){

		Color result = null;

		if(this.color.equals("WHITE")){

			result = Color.WHITE;

		}else if(this.color.equals("BLACK")){

			result = Color.BLACK;

		}

		return result;

	}

}