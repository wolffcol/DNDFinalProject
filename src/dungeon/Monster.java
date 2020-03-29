package dungeon;


public abstract class Monster extends DungeonCharacter
{
	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	protected boolean hasHealed;
//-----------------------------------------------------------------
  public Monster(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, double chanceToHeal,
					 int damageMin, int damageMax,
					 int minHeal, int maxHeal)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToHeal = chanceToHeal;
	this.maxHeal = maxHeal;
	this.minHeal = minHeal;

  }//end monster constructor

//-----------------------------------------------------------------
  public void heal()
  {
	boolean canHeal;
	int healPoints;

	canHeal = (Math.random() <= chanceToHeal) && (getHitPoints() > 0);

	if (canHeal && !hasHealed)
	{
		hasHealed = true;
		healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
		adjustHitPoints(-healPoints);
		System.out.println(getName() + " healed itself for " + healPoints + " points.\n"
							+ "Total hit points remaining are: " + getHitPoints());
		System.out.println();
	}//end can heal


  }//end heal method

//-----------------------------------------------------------------
 public void adjustHitPoints(int hitPoints)
 {
		super.adjustHitPoints(hitPoints);
		heal();

 }//end method
 
 public void setHealStatus() {
	 hasHealed = false;
 }


}//end Monster class