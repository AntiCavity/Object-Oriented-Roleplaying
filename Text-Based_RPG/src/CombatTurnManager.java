import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CombatTurnManager {

	Scanner combatCommand = new Scanner(System.in);
	
	HashSet<String> commandSet = new HashSet<String>();
	HashSet<Skills> playerSkills = new HashSet<Skills>();
	//ArrayList<Skills> availableSkills;
	
	Character player;
	SimpleMob mob;
	SimpleMobGenerator generator;
		
	public void startCombatEncounter(Character p) {
		generator = new SimpleMobGenerator();
		mob = generator.createRandomEncounter();
		player = p;
		playerSkills = (player.attackSkills);

		//Sets commands
		commandSet.add("a");
		commandSet.add("i");
		commandSet.add("in");
		commandSet.add("f");
		commandSet.add("help");
		
		System.out.println("Adventurer: Oh by the Gods! What is that thing!?");
		System.out.println("Narrator: You turn your head to find a " + mob.name + " behind you! \n" 
				+ "\t You draw your " + player.weapon.name + " and prepare for a battle!");
		System.out.println("TIP: To find out what commands you can input, type 'help' in the command line");
		
		while (mob.healthPoints > 0 && player.healthPoints > 0) {
			
			System.out.println("\nYour HP: " + player.healthPoints + "\t" + mob.name + " HP: " + mob.healthPoints + "\n");
			
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
		}
		if (player.healthPoints <= 0) {
			System.out.println("Narrator: You took a fatal hit from " + mob.name + ". Your bady is left for the "
					+ "vultures...");
			System.out.println("GAME OVER");
			combatCommand.close();
		}
		
		else if (mob.healthPoints <= 0) {
			System.out.println("You have slain the " + mob.name);
			combatCommand.close();
		}
	}
	
	public void attackCommand() {
		//Scanner attackCommand = new Scanner(System.in);
		int playerDmg = 0;	// total damage player deals
		boolean stop = false;
		String attackDescription = null;
		while (stop == false) {
			boolean errCounter = true;
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
				if (input.equals(skill2.name)) {playerDmg = (skill2.damage) + (player.weapon.damage); 
												stop = true;
												errCounter = false;
												attackDescription = skill2.skillDescription;}
			}
			if (errCounter == true) {
				System.out.println("Invalid Skill.\nPlease check your spelling.");
			}
		}	
		
		player.healthPoints -= mob.baseDamage;
		
		System.out.println(attackDescription);
		System.out.println("Narrator: You dealt: " + playerDmg + " damage!");
		mob.healthPoints -= playerDmg;
		
		if (mob.healthPoints > 0) {
			System.out.println("\nThe " + mob.name + " lunged at you!\n");
			System.out.println("Narrator: You received " + mob.baseDamage + " damage.");
			player.healthPoints -= mob.baseDamage;
		}
	}
	
	public void inventoryCommand() {
		player.inventory.displayInventory();
		System.out.println("\nUsing items is not available in the demo\n");
		
	}
	
	public boolean inspectCommand() {
		System.out.println("You take a moment to inspect your opponent. Here is what you see... \n");
		System.out.println(mob.description);
		return true;
	}
	
	public boolean fleeCommand() {
		System.out.println("Adventurer: YOU COWARD! DO NOT RUN AWAY! I DON'T WANT TO DIE!");
		player.healthPoints -= mob.baseDamage;
		System.out.println("\nThe " + mob.name + " lunged at you!\n");
		System.out.println("Narrator: You received " + mob.baseDamage + " damage.");
		return true;
	}
	
	public boolean helpCommand() {
		System.out.println("Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n");
		return true;
	}
		
}
