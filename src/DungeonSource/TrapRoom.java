package DungeonSource;

public class TrapRoom extends Room{
	
	public TrapRoom() {
		trapType();
	}
	
	public void trapType() {
		int type = (int)Math.random()*10;
		
		switch(type) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			default:
				System.out.println("Yep");
		}
	}

}
