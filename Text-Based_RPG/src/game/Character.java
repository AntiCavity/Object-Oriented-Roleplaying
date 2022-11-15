package game;

import java.util.*;
import java.io.*;

public class Character {

	// I think we should merge CharacterClass and Character
	
	// Should we store equiped armor inside the Character or the Inventory??
	
	String name;
	int healthPoints;
	//int level; // removing for now...
	HashSet<Skills> attackSkills; // Skills list
	int mana;
	Armor armor;
	Weapon weapon;
	// armor adds health points to the character for now...
	Object debuff;
	Object buff;
	String CharClass;
	Inventory inventory;
	
	
	// CharClass attributes
	
	String[] classes = {"Rogue", "Archer", "Warrior", "Knight", "Wizard", "Bastard"};
	
	String[] rogueArmorInfo = {"Rogue Armor Set", "The black leather and cloth make you "
			+ "invisible in the night. As you look closer, you see the insignia of the "
			+ "Theives Guild printed on the shoulder. Who did this belong to?"};
	String[] rogueWeaponInfo = {"Shadow Dagger", "The dagger emits a dark glow with black " 
			+ "fog appearing from the base of the blade. It looks familiar, but you "
			+ "can't quite remember where you saw it from."};
	
	String[] archerArmorDes = {"Ranger's Cloak", "This signature cloak identifies one as a King's Ranger, handpicked to serve the"
			+ "King as wardens of the various provinces that make up the Kingdom of Araluen"
			+ "The Ranger's Cloak sports a motley pattern of various colors of the forests found in the Kingdom."
			+ "Whoever wears this cloak has gone through rigorous tests to be selected as one of the best archers in the Kingdom."};
	String[] archerWeaponDes = {"Longbow", "This bow has a draw weight of 185 pounts, meaning only very strong individuals can use"
			+ "this weapon effectively, along with the jet black bodkin tipped arrows, only the most sturdy of foes can shrug off an arrow"
			+ "from a Longbow"};
	
	String[] warriorArmorDes = {"Warrior Rags", "These garments are not fit for wearing, much less for battle, at the"
			+ " very least you can move swiftly in them."};
	String[] warriorWeaponDes = {"Twin Scimitars", "These swords, come with a long curve, making them unsuited to thrusting."
			+ "But because of the long curve, they excel at slicing through flesh and bone."};
	
	// Add other class Armor and Weapons here
		//TODO
	
//	public void attack(Object target, Object attackSkill) {
//		//TODO
//		
//		// apply damage, debuff, buff or whatever stats is in attackSkill
//	}
	
	public int attack(Skills attackSkill) {	// returns int for combatManager class.
	//TODO
		return weapon.damage + attackSkill.damage;
	// apply damage, debuff, buff or whatever stats is in attackSkill
}

	
	// Add other class Armor and Weapons here
		//TODO
	
	
	public Character chooseClass(String s) {
		if (s.equals("Rogue") || s.equals("rogue") || s.equals("r")) {
			Character rogueCharacter = new Character();
			rogueCharacter.rogueClassSetUp();	
			return rogueCharacter;
		}
		if (s.equals("Warrior") || s.equals("warrior") || s.equals("w")) {
			Character warriorCharacter = new Character();
			warriorCharacter.warriorClassSetUp();	
			return warriorCharacter;
		}
		
		if (s.equals("Archer")|| s.equals("archer") || s.equals("a")) {
			Character archerCharacter = new Character();
			archerCharacter.archerClassSetUp();	
			return archerCharacter;
		}
		return null;
	}
	public void addArmor(Armor armor, int quantity) {
		inventory.addItem(armor, quantity);
		this.armor = armor;
	}
	public void addWeapon(Weapon weapon, int quantity) {
		inventory.addItem(weapon, quantity);
		this.weapon = weapon;
	}
	public void addHealPotion(int quantity) {
		//builds Healing Potion Object//
		String name = "Health Potion";
		String info = "This red liquid is said to hold healing properties that heal any "
				+ "type of wounds! Just don't loose a limb or your head...";
		Potion healthPotion = new Potion();
			healthPotion.name = name;
			healthPotion.itemDescription = info;
			healthPotion.healPoints = 15;
		
		this.inventory.addItem(healthPotion, quantity);	//adds item to player inventory
		
	}
	public void addManaPotion(int quantity) {
		//Builds Mana Potion Object//
		String name = "Mana Potion";
		String info = "This green looking liquid smells vile! It reminds you of the farms "
				+ "that are to the east.";
		Potion manaPotion = new Potion();
			manaPotion.name = name;
			manaPotion.itemDescription = info;
			
		this.inventory.addItem(manaPotion, quantity);
	}

