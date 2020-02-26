package DungeonSource;

public class TrapRoom extends Room{
	
	public TrapRoom() {
		
	}
	
	
	public void trapType() {
		int type = (int)(Math.random()*3)+1;
		
		switch(type) {
			case 1:
				System.out.println("Character takes damage");
				break;
			case 2:
				System.out.println("Character falls into a healing fountain");
				break;
			case 3:
				System.out.println("You lose the items in your bag");
				break;
			default:
				System.out.println("Character takes damage");
				
		}
	}

	@Override
	public void triggerRoom() {
		trapType();		
	}

}
