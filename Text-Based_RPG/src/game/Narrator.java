package game;
import java.util.Scanner;


public class Narrator {

	static String title = " ********     **     ****     ** **********     **      ******** **    **\r\n"
			+ "/**/////     ****   /**/**   /**/////**///     ****    **////// //**  ** \r\n"
			+ "/**         **//**  /**//**  /**    /**       **//**  /**        //****  \r\n"
			+ "/*******   **  //** /** //** /**    /**      **  //** /*********  //**   \r\n"
			+ "/**////   **********/**  //**/**    /**     **********////////**   /**   \r\n"
			+ "/**      /**//////**/**   //****    /**    /**//////**       /**   /**   \r\n"
			+ "/**      /**     /**/**    //***    /**    /**     /** ********    /**   \r\n"
			+ "//       //      // //      ///     //     //      // ////////     //    \r\n"
			+ " *******   *******    ********                                           \r\n"
			+ "/**////** /**////**  **//////**                                          \r\n"
			+ "/**   /** /**   /** **      //                                           \r\n"
			+ "/*******  /******* /**                                                   \r\n"
			+ "/**///**  /**////  /**    *****                                          \r\n"
			+ "/**  //** /**      //**  ////**                                          \r\n"
			+ "/**   //**/**       //********                                           \r\n"
			+ "//     // //         ////////    ";
	
	static String title2 = "                                                                             \r\n"
			+ "     ##### ##                                                                \r\n"
			+ "  ######  /### /                                                             \r\n"
			+ " /#   /  /  ##/                        #                                     \r\n"
			+ "/    /  /    #                        ##                                     \r\n"
			+ "    /  /                              ##                                     \r\n"
			+ "   ## ##       /###   ###  /###     ######## /###      /###   ##   ####      \r\n"
			+ "   ## ##      / ###  / ###/ #### / ######## / ###  /  / #### / ##    ###  /  \r\n"
			+ "   ## ###### /   ###/   ##   ###/     ##   /   ###/  ##  ###/  ##     ###/   \r\n"
			+ "   ## ##### ##    ##    ##    ##      ##  ##    ##  ####       ##      ##    \r\n"
			+ "   ## ##    ##    ##    ##    ##      ##  ##    ##    ###      ##      ##    \r\n"
			+ "   #  ##    ##    ##    ##    ##      ##  ##    ##      ###    ##      ##    \r\n"
			+ "      #     ##    ##    ##    ##      ##  ##    ##        ###  ##      ##    \r\n"
			+ "  /####     ##    /#    ##    ##      ##  ##    /#   /###  ##  ##      ##    \r\n"
			+ " /  #####    ####/ ##   ###   ###     ##   ####/ ## / #### /    #########    \r\n"
			+ "/    ###      ###   ##   ###   ###     ##   ###   ##   ###/       #### ###   \r\n"
			+ "#                                                                       ###  \r\n"
			+ " ##                                                              #####   ### \r\n"
			+ "                                                               /#######  /#  \r\n"
			+ "                                                              /      ###/    \r\n"
			+ "                                                                             \r\n"
			+ "     ##### /##       ##### ##          # ###                                 \r\n"
			+ "  ######  / ##    ######  /###       /  /###  /                              \r\n"
			+ " /#   /  /  ##   /#   /  /  ###     /  /  ###/                               \r\n"
			+ "/    /  /   ##  /    /  /    ###   /  ##   ##                                \r\n"
			+ "    /  /    /       /  /      ##  /  ###                                     \r\n"
			+ "   ## ##   /       ## ##      ## ##   ##                                     \r\n"
			+ "   ## ##  /        ## ##      ## ##   ##   ###                               \r\n"
			+ "   ## ###/       /### ##      /  ##   ##  /###  /                            \r\n"
			+ "   ## ##  ###   / ### ##     /   ##   ## /  ###/                             \r\n"
			+ "   ## ##    ##     ## ######/    ##   ##/    ##                              \r\n"
			+ "   #  ##    ##     ## ######      ##  ##     #                               \r\n"
			+ "      /     ##     ## ##           ## #      /                               \r\n"
			+ "  /##/      ###    ## ##            ###     /                                \r\n"
			+ " /  ####    ##     ## ##             ######/                                 \r\n"
			+ "/    ##     # ##   ## ##               ###                                   \r\n"
			+ "#            ###   #  /                                                      \r\n"
			+ " ##           ###    /                                                       \r\n"
			+ "               #####/                                                        \r\n"
			+ "                 ###  ";
	
