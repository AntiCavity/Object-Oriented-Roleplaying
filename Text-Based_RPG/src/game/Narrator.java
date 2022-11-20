package game;
import java.util.Scanner;
import java.util.concurrent.*;


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
	static Mob mob;
	static SimpleMobGenerator generator;
	static Bag bag = new Bag();
	static TimeUnit time = TimeUnit.SECONDS;
	
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
	
	public static void playDemo() { 
		// Starts Demo //
		System.out.println("Welcome to the demo of our Fantasy RPG!");
		sleep(2);
	//Intro narration
		System.out.println("Narrator: Your head feels heavy as you wake up dazed and confused.");
		sleep(2);
		System.out.println("You reach to the source of the pain, the back of your head, and a sharp pain pulses through your head!");
		sleep(2);
		System.out.println("That's not good...");
		sleep(2);
		System.out.println("You manage to stand with the strength you have left.");
		sleep(2);
		System.out.println("You take a good look around and find yourself in a cave with stalagmites hanging from the ceiling.");
		sleep(2);
		System.out.println("You also notice an erie green light emmiting in the cave, but you can't locate it's origin.");
		sleep(2);
		System.out.println("The ringing in your ears suddenly transforms into words coming from a stanger behind you.");
		sleep(2);
		System.out.println("Was he there the whole time?");
		sleep(2);
		System.out.println("Adventurer: You there!");
		sleep(2);
		System.out.println("Adventurer: What is your name?");
		
		String name = narrator.nextLine();
		character.name = name;

		System.out.println("Adventurer: " + character.name + " was it?");	
		sleep(2);
		System.out.println("Adventurer: Now that is an excellent name which befits a true warrior such as yourself.");
		sleep(2);
		System.out.println("Adventurer: Now what type of warrior are you, " + character.name + "?");
		sleep(2);
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
				sleep(2);
				break;
			}
			
			else if (input.equals("Archer") || input.equals("a") || input.equals("archer")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: You must be an ox of a man to be able to draw that behemoth of a bow.");
				sleep(2);
				break;
			}
			else if (input.equals("Warrior") || input.equals("w") || input.equals("warrior")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: If you are a warrior, then where is your armor?");
				sleep(2);
				break;
			}
			
			else if (input.equals("Knight") || input.equals("k") || input.equals("knight")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: What is someone of your stature doing exploring a dungeon?");
				sleep(2);
				break;
			}
			
			else if (input.equals("Mage")|| input.equals("mage") || input.equals("m")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: Shouldn't you be reading some books?");
				sleep(2);
				break;
			}
			
			else if (input.equals("Peasant")|| input.equals("peasant") || input.equals("p")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: Only someone who has nothing left would come to this wretched place.");
				sleep(2);
				break;
			}
			
		
			else {
				System.out.println("That is not a valid class");
			
			}
		}
		System.out.println("Adventurer: Oh by the Gods! What is that!?");
		sleep(2);
		System.out.println("Narrator: You turn your head to find a mysterious shadow behind you! \n" 
				+ "\t You draw your " + character.weapon.name + " and prepare for a battle!");
		
		int mobLvlUp = 1; //Sets level mob is at. Progressivly gets more difficult to fight. Ends after 3 encounters.
		while(mobLvlUp != 4) {//start of while loop
			generator = new SimpleMobGenerator();
			mob = generator.createRandomEncounter(mobLvlUp);
			ctm.startCombatEncounter(character, mob);
			System.out.println("\nYou have found a potion on the body of your enemy.");
			sleep(2);
			bag.randomLootDrop(character);
			sleep(2);
			character.characterLevelUp(mobLvlUp);
			sleep(2);
			character.inventory.displayInventory();
			sleep(2);
			//bag.grabLoot(); //maybe gives our player an opportunity to grab loot then on to the next fight!
			mobLvlUp++;
		}//end of while loop
	
		System.out.println("Adventurer: Thank you for saving me! You're a brave adventurer for fending off those beasts!");
		System.out.println("Here is a reward for protecting me...");
		bag.randomLootDrop(character); 
		sleep(2);
		bag.randomLootDrop(character);
		sleep(2);
		bossEvent();
		
		
		
	}
	
	public static String help() {
		String help = "Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n";
		return help;
	}
	
	public static void bossEvent() {
		System.out.println("Narrator: You then continue your journey through the cave you woke up in.");
		sleep(2);
		System.out.println("You learn from the strange adventurer that you encountered that this cave is named The Cave Of Forever.");
		sleep(2);
		System.out.println("Almost seems somewhat unimaginative...");
		sleep(2);
		System.out.println("Legend has it, that once someone enters the cave, they never come out until they have faced a great trial.");
		sleep(2);
		System.out.println("I sense some forshadowing happening...");
		sleep(2);
		System.out.println("BOOM");
		sleep(2);
		System.out.println("BOOM");
		sleep(2);
		System.out.println("Adventurer: Wait... Do you hear that?");
		sleep(2);
		BossMobGenerator generator = new BossMobGenerator();
		mob = generator.createRandomEncounter();
		System.out.println("Narrator: Your gut tells you this must be the great trial that the strage adventurer mentioned...");
		sleep(2);
		ctm.startCombatEncounter(character, mob);
	}
	
	public static void sleep(int seconds) {
		try {
			time.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
