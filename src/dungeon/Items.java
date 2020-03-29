package dungeon;

import java.io.Serializable;

public abstract class Items implements Comparable<Items>, Serializable {
	
	public abstract void useItem(Hero theHero, DungeonCharacter opponent);
	public abstract String getName();
	
	public int compareTo(Items i) {
		return this.getName().compareTo(i.getName());
	}

}
