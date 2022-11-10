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
	
	public static void main(String[] args) {
		// TODO
		launch();
	}

	public static void launch() {	//launches game and waits for input for user: '/p' to play; '/q' to quit.
		System.out.print(title);
		System.out.println("Enter /p to play or /q to quit");
		
		//Scanner narrator = new Scanner(System.in);
		
		String input = narrator.nextLine();		
		// if user enters /p: goes into the infinite while loop 
		if (input.equals("/p")) {
			// starts character creation
			playDemo();	// Starts Demo
			System.out.println("Please select a class to start your adventure! /n -Rogue /n -Archer /n -Warrior /n "
					+ "-Knight /n -Wizard /n -Bastard /n");
			
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
		
		Character character = new Character();
		
		System.out.println("Narrator: Welcome to the demo of our Fantasy RPG!");
		
		System.out.println("Adventurer: You there!");
		
		System.out.println("Adventurer: What is your name?");
		
		String name = narrator.nextLine();
		
		character.name = name;
		
		System.out.println("Adventurer: " + character.name + " was it?");
		
		System.out.println("Adventurer: Now that is an excellent name which befits a true warrior such as yourself.");
		
		System.out.println("Adventurer: Now what type of warrior are you, " + character.name + "?");
		
		System.out.println("Narrator: Please select a class to start your adventure! \n -Rogue <- Only one available for demo \n -Archer \n -Warrior \n"
				+ " -Knight \n -Wizard \n -Bastard \n");
		String input = narrator.nextLine();
		if (input.equals("/q")) {
			System.out.println("OK See Ya!");
			narrator.close();
		}
		if (input.equals("Rogue") || input.equals("r")) {
			character.chooseClass(input);
			System.out.println("Adventurer: Ah you are a " + character.CharClass + "\n Adventurer: You must be nimble on your feet!");
		}
		//Tests
		System.out.println(character.CharClass);
		System.out.println(character.weapon);
		
	}
	
}
