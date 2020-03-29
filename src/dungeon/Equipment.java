package dungeon;

import java.io.Serializable;

public abstract class Equipment implements Serializable{
	
	public abstract String getDescription();
	public boolean isEquipped;
	
	private double trueLeatherBlockAdjust = .05;
	private double trueIronBlockAdjust = .08;
	private double trueChainmailBlockAdjust = .1;
	private int trueAttackSpeedAdjust = 1;
	private int trueDamageAdjust = 5;
	private double trueChanceToHitAdjust = .05;
	
	private double leatherBlockAdjust = .05;
	private double ironBlockAdjust = .08;
	private double chainmailBlockAdjust = .1;
	private int attackSpeedAdjust = 1;
	private int damageAdjust = 5;
	private double chanceToHitAdjust = .05;
	
	public void equipItem() {
		if(!EquipmentHandler.checkSlot(this)) {
			
			if(this.getDescription().contains("Legendary")) {
				leatherBlockAdjust *= 3;
				ironBlockAdjust *= 3;
				chainmailBlockAdjust *= 3;
				attackSpeedAdjust *= 3;
				damageAdjust *= 3;
				chanceToHitAdjust *= 3;
			}else if(this.getDescription().contains("Rare")) {
				leatherBlockAdjust *= 2;
				ironBlockAdjust *= 2;
				chainmailBlockAdjust *= 2;
				attackSpeedAdjust *= 2;
				damageAdjust *= 2;
				chanceToHitAdjust *= 2;
			}
			if(this.getDescription().contains("Leather")) {
				GameStateManager.getHero().setTrueBlock(leatherBlockAdjust);
			}else if(this.getDescription().contains("Iron")) {
				GameStateManager.getHero().setTrueBlock(ironBlockAdjust);
			}else if(this.getDescription().contains("Chainmail")) {
				GameStateManager.getHero().setTrueBlock(chainmailBlockAdjust);
			}
		
			if(this.getDescription().contains("Speed")) {
				GameStateManager.getHero().setAttackSpeed(GameStateManager.getHero().getAttackSpeed() + attackSpeedAdjust);
			}else if(this.getDescription().contains("Damage")) {
				GameStateManager.getHero().setDamageMin(GameStateManager.getHero().getDamageMin() + damageAdjust);
				GameStateManager.getHero().setDamageMax(GameStateManager.getHero().getDamageMax() + damageAdjust);
			}else if(this.getDescription().contains("Clarity")) {
				GameStateManager.getHero().setChanceToHit(GameStateManager.getHero().getChanceToHit() + chanceToHitAdjust);
			}
		}else {
			System.out.println(GameStateManager.getHero().toString());
			System.out.println("Cannot Equip: " + this.getDescription() + ". Something is already equipped in that slot.");
			GameStateManager.pauseTime(2);
			System.out.println("Unequip previous item for the new one?\n"
							 + "1. Equip " + this.getDescription() + "\n"
							 + "2. Discard " + this.getDescription() + "\n");
			
			int choice = GameStateManager.getScanner().nextInt();
			
			if(choice == 1) {
			
				if(this.getDescription().contains("Helmet")) {
					EquipmentHandler.headSlot.removeItem();
					EquipmentHandler.headSlot = this;
				}else if(this.getDescription().contains("Armor")) {
					EquipmentHandler.armorSlot.removeItem();
					EquipmentHandler.armorSlot = this;
				}else if(this.getDescription().contains("Gloves")) {
					EquipmentHandler.gloveSlot.removeItem();
					EquipmentHandler.gloveSlot = this;
				}else {
					EquipmentHandler.bootSlot.removeItem();
					EquipmentHandler.bootSlot = this;
				}
			}else {
				
			}
			
		}
		resetTrueValue();
	}
	
	public void removeItem() {
		if(this.isEquipped) {
			if(this.getDescription().contains("Legendary")) {
				leatherBlockAdjust *= 3;
				ironBlockAdjust *= 3;
				chainmailBlockAdjust *= 3;
				attackSpeedAdjust *= 3;
				damageAdjust *= 3;
				chanceToHitAdjust *= 3;
			}else if(this.getDescription().contains("Rare")) {
				leatherBlockAdjust *= 2;
				ironBlockAdjust *= 2;
				chainmailBlockAdjust *= 2;
				attackSpeedAdjust *= 2;
				damageAdjust *= 2;
				chanceToHitAdjust *= 2;
			}
			if(this.getDescription().contains("Leather")) {
				GameStateManager.getHero().setTrueBlock(-leatherBlockAdjust);
			}else if(this.getDescription().contains("Iron")) {
				GameStateManager.getHero().setTrueBlock(-ironBlockAdjust);
			}else if(this.getDescription().contains("Chainmail")) {
				GameStateManager.getHero().setTrueBlock(-chainmailBlockAdjust);
			}
		
			if(this.getDescription().contains("Speed")) {
				GameStateManager.getHero().setAttackSpeed(GameStateManager.getHero().getAttackSpeed() - attackSpeedAdjust);
			}else if(this.getDescription().contains("Damage")) {
				GameStateManager.getHero().setDamageMin(GameStateManager.getHero().getDamageMin() - damageAdjust);
				GameStateManager.getHero().setDamageMax(GameStateManager.getHero().getDamageMax() - damageAdjust);
			}else if(this.getDescription().contains("Health")) {
				GameStateManager.getHero().setChanceToHit(GameStateManager.getHero().getChanceToHit() - chanceToHitAdjust);
			}
		}
		resetTrueValue();

	}
	
	private void resetTrueValue() {
		
		leatherBlockAdjust = trueLeatherBlockAdjust;
		ironBlockAdjust = trueIronBlockAdjust;;
		chainmailBlockAdjust = trueChainmailBlockAdjust;
		attackSpeedAdjust = trueAttackSpeedAdjust;
		damageAdjust = trueDamageAdjust;
		chanceToHitAdjust = trueChanceToHitAdjust;
	}


}
