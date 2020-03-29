package dungeon;

public class SaveLoadSystem {
	
	public static void saveGame() {
		
		System.out.println("Welcome to the Save Menu!\n"
				 + "Choose your Slot!\n"
				 + "1. Save Slot #1\n"
				 + "2. Save Slot #2\n");
		
		int choice = GameStateManager.getInt();
		switch (choice)
	    {
		    case 1: GameStateManager.getOriginator().setState();
		    		GameStateManager.getCaretaker().add(GameStateManager.getOriginator().saveStateToMemento(), 0);	
		    	break;
		    case 2: GameStateManager.getOriginator().setState();
		    		GameStateManager.getCaretaker().add(GameStateManager.getOriginator().saveStateToMemento(), 1);	
		        break;
		    default:
		        System.out.println("\nNo Valid Option Selected \n=================\n");
	    }
	}
	
	public static void loadGame() {
		
		Memento mem;
		
		System.out.println("Welcome to the Load Menu!\n"
				 + "Choose your Slot!\n"
				 + "1. Load Slot #1\n"
				 + "2. Load Slot #2\n");
		
		int choice = GameStateManager.getInt();
		switch (choice)
	    {
		    case 1: mem = GameStateManager.getCaretaker().get(0);
		    		GameStateManager.getOriginator().getStateFromMemento(mem);
		    		setLoadState(mem.getState());
		    	break;
		    case 2: mem = GameStateManager.getCaretaker().get(1);
		    		GameStateManager.getOriginator().getStateFromMemento(mem);
		    		setLoadState(mem.getState());
		        break;
		    default:
		        System.out.println("\nNo Valid Option Selected \n=================\n");
	    }
	}
	
	public static void setLoadState(State state) {
		GameStateManager.setTheHero(state.theHero);
		GameStateManager.setCurrentRoom(state.currRoom);
		GameStateManager.setGameDungeon(state.dungeon);
		//setCurrentRoom(currentRoom[0],currentRoom[1]);
		GameStateManager.startGame();
	}

}
