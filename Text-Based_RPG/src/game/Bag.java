package game;
import java.util.*;

public class Bag {
	//Loot bag class

	Potion loot;
	HashSet<Potion> itemSet = new HashSet<Potion>();
	
	
	public void itemSetConstructor() {
		String name = "Mana Potion";
		String info = "This green looking liquid smells vile! It reminds you of the farms "
			+ "that are to the east.";
		Potion manaPotion = new Potion();
		manaPotion.name = name;
		manaPotion.itemDescription = info;

		String Hname = "Health Potion";
		String Hinfo = "This red liquid is said to hold healing properties that heal any "
			+ "type of wounds! Just don't loose a limb or your head...";
		Potion healthPotion = new Potion();
		healthPotion.name = Hname;
		healthPotion.itemDescription = Hinfo;
		healthPotion.healPoints = 30;
		
		
		this.itemSet.add(healthPotion);
		this.itemSet.add(manaPotion);
		
	}
	
	//Are we implementing Gold??
	
	//need more ideas for drops
	
	
	public Potion randomLootDrop() {
		
		Potion[] itemName = (Potion[]) itemSet.toArray();
		int diceRoll = 0 + (int)(Math.random() * ((itemName.length - 0) + 1));
		// TODO implement if statements for every item and properly initialize it and then return that item 
		// once the item is initialized return it 
		this.loot = itemName[diceRoll];
		return this.loot;
	}
	

}
