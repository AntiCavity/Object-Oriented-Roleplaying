package game;
import java.util.HashMap;
import java.util.*;

public class Inventory {
	
	private static Inventory inventory_instance = null;
	
	public HashMap<Item, Integer> inventory;
	//public HashSet<String> itemSet;
	
	private Inventory() {
		inventory = new HashMap<Item, Integer>();
		//itemSet = new HashSet<String>();
	}
	
	public static Inventory getInstance() {
		if (inventory_instance == null) {inventory_instance = new Inventory();}
			return inventory_instance;
	}
	
	public void addItem(Item item, int quantity){
		if (inventory.containsKey(item)) {	// if item exists in inventory, adds to quantity of item in inventory
			int oldQuantity = inventory.get(item);
			int newQuantity = oldQuantity + quantity;
			inventory.replace(item, oldQuantity, newQuantity);
		}
		else {
			inventory.put(item, quantity);
		}
	}
	
	public Character useItem(Character player, Item item) {
		//System.out.println(item.getClass().getName());
		if (inventory.containsKey(item)) { // if there is an item in the inventory
			int oldQuantity = inventory.get(item);
			int newQuantity = oldQuantity - 1 ;
			inventory.replace(item, oldQuantity, newQuantity);
			
			if (inventory.get(item) == 0) {inventory.remove(item, 0);}	// if item count == 0, remove from inventory
		}
		
//		else {
//			String itemName = item.name;
//			String output = String.format("You dont have any %s in your inventory.", itemName); // prints if item does not exist in inventory
//			System.out.println(output);
//		}
		
		useItemType(player, item);
		return player;
	}
	
	public boolean displayInventory() { 
		// Displays Player Inventory
		// Iterator inventoryIterator = inventory.entrySet().iterator();
		System.out.println("\t*** Inventory ***");
		inventory.forEach((item,quantity) -> System.out.println("\t" + item.name + " : " + quantity));
		System.out.println("\t*****************");
		// we should also display equiped items here once we decide if we are doing that here or in the character class
		return true;
	}
	

	public void useItemType(Character player, Item item) {
		String itemType = item.getClass().getName();
		//Type checks item, and executes appropriate method for item Type.
		if (itemType.equals("game.Potion")) {
			usePotion(player, (Potion) item);
		}
		if (itemType.equals("game.Weapon")) {
			equipWeapon(player, (Weapon) item);
		}
		if (itemType.equals("game.Armor")) {
			equipArmor(player, (Armor) item);
		}
	}
	
	public Character usePotion(Character player, Potion item) {
		player.healthPoints += item.healPoints;
		player.mana += item.manaRestore;
		
		return player;
	}
	
	public Character equipArmor(Character player, Armor newArmor) {
		//Takes player's armor currently equiped, adds it to their inventory, and then player equips armor selected from inventory
		Armor oldArmor = player.armor;
		player.inventory.addItem(oldArmor, 1);
		player.armor = newArmor;
		player.healthPoints += player.armor.damageProtection; //implements armor protection
		
		System.out.println("You equiped "+ newArmor.name+ ".");
		System.out.println(newArmor.itemDescription);
		
		return player;
	}
	
	public Character equipWeapon (Character player, Weapon newWeapon) {
		//Takes player's weapon currently equiped, adds it to their inventory, and then player equips weapon selected from inventory
		Weapon oldWeapon = player.weapon;
		player.inventory.addItem(oldWeapon, 1);
		player.weapon = newWeapon;
		
		System.out.println("You equiped "+ newWeapon.name+ ".");
		System.out.println(newWeapon.itemDescription);
		
		return player;
	}
	
}
