package dungeon;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock, trueBlock;
	private int numTurns, cooldownTimer, timerMax;
	private ItemBag itemBag;
	protected boolean hadEncapsulation, hadAbstraction, hadPolymorphism, hadInheritance = false;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.trueBlock = chanceToBlock;
		readName();
		SpellPool.setHero(this);
		createBag();
	}
	
	public void readName()
	{
		System.out.print("Enter character name: ");
		setName(GameStateManager.getString());
	}//end readName method

	public abstract void special(DungeonCharacter opponent);
  
	private void createBag() { 
		itemBag = new ItemBag();
	}

	public int getTurns() {
		return numTurns;
	}
  
	public void setTurns(int add) {
		numTurns += add;
	}
  
	public void setBlock(double block) {
		this.chanceToBlock = block;
	}
	
	public void setTrueBlock(double addedBlock) {
		this.trueBlock += addedBlock;
	}
	
	public double getBlock() {
		return chanceToBlock;
	}
	
	public ItemBag getItemBag() {
		return itemBag;
	}
	
	public int getCooldown() {
		return cooldownTimer;
	}
	
	public int getCooldownMax() {
		return timerMax;
	}

	public void setCooldown(int cooldown) {
		cooldownTimer = cooldown;
	}
	
	public void setCooldownMax(int max) {
		timerMax = max;
	}
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method

	public void adjustHitPoints(int hitPoints){
		if (hitPoints < 0){
			super.adjustHitPoints(hitPoints);
		}else if(defend()){
			System.out.println(getName() + " BLOCKED the attack!");
		}else{
			super.adjustHitPoints(hitPoints);
		}
	}//end method

	public void useCombatItem(Hero theHero, DungeonCharacter opponent) {
	
		itemBag.printItemList(itemBag.getCombatArrayList());;
		int choice = -1;
	
		do {
			System.out.println("Which item would you like to use: ");
			choice = GameStateManager.getInt();
	
		}while(choice > itemBag.getCombatArrayList().size()+1 || choice < 1);
		
		if(choice == itemBag.getCombatArrayList().size()+1) {
		
		}else {
			itemBag.getCombatArrayList().get(choice-1).useItem(theHero, opponent);
			itemBag.getCombatArrayList().remove(choice-1);
		}
		
	}

	public void useNonCombatItem(Hero theHero, DungeonCharacter opponent) {
	
		itemBag.printItemList(itemBag.getNonCombatArrayList());
		int choice = -1;
	
	
		do {
			System.out.println("Which item would you like to use: ");
			choice = GameStateManager.getInt();
	
		}while(choice > itemBag.getNonCombatArrayList().size()+1 || choice < 1);
	
		if(choice == itemBag.getNonCombatArrayList().size() + 1) {
		
		}else {
			itemBag.getNonCombatArrayList().get(choice-1).useItem(theHero, opponent);
			itemBag.getNonCombatArrayList().remove(choice-1);
		}
		
	}
	
	public void nonBattleChoices() {
		
			int choice;
			do
			{
				
				System.out.println("\n1. Move Rooms");
				if(itemBag.nonCombatBag.isEmpty()) {
		    	
				}else {
					System.out.println("2. Use an Item");
				}
				System.out.println("3. Check Status");
				System.out.print("Choose an option: ");
		    
				MapBehavior.resetVisionPotion();

				choice = GameStateManager.getInt();
		    	
				switch (choice)
				{
			    	case 1: MovementController.movement();
			    		break;
			    	case 2: useNonCombatItem(this, null);
			        	break;
			    	case 3: System.out.println(this.toString());
			    		break;
			    	default:
			    		System.out.println("\nChoose Again \n=================\n");
				}
				
			}while(isAlive() == true);
			
	}

	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

	public void clearPotionEffects() {
		this.chanceToBlock = trueBlock;	
	}


	public void setItemBag(ItemBag tempBag) {
		this.itemBag = tempBag;
		
	}
	
	public int artifactCount() {
		int count = 0;
		for(Items i : itemBag.combatBag) {
			if(i.getName().contains("Artifact")) {
				count++;
			}
		}
		for(Items i : itemBag.nonCombatBag) {
			if(i.getName().contains("Artifact")) {
				count++;	
			}
		}
		return count;
	}
	
	public String toString() {
		return  "================" + 
				"\n Name: " + this.getName() + 
				"\n Class: " + this.getClass().toString().substring(20) +
				"\n Hit Points: " + this.getHitPoints() +
				"\n Damage: " + this.getDamageMin() + "-" + this.getDamageMax() +
				"\n Speed: " + this.getAttackSpeed() +
				"\n " + headCheck() +
				"\n " + armorCheck() +
				"\n " + gloveCheck() +
				"\n " + bootCheck() +
				"\n Items: " + (itemBag.combatBag.size() + itemBag.nonCombatBag.size()) + 
				"\n Artifacts: " + artifactCount() + 
				"\n===============";  
	}
	
	public String headCheck() {
		
		if(EquipmentHandler.headSlot != null) {
			return "Helmet: " + EquipmentHandler.headSlot.getDescription();
		}else {
			return "Helmet: Empty";
		}
		
	}
	
	public String armorCheck() {
		
		if(EquipmentHandler.armorSlot != null) {
			return "Armor: " + EquipmentHandler.armorSlot.getDescription();
		}else {
			return "Armor: Empty";
		}
	}
	
	public String gloveCheck() {
		
		if(EquipmentHandler.gloveSlot != null) {
			return "Gloves: " + EquipmentHandler.gloveSlot.getDescription();
		}else {
			return "Gloves: Empty";
		}
	}
	
	public String bootCheck() {
		
		if(EquipmentHandler.bootSlot != null) {
			return "Boots: " + EquipmentHandler.bootSlot.getDescription();
		}else {
			return "Boots: Empty";
		}
	}

}//end Hero class