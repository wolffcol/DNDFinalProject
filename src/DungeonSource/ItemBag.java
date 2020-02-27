package DungeonSource;

import java.util.ArrayList;
import java.util.Collections;

public class ItemBag{
	
	ArrayList<Items> itemBag = new ArrayList<Items>();
	
	public ArrayList<Items> getItemArrayList(){
		return itemBag;
	}
	
	public void printItemList() {
		Collections.sort(itemBag);
		for(Items i : itemBag) {
			System.out.println((itemBag.indexOf(i) + 1) + ": " + i.getName());
		}
	}
	
	public void removeItem(Items item) {
		if(itemBag.contains(item)) {
			itemBag.remove(item);
		}else {
			System.out.println("Your item bag did not contain that item");
		}	
	}
	
	public void addItem(Items item) {
		if(item != null) {
			itemBag.add(item);
		}
	}

}
