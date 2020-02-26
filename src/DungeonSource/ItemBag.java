package DungeonSource;

import java.util.ArrayList;

public class ItemBag {
	
	ArrayList<Items> itemBag = new ArrayList<Items>();
	
	public ArrayList<Items> getItemBag(){
		return itemBag;
	}
	
	public void printItemList() {
		for(Items i : itemBag) {
			System.out.println((itemBag.indexOf(i) + 1) + ": " + i.getName());
		}
	}
	
	public void removeItem(Items item) {
		if(itemBag.contains(item)) {
			item.useItem();
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
