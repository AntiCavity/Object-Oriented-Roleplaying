package game;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.HashMap;

public class CombatTurnManager {

	Scanner combatCommand = new Scanner(System.in);
	
	HashSet<String> commandSet = new HashSet<String>();
	HashSet<Skills> playerSkills = new HashSet<Skills>();
	
	Character player;
	Mob mob;
	//SimpleMobGenerator generator;
		
	public void startCombatEncounter(Character p, Mob m) {
		//generator = new SimpleMobGenerator();
		//mob = generator.createRandomEncounter();
		if (m.getClass().getName().equals("game.SimpleMob")) {
			mob = (SimpleMob) m;
		}
		else if (m.getClass().getName().equals("game.BossMob")) {
			mob = (BossMob) m;
		}
		player = p;
		playerSkills = (player.attackSkills);

		//Sets commands
		commandSet.add("a");
		commandSet.add("i");
		commandSet.add("in");
		commandSet.add("f");
		commandSet.add("help");
		
		//TODO Maybe move this to Narrator for a linear experience
		System.out.println("Adventurer: Oh by the Gods! What is that thing!?");
		System.out.println("Narrator: You turn your head to find a " + mob.name + " behind you! \n" 
				+ "\t You draw your " + player.weapon.name + " and prepare for a battle!");
		System.out.println("TIP: To find out what commands you can input, type 'help' in the command line");
		
		while (mob.healthPoints > 0 && player.healthPoints > 0) {
			
			System.out.println("\nYour HP: " + player.healthPoints + "\t" + mob.name + " HP: " + mob.healthPoints + "\n");
			
			System.out.println("Your mana: " + player.mana + "\n");
			
			System.out.println("Narrator: What do you want to do?");
			
			String input = combatCommand.nextLine();
			
			
			if (!commandSet.contains(input)) {
				System.out.println("That's an invalid command! To find out what commands you can input, type 'help' in the command line");
			}
			else if (input.equals("a")) {attackCommand();}
			else if (input.equals("i")) {inventoryCommand();}
			else if (input.equals("in")) {inspectCommand();}
			else if (input.equals("f")) {fleeCommand();}
			else if (input.equals("help")) {helpCommand();}
			else if (input.equals("quit")) {
												combatCommand.close();
												break;}
		}
		if (player.healthPoints <= 0) {
			System.out.println("Narrator: You took a fatal hit from " + mob.name + ". Your body is left for the "
					+ "vultures...");
//			System.out.println("GAME OVER");
			gameOver();
			System.exit(0); //Closes program when killed
			//combatCommand.close();
		}
		
		else if (mob.healthPoints <= 0) {
			System.out.println("\nYou have slain the " + mob.name + "\n");
			//combatCommand.close();
		}
	}
	
	public void attackCommand() {
		//Scanner attackCommand = new Scanner(System.in);
		//TODO Still need to add logic to manage mana usage for final product.
		int playerDmg = 0;	// total damage player deals
		boolean stop = false;
		String attackDescription = null;
		while (stop == false) {
			boolean errCounter = true;
			boolean manaChecker = true;
			Iterator<Skills> skills = playerSkills.iterator();
			while(skills.hasNext()) {	// Prints out skills available for player to use
				Skills skill = skills.next();
				System.out.println("\n" + skill.name);
				System.out.println("\t Damage: " + skill.damage);
				System.out.println("\t Mana Cost: " + skill.energyCost);
				//availableSkills.add(skill);
			}
		
			System.out.println("Narrator: What skill would you like to use?");
			
			String input = combatCommand.nextLine();
			
			Iterator<Skills> skills2 = playerSkills.iterator();
			while(skills2.hasNext()) {	// Searches for name of skill player inputs
				Skills skill2 = skills2.next();
				
				if (input.equals(skill2.name)) {
					
					if (skill2.energyCost > player.mana) {
						errCounter = false;
						
					}
					else {
						playerDmg = (skill2.damage);
						player.mana = player.mana - skill2.energyCost;
						stop = true;
						errCounter = false;
						manaChecker = false;
						attackDescription = skill2.skillDescription;
						}
				
					if (errCounter == true) {
					System.out.println("Invalid Skill.\nPlease check your spelling.");
			
					}
			
					else if (manaChecker == true) {
					System.out.println("YOU HAVE NO MANA");
					}
				}	
			}
		
			System.out.println(attackDescription);
			System.out.println("Narrator: You dealt: " + playerDmg + " damage!");
			mob.healthPoints -= playerDmg;
		
			if (mob.healthPoints > 0) {
				System.out.println("\nThe " + mob.name + " lunged at you!\n");
				System.out.println("Narrator: You received " + mob.baseDamage + " damage.");
				player.healthPoints -= mob.baseDamage;
				}
			
		}
	}
	
	public void inventoryCommand() {
		player.inventory.displayInventory();
		
		System.out.println("\nNarrator: Type the number of the item you want to use!\n"); // 1 for the first item, 2 for the second, and so on...
		String input = combatCommand.nextLine();
		try { //try and catch for invalid input
			int desiredItemToUse = Integer.parseInt(input);
			int count = 1;
		
		
			for (Map.Entry<Item, Integer> e : player.inventory.inventory.entrySet()) {
				if (count == desiredItemToUse) {
					Item useItem = e.getKey();
					player = player.inventory.useItem(player, e.getKey()); //Updates player object
					System.out.println("You grabbed " + useItem.name);
					break;
				}
				else {
					count++;
            	//TESTING STATEMENTS
            	//System.out.println("Ooops something went wrong!");
            	//System.out.println("count: " + count);
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a number.");
		  }
	}
	
	public boolean inspectCommand() {
		System.out.println("You take a moment to inspect your opponent. Here is what you see... \n");
		System.out.println(mob.description); //prints out mob's physical description for the player
		return true;
	}
	
	public boolean fleeCommand() {
		System.out.println("Adventurer: YOU COWARD! DO NOT RUN AWAY! I DON'T WANT TO DIE!");
		player.healthPoints -= mob.baseDamage; //mob attacks player
		System.out.println("\nThe " + mob.name + " lunged at you!\n");
		System.out.println("Narrator: You received " + mob.baseDamage + " damage.");
		return true;
	}
	
	public boolean helpCommand() {
		System.out.println("Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n");
		return true;
	}
	
	public boolean gameOver() {
		System.out.println(" ::::::::      :::     ::::    ::::  ::::::::::  ::::::::  :::     ::: :::::::::: :::::::::  \r\n"
				+ ":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:        :+:    :+: :+:     :+: :+:        :+:    :+: \r\n"
				+ "+:+         +:+   +:+  +:+ +:+:+ +:+ +:+        +:+    +:+ +:+     +:+ +:+        +:+    +:+ \r\n"
				+ ":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#   +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  \r\n"
				+ "+#+   +#+# +#+     +#+ +#+       +#+ +#+        +#+    +#+  +#+   +#+  +#+        +#+    +#+ \r\n"
				+ "#+#    #+# #+#     #+# #+#       #+# #+#        #+#    #+#   #+#+#+#   #+#        #+#    #+# \r\n"
				+ " ########  ###     ### ###       ### ##########  ########      ###     ########## ###    ###");
		return true;
	}
		
}
