package game;
import java.util.*;

public class Bag {
	//Loot bag class

	Potion loot;
	//HashSet<Potion> itemSet = new HashSet<Potion>();
	
	/*
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
	*/
	
	//Are we implementing Gold??
	
	//need more ideas for drops
	
	
	public void randomLootDrop(Character character) {
		
		int diceRoll = (int)(Math.random()*(2-1+1)+1);  
		if (diceRoll == 1){
			character.addHealPotion(1);
		}
		else if (diceRoll == 2) {
			character.addManaPotion(1);
		}
		
	}
	

}
