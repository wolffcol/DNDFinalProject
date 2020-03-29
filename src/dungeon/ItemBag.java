package dungeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ItemBag implements Serializable{
	
	ArrayList<Items> combatBag = new ArrayList<Items>();
	ArrayList<Items> nonCombatBag = new ArrayList<Items>();
	
	public ArrayList<Items> getCombatArrayList(){
		return combatBag;
	}
	
	public ArrayList<Items> getNonCombatArrayList(){
		return nonCombatBag;
	}
	
	public void printItemList(ArrayList<Items> itemBag) {
		Collections.sort(itemBag);
		for(Items i : itemBag) {
			System.out.println((itemBag.indexOf(i) + 1) + ". " + i.getName());
		}
		System.out.println(itemBag.size()+1 + ". To Go Back");
	}
	
	public void removeItem(Items item, ArrayList<Items> itemBag) {
		if(itemBag.contains(item)) {
			itemBag.remove(item);
		}else {
			System.out.println("Your item bag did not contain that item");
		}	
	}
	
	public void addItem(Items item, ArrayList<Items> itemBag) {
		if(item != null) {
			itemBag.add(item);
		}
	}

}
