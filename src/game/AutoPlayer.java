package game;


/**
 * @author Herard Thibault Simulate an AutoPlayer
 */
public class AutoPlayer extends Player {

	private Difficulty difficulty;

	/**
	 * Constructor of the class
	 * @param name The name of the player
	 * @param color The color of the player
	 * @param diff The difficulty of the bot
	 */
	public AutoPlayer(String name, String color, Difficulty diff) {
		super(name, color);
		this.difficulty = diff;
	}

	/**
	 * Set the difficulty of the player
	 * @param difficulty the difficulty of the player
	 */
	public void setDifficulty(Difficulty difficulty){

		this.difficulty = difficulty;

	}

	/**
	 * Get the difficulty of the robot
	 * @return the difficulty
	 */
	public Difficulty getDifficulty() {

		return this.difficulty;

	}

	/**
	 * Calculate the best move to do in fonction of the difficulty set
	 */
	public void moveIA() {
		throw new UnsupportedOperationException();
	}

}