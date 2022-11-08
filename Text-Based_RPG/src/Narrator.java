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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
		
	}

	public static void launch() {	//launches game and waits for input for user: '/p' to play; '/q' to quit.
		System.out.print(title);
		System.out.println("Enter /p to play or /q to quit");
		
		Scanner narrator = new Scanner(System.in);
		
		String input = narrator.nextLine();		
		// if user enters /p: goes into the infinite while loop 
		if (input == "/p") {
			// starts character creation
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
	
}
