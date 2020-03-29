package dungeon;

public class EquipmentHandler {
	
	static Equipment headSlot = null;
	static Equipment gloveSlot = null;
	static Equipment bootSlot = null;
	static Equipment armorSlot = null;
	
	public static boolean checkSlot(Equipment eq) {
		if(eq.getDescription().contains("Helmet")){
			if(headSlot == null) {
				headSlot = eq;
				return false;
			}else {
				return true;
			}
		}	
		if(eq.getDescription().contains("Gloves")){
			if(gloveSlot == null) {
				gloveSlot = eq;
				return false;
			}else {
				return true;
			}
		}
		if(eq.getDescription().contains("Boots")){
			if(bootSlot == null) {
				bootSlot = eq;
				return false;
			}else {
				return true;
			}
		}
		if(eq.getDescription().contains("Armor")){
			if(armorSlot == null) {
				armorSlot = eq;
				return false;
			}else {
				return true;
			}
		}
		return false;
	}

}
