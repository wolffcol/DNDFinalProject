package dungeon;

import java.util.Scanner;

public class DungeonAdventure {
	
	//Hidden Menu Code is 37
	public static void main(String[] args)
	{
		
		do
		{
			GameStateManager.stateSetup();
			GameStateManager.gameOver();
			
		} while (playAgain(GameStateManager.getScanner()));
		
		
		//Added for correctness even though the program terminates just after this
		GameStateManager.getScanner().close();

    }//end main method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain(Scanner scan)
	{
		char again[];

		System.out.println("Play again (y/n)?");
		again = scan.next().toCharArray();

		return (again[0] == 'Y' || again[0] == 'y');
	}//end playAgain method
}//end Dungeon class
