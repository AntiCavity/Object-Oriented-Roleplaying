package game;

import java.util.*;
import java.io.*;

public class Character {

	// I think we should merge CharacterClass and Character
	
	// Should we store equiped armor inside the Character or the Inventory??
	
	String name;
	int healthPoints;
	//int level;
	HashSet<Skills> attackSkills; // Skills list
	int mana;
	Armor armor;
	Weapon weapon;
//	Object debuff;
//	Object buff;
	String CharClass;
	Inventory inventory;
	Potion potion;
	
	
	// CharClass attributes
	
	String[] classes = {"Rogue", "Archer", "Warrior", "Knight", "Mage", "Bastard"};
	
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
	
	String[] knightArmorDes = {"Knightly Plate Armor", "Armor made of Steel Plates, along with a sigil signifying the wearer's noble status."};
	
	String[] knightWeaponDes = {"Steel Bastard Sword", "A Bastard Sword, able to be wielded one or two handed, made out of the finest steel Araluen has to offer."
			+ "This is the weapon a knight trains with from the age of 9, with and without a shield."};
	
	String[] wizardArmorDes = {"Mage Robes", "Typical robes which are standard to a wizard such as yourself, enchanted to resist magic"};
	
	String[] wizardWeaponDes = {"Mage Staff", "Standard issue mage staff from the Mage college of Araluen, Allows you to cast basic spells"};
	
	String[] peasantArmorDes = {"Tattered Rags", "You lost everything, and the only thing you have is what is on your back"};
    
    String[] peasantWeaponDes = {"Pitchfork", "This is the only thing they let you keep"};
	
	
	// Add other class Armor and Weapons here
		//TODO
	
//	public void attack(Object target, Object attackSkill) {
//		//TODO
//		
//		// apply damage, debuff, buff or whatever stats is in attackSkill
//	}
	