	public void rogueClassSetUp() {
		// add a dagger to the characters bag and equip
					// add thieves guild armor to characters bag and equip
					createNewInventory();
					Armor rogueArmor = new Armor();
						rogueArmor.name = rogueArmorInfo[0];
						rogueArmor.itemDescription = rogueArmorInfo[1];
						rogueArmor.damageProtection = 5;
						int[] resistance = {0,0,0};	//{poisonResistance, bleedResistance, magicResistance}
						rogueArmor.armorResistance = resistance;
					addArmor(rogueArmor,1);
					
					//Test statement
					//System.out.println("Finished Armor");
					
					Weapon roguesDagger = new Weapon();
						roguesDagger.name = rogueWeaponInfo[0];
						roguesDagger.itemDescription = rogueWeaponInfo[1];
						roguesDagger.damage = 12;
						roguesDagger.critChance = 0; //TODO
					addWeapon(roguesDagger, 1);
					
					//System.out.println("Finished Weapon");
					
					this.addHealPotion(2);
					this.addManaPotion(2);

					this.healthPoints = 75;
					this.mana = 30;
					this.CharClass = "Rogue";
					
					//Test statement
					//System.out.println("Finished Assignments");
					
					// create rogue attack skills // 
					Skills backStab = new Skills();	// Special Skill //
						backStab.name = "Back Stab";
						backStab.skillDescription = "You swiftly sidestep the opponent landing a sharp blow to the opponent's back"
								+ " stealing some lifeforce in the process.";
						backStab.damage = 20;
						backStab.energyCost = 5; // Should subract from character.mana
						backStab.heal = 3; // Small amount of health is restored and subtract from mob.health
						
					Skills slash = new Skills(); // Standard Skill //
						slash.name = "Slash";
						String sD = String.format("You use your %s to attack the enemy!", this.weapon.name);
						slash.skillDescription = sD;
						slash.damage = this.weapon.damage;	// uses player weapon damage //
						slash.energyCost = 0;
					
					HashSet<Skills> rogueSkillSet = new HashSet<>();//{slash, backStab};
						rogueSkillSet.add(slash);
						rogueSkillSet.add(backStab);
						
					this.attackSkills = rogueSkillSet;
					// Need more skill IDEAS!
						//TODO
	}
	
	public void archerClassSetUp() {
		Armor rangerArmor = new Armor();
			rangerArmor.name = archerArmorDes[0];
			rangerArmor.itemDescription = archerArmorDes[1];
			rangerArmor.damageProtection = 5;
			int[] resistance = {1,0,0};	//{poisonResistance, bleedResistance, magicResistance}
			rangerArmor.armorResistance = resistance;
		addArmor(rangerArmor,1);
		
		Weapon Longbow = new Weapon();
			Longbow.name = archerWeaponDes[0];
			Longbow.itemDescription = archerWeaponDes[1];
			Longbow.damage = 20;
			Longbow.critChance = 0; //TODO I believe that the Longbow should have average crit change
		addWeapon(Longbow, 1);
		
		this.addHealPotion(2);
		this.addManaPotion(2);
		
		this.healthPoints = 60;
		this.mana = 30;
		this.CharClass = "Archer";
		
		Skills FullDraw = new Skills();	// Special Skill //
		FullDraw.name = "Full Draw";
		FullDraw.skillDescription = "You nock an arrow and draw with your full might, exhausting you heavily";
		FullDraw.damage = 30; // High Damage but also has a High Mana cost, should be used sparingly
		FullDraw.energyCost = 10; // Should subract from character.mana
		FullDraw.heal = 0; // No lifesteal in the Archers skillset
		
		Skills Shoot = new Skills(); // Basic Skill //
		Shoot.name = "Shoot";
		String sd = String.format("You draw and shoot an arrow from your %s", this.weapon);
		Shoot.skillDescription = sd;
		Shoot.damage = this.weapon.damage;
		Shoot.energyCost = 0;
		
		HashSet<Skills> archerSkillSet = new HashSet<>();//{slash, backStab};
		archerSkillSet.add(Shoot);
		archerSkillSet.add(FullDraw);
		
		this.attackSkills = archerSkillSet;
	}
	
	public void warriorClassSetUp() {
		Armor warriorArmor = new Armor();
			warriorArmor.name = warriorArmorDes[0];
			warriorArmor.itemDescription = warriorArmorDes[1];
			warriorArmor.damageProtection = 1;
		
		addArmor(warriorArmor, 1);
		
		Weapon twinScimitars = new Weapon();
			twinScimitars.name = warriorWeaponDes[0];
			twinScimitars.itemDescription = warriorWeaponDes[1];
			twinScimitars.damage = 30;
			twinScimitars.critChance = 0; // These should be high crit too
		
		addWeapon(twinScimitars, 1);
		
		addHealPotion(2);
		addManaPotion(2);
		
		this.healthPoints = 100;
		this.mana = 15;
		this.CharClass = "Warrior";
		
		Skills BloodBath = new Skills();
			BloodBath.name = "Blood Bath";
			String sd = String.format( "You cut yourself with your %s "
					+ "and use the resulting adrenaline to unleash a whirlwind of attacks on your enemy", this.weapon);
			BloodBath.skillDescription = sd;
			BloodBath.damage = this.weapon.damage + (this.weapon.damage / 2); // getting a weapon upgrade makes this skills damage go up
			BloodBath.energyCost = 5;
			// TODO figure out how to do self damage, this should cost around 10-20 health maybe
			BloodBath.heal = -20; //This might be a neat work around
			
		Skills Swing = new Skills();
		
			Swing.name = "Swing";
			Swing.skillDescription = "You take a swing at your enemy, their pain seemingly healing you as you inflict it";
			Swing.damage = this.weapon.damage;
			Swing.energyCost = 0;
			Swing.heal = this.weapon.damage/3;
			
			HashSet<Skills> warriorSkillSet = new HashSet<>();//{slash, backStab};
			warriorSkillSet.add(Swing);
			warriorSkillSet.add(BloodBath);
			
		this.attackSkills = warriorSkillSet;	
	}
	
	public void createNewInventory() {
		this.inventory = new Inventory();
	}

}



	