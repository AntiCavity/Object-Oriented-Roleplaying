package game;
import java.util.HashMap;
import java.util.*;

public class Inventory {
	
	HashMap<Item, Integer> inventory = new HashMap<Item, Integer>();	//Key = Item; Value = quantity of Item
		// Note for Blake; Hashmaps do not allow for duplicate keys
	
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
	
	public void useItem(Item item) {
		if (inventory.containsKey(item)) { // if there is an item in the inventory
			int oldQuantity = inventory.get(item);
			int newQuantity = oldQuantity - 1 ;
			inventory.replace(item, oldQuantity, newQuantity);
			
			if (inventory.get(item) == 0) {inventory.remove(item, 0);}	// if item count == 0, remove from inventory
		}
		else {
			String itemName = item.name;
			String output = String.format("You dont have any more %s in your inventory.", itemName); // prints if item does not exist in inventory
			System.out.println(output);
		}
	}
	
	public boolean displayInventory() { // displays inventory to screen
		// Displays Player Inventory ??
		Iterator inventoryIterator = inventory.entrySet().iterator();
		
		System.out.println("\t*** Inventory ***");
		inventory.forEach((item,quantity) -> System.out.println("\t" + item.name + " : " + quantity));
		System.out.println("\t*****************");
		// we should also display equiped items here once we decide if we are doing that here or in the character class
		return true;
	}
	
	public void equipArmor(Armor armor) {
		//TODO
	}
	
	public void equipWeapon (Weapon weapon) {
		//TODO
	}

}
