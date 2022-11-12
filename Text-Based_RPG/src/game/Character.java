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
	
	String[] archerArmorDes = {};
	String[] archerWeapon = {};
	
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
	
	/*
	
	public void chooseCharClass(String charClass) {
		CharacterClass cc = new CharacterClass();
		cc.chooseClass(charClass);
	}
	
	*/
	
	// Add other class Armor and Weapons here
		//TODO
	
	
	public Character chooseClass(String s) {
		if (s.equals("Rogue") || s.equals("rogue") || s.equals("r")) {
			Character rogueCharacter = new Character();
			rogueCharacter.rogueClassSetUp();	
			return rogueCharacter;
		}
		System.out.println("should not be here!");
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
	
	public void createNewInventory() {
		this.inventory = new Inventory();
	}

}



	