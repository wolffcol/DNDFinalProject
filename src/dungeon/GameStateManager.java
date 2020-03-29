package dungeon;
import java.util.Scanner;

public class GameStateManager {
	
	private static Room[][] gameDungeon;
	private static int[] currentRoom;
	private static Hero theHero;
	private static Scanner scan = new Scanner(System.in);
	private static Caretaker caretaker;
	private static Originator originator;

	public static void stateSetup() {
		
		caretaker = new Caretaker();
		originator = new Originator();
		
		System.out.println("Would you like to load from a previous save?\n"
						+  "1. Yes\n"
						+  "2. No\n");
		int choice = getInt();
		if(choice == 1) {
			SaveLoadSystem.loadGame();
		}else {
			statesHolder state = InitializeGame.BuildGame();
			setTheHero(state.theHero);
			setGameDungeon(state.dungeon);
			setCurrentRoom(state.currRoom);
			
			MapBehavior.exploredMap();
			startGame();	
		}
		
	}
	
	public static void startGame() {
		theHero.nonBattleChoices();
	}
	
	public static int getInt() {
		
		int choice = -1;
		boolean isInt = false;
		do {
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				isInt = true;
			}else {
				scan.nextLine();
				System.out.println("Mismatch Exception: Try Again");
			}
		
		}while(!isInt);
		
		if(choice == 37 && theHero != null) {
			hiddenMenu();
		}
		
		return choice;
	}
	
	public static String getString() {
		return scan.next();
	}
	
	public static void pauseTime(double sleepTime) {
		try {
			Thread.sleep((int)(sleepTime*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setCurrentRoom(int x, int y) {
		currentRoom[0] = x;
		currentRoom[1] = y;
		
		if(!gameDungeon[x][y].characterHasBeenHere) {
			
			if(gameDungeon[x][y].getClass().toString().contains("exitRoom")) {
				
			}else {
			gameDungeon[x][y].characterHasBeenHere = true;
			}
			gameDungeon[x][y].triggerRoom(theHero);
		}else {
			System.out.println("This room feels familiar");
		}
		
		MapBehavior.exploredMap();
	}
	
	public static void winGame() {
		System.out.println("You have collected the four Artifacts of OO and have become a code dungeon wizard. Now ask Tapaul for your 40 extra credit points.");
		if(DungeonAdventure.playAgain(scan)) {
			stateSetup();
		}else {
			System.exit(0);
		}
	}
	
	public static void gameOver() {
		SaveLoadSystem.loadGame();
	}

	public static void hiddenMenu() {
		
		System.out.println("Welcome to the Cheats Menu!\n"
						 + "Choose your Cheat!\n"
						 + "1. Full Dungeon Reveal\n"
						 + "2. God Mode\n"
						 + "3. Big Head Mode\n"
						 + "4. Save Game\n");
		
		int choice = getInt();
		switch (choice)
	    {
		    case 1: MapBehavior.fullMapReveal();
		    	break;
		    case 2: godMode();
		        break;
		    case 3: System.out.println("Just look in the mirror.");
		    	break;
		    case 4: SaveLoadSystem.saveGame();
		    	break;
		    default:
		        System.out.println("\nNo Valid Option Selected \n=================\n");
	    }
		
	}

	private static void godMode() {
		theHero.setAttackSpeed(10);
		theHero.setHitPoints(1000);
		theHero.setDamageMin(100);
		theHero.setDamageMax(200);
		theHero.setChanceToHit(1);
		
	}
	
	public static Room[][] getDungeon(){
		return gameDungeon;
	}
	
	public static Scanner getScanner() {
		return scan;
	}
	
	public static int[] getCurrentRoom() {
		return currentRoom;
	}
	
	public static Hero getHero() {
		return theHero;
	}

	public static Originator getOriginator() {
		return originator;
	}

	public static Caretaker getCaretaker() {
		return caretaker;
	}

	public static void setTheHero(Hero theHero) {
		GameStateManager.theHero = theHero;
	}

	public static void setCurrentRoom(int[] currentRoom) {
		GameStateManager.currentRoom = currentRoom;
	}

	public static void setGameDungeon(Room[][] gameDungeon) {
		GameStateManager.gameDungeon = gameDungeon;
	}
}
