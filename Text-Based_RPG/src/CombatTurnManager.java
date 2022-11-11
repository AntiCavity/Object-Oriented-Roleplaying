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
		
		while (mob.healthPoints > 0) {
			String input = combatCommand.nextLine();
			if (player.healthPoints < 1) {
				System.out.println("Narrator: You took a fatal hit from " + mob.name + ". Your bady is left for the "
						+ "vultures...");
				System.out.println("GAME OVER");
				combatCommand.close();
				break;
			}
			
			System.out.println("Narrator: What do you want to do?");
			
			if (!commandSet.contains(input)) {
				System.out.println("That's an invalid command! To find out what commands you can input, type 'help' in the command line");
			}
			else if (input.equals("a")) {attackCommand();}
			else if (input.equals("i")) {inventoryCommand();}
			else if (input.equals("in")) {inspectCommand();}
			else if (input.equals("f")) {fleeCommand();}
			else if (input.equals("help")) {helpCommand();}
		}
		
	}
	
	public void attackCommand() {
		//Scanner attackCommand = new Scanner(System.in);
		int playerDmg = 0;	// total damage player deals
		boolean stop = false;
		String attackDescription = null;
		
		while (stop == false) {
		Iterator<Skills> skills = playerSkills.iterator();
			while(skills.hasNext()) {	// Prints out skills available for player to use
				Skills skill = skills.next();
				System.out.println(skill.name);
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
												attackDescription = skill2.skillDescription;}
			}
		}	
		mob.healthPoints -= playerDmg;
		player.healthPoints -= mob.baseDamage;
		
		System.out.println(attackDescription);
		System.out.println("Narrator: You dealt: " + playerDmg + " damage!");
		System.out.println("The " + mob.name + " lunged at you!");
		System.out.println("Narrator: You received: " + mob.baseDamage + " damage.");
		
	}
	
	public void inventoryCommand() {
		player.inventory.displayInventory();
		String input = combatCommand.nextLine();
		
	}
	
	public boolean inspectCommand() {
		System.out.println("You take a moment to inspect your opponent. Here is what you see... \n");
		System.out.println(mob.description);
		return true;
	}
	
	public boolean fleeCommand() {
		System.out.println("Adventurer: YOU COWARD! DO NOT RUN AWAY! I DON'T TO DIE!");
		player.healthPoints -= mob.baseDamage;
		System.out.println("The " + mob.name + " lunged at you!");
		System.out.println("Narrator: You received: " + mob.baseDamage + " damage.");
		return true;
	}
	
	public boolean helpCommand() {
		String help = "Commands you can type:\n\t a: Attack\n\t i: Inventory\n\t in: Inspect\n\t f: Flee\n";
		return true;
	}
		
}
