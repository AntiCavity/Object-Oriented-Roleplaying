import java.util.Dictionary;
import java.util.Hashtable;
import java.util.*;

public class Inventory {
	
	Dictionary<Item, Integer> inventory;	//Key = Item; Value = quantity of Item
	
	public void addItem(Item item, int quantity){
		inventory.put(item, quantity);
	}
	
	public void useItem(Item item) {
		String itemName = item.name;
		try {
			inventory.get(item);
		} catch (NullPointerException e) {
			System.out.println("The item is not in your inventory.");
		}
		if (inventory.get(item) == 0) {
			int newQuantity;
			newQuantity = inventory.get(item) - 1;
			inventory.put(item, newQuantity);
		}
		else {
			String output = String.format("You dont have any more %s in your inventory.", itemName);
			System.out.println(output);
		}
	}
	
	public void displayInventory() {
		//TODO
	}

}
