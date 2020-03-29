package dungeon;

import java.io.Serializable;

public class Memento implements Serializable {
	
	private State state;
	
	public Memento(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}

}

class State implements Serializable{
	
	Hero theHero; 
    Room[][] dungeon;  
    int[] currRoom;
    State(Hero theHero, Room[][] dungeon , int[] currRoom){  
        this.theHero = theHero;  
        this.dungeon = dungeon; 
        this.currRoom = currRoom;
    }  
	
}
