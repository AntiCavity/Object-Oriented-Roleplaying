package game;

public class Potion extends Item {
	
	private static Potion potion_instance;
	
	int healPoints; //How much health is restored
	int manaRestore; //How much energy is restored
	int increaseDamage; //How much damage is increased

	static Potion healthPotion;
	static Potion manaPotion;
	static Potion strengthPotion;
	
	private Potion() {}
	
	public static Potion getInstance() {
		if (potion_instance == null) {
			potion_instance = new Potion(); 
			makePotions();
		}
			return potion_instance;
	}
	
	public static void makePotions() {
		healthPotion = new Potion();	//Creates healthPotion
			String name = "Health Potion";
			String info = "This red liquid is said to hold healing properties that heal any "
				+ "type of wounds! Just don't loose a limb or your head...";
			healthPotion.name = name;
			healthPotion.itemDescription = info;
			healthPotion.healPoints = 30;
		manaPotion = new Potion();	//Creates manaPotion
			name = "Mana Potion";
			info = "This green looking liquid smells vile! It reminds you of the farms "
				+ "that are to the east.";
			manaPotion.name = name;
			manaPotion.itemDescription = info;
			manaPotion.manaRestore = 15;
			
		//TODO Need to implement	
		strengthPotion = new Potion();
			name = "Strength Potion";
			info = "This orange liquid was said to have been harvested from the Holy Tree located in the abandoned church beyond the Great Wall."
					+ "\nTo possess such an item is unheard of...";
			strengthPotion.name = name;
			strengthPotion.itemDescription = info;
			strengthPotion.manaRestore = 10;
			strengthPotion.increaseDamage = 20;
		
	}
	
	public Potion addHealthPotion() {
		return healthPotion;
	}
	public Potion addManaPotion() {
		return manaPotion;
	}
}
