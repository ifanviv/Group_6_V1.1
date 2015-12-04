/**
 * @file GameSetup.java
 * @author James Michael
 * @date 02 Dec 2015
 * This sets the values for name, gametype, and number of
 * tiles and mines.
 */
public class GameSetup {
	private String playerName;
	private static int numberOfTiles;
	private static int numberOfMines;
	private boolean customGame;
	
	public GameSetup(String name, int enteredNumOfTiles, int enteredNumOfMines, boolean gameType){
		setName(name);
		setNumberOfTiles(enteredNumOfTiles);
		setNumberOfMines(enteredNumOfMines);
		setGameType(gameType);
	}
	public void setGameType(boolean gameType){
		if (gameType == false){
			customGame = false;
		}
		else{
			customGame = true;
		}
	}
	public boolean getGameType(){
		return customGame;
	}
	public void setName(String name){
		playerName = name;
	}
	public String getName(){
		return playerName;
	}
	public static void setNumberOfTiles(int enteredNumOfTiles){
		numberOfTiles = enteredNumOfTiles;
	}
	public static int getNumberOfTiles(){
		return numberOfTiles;
	}
	public void setNumberOfMines(int enteredNumOfMines){
		numberOfMines = enteredNumOfMines;
	}
	public static int getNumberOfMines(){
		return numberOfMines;
	}
	
}