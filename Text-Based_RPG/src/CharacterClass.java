import java.util.Dictionary;
import java.util.List;


public class CharacterClass {
	Inventory inventory;
	Character character = new Character();
	// we might need to make something with the skills like their own type for example or even another class
	// Dictionary<String, List[]> attackSkills;

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
	
	
	public void chooseClass(String s) {
		// if string is == to one of the classes, makes the character into said class and assigns the right items
		// if != then returns an error message and prompts the user in narrator to reselect their class
		if (s == "Rogue" || s == "rogue" || s == "r") {
			rogueClassSetUp();
		}
	}
	public void addArmor(Armor armor, int quantity) {
		inventory.addItem(armor, quantity);
		character.armor = armor;
	}
	public void addWeapon(Weapon weapon, int quantity) {
		inventory.addItem(weapon, quantity);
		character.weapon = weapon;
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
		
		inventory.addItem(healthPotion, quantity);	//adds item to player inventory
		
	}
	public void addManaPotion(int quantity) {
		//Builds Mana Potion Object//
		String name = "Mana Potion";
		String info = "This green looking liquid smells vile! It reminds you of the farms "
				+ "that are to the east.";
		Potion manaPotion = new Potion();
			manaPotion.name = name;
			manaPotion.itemDescription = info;
			
		inventory.addItem(manaPotion, quantity);
	}

	public void rogueClassSetUp() {
		// add a dagger to the characters bag and equip
					// add thieves guild armor to characters bag and equip
					Armor rogueArmor = new Armor();
						rogueArmor.name = rogueArmorInfo[0];
						rogueArmor.itemDescription = rogueArmorInfo[1];
						rogueArmor.damageProtection = 5;
						int[] resistance = {0,0,0};	//{poisonResistance, bleedResistance, magicResistance}
						rogueArmor.armorResistance = resistance;
					addArmor(rogueArmor,1);
					
					Weapon roguesDagger = new Weapon();
						roguesDagger.name = rogueWeaponInfo[0];
						roguesDagger.itemDescription = rogueWeaponInfo[1];
						roguesDagger.damage = 12;
						roguesDagger.critChance = 0; //TODO
					addWeapon(roguesDagger, 1);
					
					addHealPotion(2);
					addManaPotion(2);

					character.healthPoints = 75;
					character.mana = 30;
					character.CharClass = "Rogue";
					
					// create rogue attack skills // 
					Skills backStab = new Skills();	// Special Skill //
						backStab.name = "Back Stab";
						backStab.skillDescription = "You swiftly sidestep the opponent landing a sharp blow to the opponent's back"
								+ "stealing some lifeforce in the process.";
						backStab.damage = 20;
						backStab.energyCost = 5; // Should subract from character.mana
						backStab.heal = 3; // Small amount of health is restored and subtract from mob.health
						
					Skills slash = new Skills(); // Standard Skill //
						slash.name = "Slash";
						String sD = String.format("You use your %s to attack the enemy!", character.weapon);
						slash.skillDescription = sD;
						slash.damage = character.weapon.damage;	// uses player weapon damage //
						slash.energyCost = 0;
					
					Skills[] rogueSkillSet = {slash, backStab};
					character.attackSkills = rogueSkillSet;
					// Need more skill IDEAS!
						//TODO
	}
}
