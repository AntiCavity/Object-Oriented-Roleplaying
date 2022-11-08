import java.util.Dictionary;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.*;

public class Inventory {
	
	HashMap<Item, Integer> inventory;	//Key = Item; Value = quantity of Item
		// Note for Blake; Hashmaps do not allow for duplicate keys
	
	public void addItem(Item item, int quantity){
		if (inventory.containsKey(item)) {	// if item exists in inventory, adds to quantity of item in inventory
			int oldQuantity = inventory.get(item);
			int newQuantity = oldQuantity + quantity;
			inventory.replace(item, oldQuantity, newQuantity);
		}
		else {	// adds new item to inventory
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
	
	public void displayInventory() { // displays inventory to screen
		System.out.println("*** Inventory ***");
		System.out.println(inventory);
		System.out.println("*****************");
	}
	
	public void equipArmor(Armor armor) {
		//TODO
	}
	
	public void equipWeapon (Weapon weapon) {
		//TODO
	}

}