	static Scanner narrator = new Scanner(System.in);
	static Character character = new Character();
	static CombatTurnManager ctm = new CombatTurnManager();
	static SimpleMob mob;
	static SimpleMobGenerator generator;
	static Bag bag;
	
	public static void main(String[] args) {
		// TODO
		launch();
	}

	public static void launch() {	//launches game and waits for input for user: '/p' to play; '/q' to quit.
		System.out.println(title);
		System.out.println("Enter /p to play or /q to quit");
		
		//Scanner narrator = new Scanner(System.in);
		
		String input = narrator.nextLine();		
		// if user enters /p: goes into the infinite while loop 
		if (input.equals("/p")) {
			// starts character creation
			playDemo();	// Starts Demo
			System.out.println("Thank you for playing the demo!"); // End Message
			narrator.close();
			// inputs name
			// inputs class
			// narrative print statements
			// Starts the first encounter
			
		}
		
		// if user enters /q: inputs message saying the program is closing and then closes
		
		if (input == "/q") {
			System.out.println("Game is now shutting down.");
			// sleep(2);
			narrator.close();
			// quit program
		}
		
	}
	
	public static void playDemo() { // Starts Demo
		//String input = narrator.nextLine();
		
		// We should maybe sleep everytime we print a line because I believe it will just spam print all of these lines
		
		System.out.println("Narrator: Welcome to the demo of our Fantasy RPG!");
		System.out.println("Adventurer: You there!");
		System.out.println("Adventurer: What is your name?");
		
		String name = narrator.nextLine();
		character.name = name;

		System.out.println("Adventurer: " + character.name + " was it?");		
		System.out.println("Adventurer: Now that is an excellent name which befits a true warrior such as yourself.");
		System.out.println("Adventurer: Now what type of warrior are you, " + character.name + "?");
		System.out.println("Narrator: Your class choices are: \n\tRogue"
				+ "\n\tWarrior \n\tArcher \n\tKnight \n\tMage \n\tPeasant");
		
		while (true) {	
			String input = narrator.nextLine();
			if (input.equals("/q")) {
				System.out.println("OK See Ya!");
				narrator.close();
				break;
			}
			if (input.equals("Rogue") || input.equals("r") || input.equals("rogue")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: You must be nimble on your feet!");
				break;
			}
			
			else if (input.equals("Archer") || input.equals("a") || input.equals("archer")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: You must be an ox of a man to be able to draw that behemoth of a bow.");
				break;
			}
			else if (input.equals("Warrior") || input.equals("w") || input.equals("warrior")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: If you are a warrior, then where is your armor?");
				break;
			}
			
			else if (input.equals("Knight") || input.equals("k") || input.equals("knight")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: What is someone of your stature doing exploring a dungeon?");
				break;
			}
			
			else if (input.equals("Mage")|| input.equals("mage") || input.equals("m")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: Shouldn't you be reading some books?");
				break;
			}
			
			else if (input.equals("Peasant")|| input.equals("peasant") || input.equals("p")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: Only someone who has nothing left would come to this wretched place.");
				break;
			}
			
		
			else {
				System.out.println("That is not a valid class");
			
			}
		}

		//Tests
//		System.out.println(character.CharClass);
//		System.out.println(character.weapon.name);
//		character.inventory.displayInventory();
//		System.out.println(help());
		
//			ctm.startCombatEncounter(character);
//			ctm.startCombatEncounter(character);
//			ctm.startCombatEncounter(character);

		int mobLvlUp = 1; //Sets level mob is at. Progressivly gets more difficult to fight. 
		while(mobLvlUp != 5) {//start of while loop
			generator = new SimpleMobGenerator();
			mob = generator.createRandomEncounter(mobLvlUp);
			ctm.startCombatEncounter(character, mob);
			Potion lootPotion = bag.randomLootDrop();
			System.out.println("You have found a Potion");
			character.inventory.addItem(lootPotion, 1);
			character.inventory.displayInventory();
			//bag.grabLoot(); //maybe gives our player an opportunity to grab loot then on to the next fight!
			mobLvlUp++;
		}//end of while loop
//		
		
	}
	
	public static String help() {
		String help = "Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n";
		return help;
	}
	
}
