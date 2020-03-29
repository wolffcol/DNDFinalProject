package dungeon;

import java.io.Serializable;

public abstract class Room implements Serializable {
	
	boolean characterHasBeenHere;
	boolean temporaryReveal;
	public abstract void triggerRoom(Hero theHero);
	public abstract char getRoomType();

}
