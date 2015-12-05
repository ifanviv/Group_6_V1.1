/**
 * @file GameResult.java
 * @author James Michael
 * @date 03 Dec 2015
 *
 * This class will be used to help determine the result of the game
 */

public class GameResult{
	private boolean gameWon;
	private boolean gameLost;
	private boolean gameResult;

	//if the game result is being handled in another class, pass to this:
	/*public GameResult(boolean result){
		setGameResult(result);
	}*/

	//this method will handle whether won/lost, possibly animation (i'm thinking JOptionPane)
	public boolean setGameResult(boolean gameResult){
		if (gameResult == true){
			gameWon = true;
		}
		if (gameResult == false){
			gameLost = true;
		}

	}

	//this method will return the appropriate outcome
	public JOptionPane getGameResult(){
		//return gameResult;
		if (gameWon == true){
			String won = "You Win!";
			//JOptionPane.showMessageDialog(frame, won, "You Win!", JOptionPane.WARNING_MESSAGE);
			return JOptionPane.showMessageDialog(frame, won, "You Win!", JOptionPane.WARNING_MESSAGE);
		}
		String loss = "You Lose!";
		return JOptionPane.showMessageDialog(frame, loss, "You Lose!", JOptionPane.WARNING_MESSAGE);
//		String won = "You Win!";
//			JOptionPane.showMessageDialog(frame, won, "You Win!", JOptionPane.WARNING_MESSAGE);
	}
	
}