	/* unused command
	public int attack(Skills attackSkill) {	// returns int for combatManager class.
	//TODO
		return attackSkill.damage;
	// apply damage, debuff, buff or whatever stats is in attackSkill
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
		else if (s.equals("Warrior") || s.equals("warrior") || s.equals("w")) {
			Character warriorCharacter = new Character();
			warriorCharacter.warriorClassSetUp();	
			return warriorCharacter;
		}
		
		else if (s.equals("Archer")|| s.equals("archer") || s.equals("a")) {
			Character archerCharacter = new Character();
			archerCharacter.archerClassSetUp();	
			return archerCharacter;
		}
		
		else if (s.equals("Knight")|| s.equals("knight") || s.equals("k")) {
			Character knightCharacter = new Character();
			knightCharacter.knightClassSetup();
			return knightCharacter;
		}
		
		else if (s.equals("Mage")|| s.equals("mage") || s.equals("m")) {
			Character mageCharacter = new Character();
			mageCharacter.wizardClassSetup();
			return mageCharacter;
		}
		
		else if (s.equals("Peasant")|| s.equals("peasant") || s.equals("p")) {
			Character peasantCharacter = new Character();
			peasantCharacter.peasantClassSetup();
			return peasantCharacter;
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
		System.out.println("healthPotion");
		//builds Healing Potion Object//
//		String name = "Health Potion";
//		String info = "This red liquid is said to hold healing properties that heal any "
//				+ "type of wounds! Just don't loose a limb or your head...";
		Potion healthPotion = Potion.getInstance();
			healthPotion = healthPotion.addHealthPotion();
		this.inventory.addItem(healthPotion, quantity);	//adds item to player inventory
		
	}
	public void addManaPotion(int quantity) {
		System.out.println("manaPotion");
		//Builds Mana Potion Object//
//		String name = "Mana Potion";
//		String info = "This green looking liquid smells vile! It reminds you of the farms "
//				+ "that are to the east.";
		Potion manaPotion = Potion.getInstance();
			manaPotion = manaPotion.addManaPotion();
			
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
						roguesDagger.damage = 20;
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
						backStab.damage = 35;
						backStab.energyCost = 15; // Should subract from character.mana
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
		createNewInventory();
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
		FullDraw.damage = (int) (this.weapon.damage + (this.weapon.damage * 0.5)); // High Damage but also has a High Mana cost, should be used sparingly
		FullDraw.energyCost = 10; // Should subract from character.mana
		FullDraw.heal = 0; // No lifesteal in the Archers skillset
		
		Skills Shoot = new Skills(); // Basic Skill //
		Shoot.name = "Shoot";
		String sd = String.format("You draw and shoot an arrow from your %s", this.weapon.name);
		Shoot.skillDescription = sd;
		Shoot.damage = this.weapon.damage;
		Shoot.energyCost = 0;
		
		HashSet<Skills> archerSkillSet = new HashSet<>();//{slash, backStab};
		archerSkillSet.add(Shoot);
		archerSkillSet.add(FullDraw);
		
		this.attackSkills = archerSkillSet;
	}
	
	public void warriorClassSetUp() {
		createNewInventory();
		Armor warriorArmor = new Armor();
			warriorArmor.name = warriorArmorDes[0];
			warriorArmor.itemDescription = warriorArmorDes[1];
			warriorArmor.damageProtection = 1;
			int[] resistance = {0,0,0};	//{poisonResistance, bleedResistance, magicResistance}
			warriorArmor.armorResistance = resistance;
		
		addArmor(warriorArmor, 1);
		
		Weapon twinScimitars = new Weapon();
			twinScimitars.name = warriorWeaponDes[0];
			twinScimitars.itemDescription = warriorWeaponDes[1];
			twinScimitars.damage = 30;
			twinScimitars.critChance = 0; // These should be high crit too
		
		addWeapon(twinScimitars, 1);
		
		this.addHealPotion(2);
		this.addManaPotion(2);
		
		this.healthPoints = 100;
		this.mana = 15;
		this.CharClass = "Warrior";
		
		Skills BloodBath = new Skills();
			BloodBath.name = "Blood Bath";
			String sd = String.format( "You cut yourself with your %s "
					+ "and use the resulting adrenaline to unleash a whirlwind of attacks on your enemy", this.weapon.name);
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
	
	
	public void knightClassSetup() {
		createNewInventory();
		Armor PlateArmor = new Armor();
			PlateArmor.name = knightArmorDes[0];
			PlateArmor.itemDescription = knightArmorDes[1];
			PlateArmor.damageProtection = 50;
			int[] resistance = {5,5,5};	//{poisonResistance, bleedResistance, magicResistance}
			PlateArmor.armorResistance = resistance;
		
		addArmor(PlateArmor, 1);
		
		Weapon BastardSword = new Weapon();
			BastardSword.name = knightWeaponDes[0];
			BastardSword.itemDescription = knightWeaponDes[1];
			BastardSword.damage = 25;
			BastardSword.critChance = 0;
		
		addWeapon(BastardSword, 1);
		
		this.addHealPotion(2);
		this.addManaPotion(2);
		
		this.healthPoints = 100;
		this.mana = 20;
		this.CharClass = "Knight";
		
		Skills Cleave = new Skills();
			Cleave.name = "Executioner's cleave";
			String sd = String.format( "You heave your %s "
					+ "and put your entire soul into bring justice down on your foe", this.weapon.name);
			Cleave.skillDescription = sd;
			Cleave.damage = this.weapon.damage * 2; // This costs all of your mana so you should only use it in dire straits
			Cleave.energyCost = 20;
			Cleave.heal = 0; //This might be a neat work around
			
		Skills Thrust = new Skills();
		
			Thrust.name = "Thrust";
			String XD =  String.format("You hold your %s in half-sword, and you thrust at your enemy", this.weapon.name);
			Thrust.skillDescription = sd;
			Thrust.damage = this.weapon.damage;
			Thrust.energyCost = 0;
			Thrust.heal = 0;
			
		HashSet<Skills> knightSkillSet = new HashSet<>();//{slash, backStab};
		knightSkillSet.add(Thrust);
		knightSkillSet.add(Cleave);
			
		this.attackSkills = knightSkillSet;
	
		
		
	}
	
	public void wizardClassSetup() {
		createNewInventory();
		Armor wizardRobe = new Armor();
		wizardRobe.name = wizardArmorDes[0];
		wizardRobe.itemDescription = wizardArmorDes[1];
		wizardRobe.damageProtection = 5;
		int[] resistance = {5,0,10};
		wizardRobe.armorResistance = resistance;
		
		addArmor(wizardRobe, 1);
		
		
		Weapon mageStaff = new Weapon();
		mageStaff.name = wizardWeaponDes[0];
		mageStaff.itemDescription = wizardWeaponDes[1];
		mageStaff.damage = 20;
		mageStaff.critChance = 0;
		
		
		addWeapon(mageStaff, 1);
		
		this.addHealPotion(2);
		this.addManaPotion(2);
		
		this.healthPoints = 50;
		this.mana = 50;
		this.CharClass = "Wizard";
		
		Skills MagicMissle = new Skills();
		createNewInventory();
		// This should be the main skill the wizard uses having them be thirsty for mana but deal high damage
			MagicMissle.name = "Magic Missle";
			MagicMissle.damage = (int) (this.weapon.damage + (this.weapon.damage * 0.75));
			String skillsDes = String.format("You pour mana into your %s and say the incantations. \nLOREM IPSUM DOLOR SIT AMET! \nWhich unleashes missles of pure mana at your foe", this.weapon.name);
			MagicMissle.skillDescription = skillsDes;
			MagicMissle.energyCost = 10;
			MagicMissle.heal = 0;
			
		Skills Thwack = new Skills();
			//Trash ass skill for if you cant manage your mana that well/finishing off opponents
			Thwack.name = "Thwack";
			Thwack.damage = this.weapon.damage/2;
			String skillD = String.format("You take your %s and you thwack your foe upside the head", this.weapon.name);
			Thwack.skillDescription = skillD;
			Thwack.energyCost = 0;
			Thwack.heal = 0;
			
		HashSet<Skills> wizardSkillSet = new HashSet<>();
		wizardSkillSet.add(Thwack);
		wizardSkillSet.add(MagicMissle);
		
		this.attackSkills = wizardSkillSet;
		
	}
	public void peasantClassSetup() {
		createNewInventory();
        Armor peasantRags = new Armor();
            peasantRags.name = peasantArmorDes[0];
            peasantRags.itemDescription = peasantArmorDes[1];
            peasantRags.damageProtection = 0;
            int[] resistance = {0,0,0};
            peasantRags.armorResistance = resistance;
            
        addArmor(peasantRags, 1);
            
        Weapon pitchfork = new Weapon();
            pitchfork.damage = 10;
            pitchfork.critChance = 0;
            pitchfork.name = peasantWeaponDes[0];
            pitchfork.itemDescription = peasantWeaponDes[1];
        
        addWeapon(pitchfork, 1);
        
        this.addHealPotion(2);
        this.addManaPotion(2);
        
        this.healthPoints = 50;
        this.mana = 20;
        this.CharClass = "Peasant";
        
        
        Skills proletariatFury = new Skills();
            proletariatFury.damage = this.weapon.damage * 4;
            proletariatFury.heal = -5;
            proletariatFury.name = "Proletariat's Fury";
            String pDes = String.format("You channel all the hate for the system that ruined your life."
                + "/nThe anger gives you strength, firmly gripping your %s, you unleash this anger on your foe", this.weapon.name);
            proletariatFury.skillDescription = pDes;
            proletariatFury.energyCost = 10;
        
        Skills bop = new Skills();
            bop.damage = this.weapon.damage;
            bop.name = "Bop";
            bop.skillDescription = "You bop your foe on the head";
            bop.heal = 0;
            bop.energyCost = 0;
            
        
        
        
            HashSet<Skills> peasantSkillSet = new HashSet<>();
            peasantSkillSet.add(bop);
            peasantSkillSet.add(proletariatFury);    
        
            this.attackSkills = peasantSkillSet;
    }
	
	
	public void createNewInventory() {
		//if there are inventory errors peep this out
		this.inventory = inventory.getInstance();
	}
	
	public void characterLevelUp(int level) {
		this.healthPoints = this.healthPoints + (int) (this.healthPoints * (level * 0.6));
		//this.weapon.damage = (int) (this.weapon.damage * (level * 0.4)); we probably would need to reinitialize every skill once we equip a weapon or level up
		System.out.println("You encounter with this foe has made you a hardier person");
	}

}



	