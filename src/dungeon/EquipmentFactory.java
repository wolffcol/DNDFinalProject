package dungeon;

public class EquipmentFactory {
	
	
	private int armorClassCount = 3;
	private int statBoostCount = 3;
	
	public Equipment generateEquipment() {
	
		int random = (int)(Math.random()*4) + 1;
	
		switch(random) {
	
			case 1:
				Equipment helmet = new Helmet();
				helmet = armorClass(helmet);
				helmet = statBoost(helmet);
				return helmet;
			case 2:
				Equipment armor = new Armor();
				armor = armorClass(armor);
				armor = statBoost(armor);
				return armor;
			case 3:
				Equipment gloves = new Gloves();
				gloves = armorClass(gloves);
				gloves = statBoost(gloves);
				return gloves;
			case 4:
				Equipment boots = new Boots();
				boots = armorClass(boots);
				boots = statBoost(boots);
				return boots;
			default:
				Equipment boots2 = new Boots();
				boots2 = armorClass(boots2);
				boots2 = statBoost(boots2);
				return boots2;
		}
	}
	
	public Equipment armorClass(Equipment armor) {
		
		//1 in 25 for legendary quality, 9 in 25 for rare quality
		int legendaryRoll = (int)(Math.random()*25) + 1;
		
		if(legendaryRoll == 25) {
			return generateLegendary(armor);
		}else if(legendaryRoll > 15) {
			return generateRare(armor);
		}else {
			return generateCommon(armor);
		}
		
		
		
	}
	
	public Equipment statBoost(Equipment armor) {
		
		int random = (int)(Math.random()*statBoostCount) + 1;
		
		if(random == 1) {
			return new Speed(armor);
		}else if(random == 2) {
			return new Damage(armor);
		}else {
			return new Clarity(armor);
		}
		
	}
	
	public Equipment generateLegendary(Equipment armor) {
		
		int random = (int)(Math.random()*armorClassCount) + 1;
		
		if(random == 1) {
			armor = new Leather(armor);
			return new Legendary(armor);
		}else if(random == 2) {
			armor = new Iron(armor);
			return new Legendary(armor);
		}else {
			armor = new Chainmail(armor);
			return new Legendary(armor);
		}
		
	}
	
	public Equipment generateRare(Equipment armor) {
		
		int random = (int)(Math.random()*armorClassCount) + 1;
		
		if(random == 1) {
			armor = new Leather(armor);
			return new Rare(armor);
		}else if(random == 2) {
			armor = new Iron(armor);
			return new Rare(armor);
		}else {
			armor = new Chainmail(armor);
			return new Rare(armor);
		}
		
	}
	
	public Equipment generateCommon(Equipment armor) {
		
		int random = (int)(Math.random()*armorClassCount) + 1;
		
		if(random == 1) {
			return new Leather(armor);
		}else if(random == 2) {
			return new Iron(armor);
		}else {
			return new Chainmail(armor);
		}
		
	}

}
