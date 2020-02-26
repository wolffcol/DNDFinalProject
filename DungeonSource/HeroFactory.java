package DungeonSource;

import java.util.Scanner;

public class HeroFactory {
	
	
	public static Hero createHero(Scanner scan) {
		
		
		System.out.println("Choose a hero:\n" +
			       "1. Warrior\n" +
				   "2. Sorceress\n" +
				   "3. Thief");
		
		int choice = scan.nextInt();
		
		switch(choice)
		{
			case 1: return new Warrior();

			case 2: return new Sorceress();

			case 3: return new Thief();

			default: System.out.println("invalid choice, returning Thief");
				     return new Thief();
		}
	}

}
