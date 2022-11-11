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
	
	static Scanner narrator = new Scanner(System.in);
	static Character character = new Character();
	static CombatTurnManager ctm = new CombatTurnManager();
	
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
		System.out.println("Narrator: Your class choices are: \n\tRogue (This is the only one in the demo.)"
				+ "\n\tWarrior \n\tArcher \n\tKnight \n\tWizard \n\tBastard");
		
		while (true) {	
			String input = narrator.nextLine();
			if (input.equals("/q")) {
				System.out.println("OK See Ya!");
				narrator.close();
				break;
			}
			if (input.equals("Rogue") || input.equals("r")) {
				character = character.chooseClass(input);

				System.out.println("Adventurer: Ah you are a " + character.CharClass + "." + "\nAdventurer: You must be nimble on your feet!");
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
		ctm.startCombatEncounter(character);
	}
	
	public static String help() {
		String help = "Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n";
		return help;
	}
	
}
