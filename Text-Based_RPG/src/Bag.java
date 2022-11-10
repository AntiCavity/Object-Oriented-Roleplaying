
public class Bag {
	//Loot bag class

	Item loot;
	
	//Are we implementing Gold??
	
	//need more ideas for drops
	
	String[] itemList = {"Health Potion", "Mana Potion"};
	
	public Item randomLootDrop() {
		int diceRoll = 0 + (int)(Math.random() * ((itemList.length - 0) + 1));
		String itemName = itemList[diceRoll];
		// TODO implement if statements for every item and properly initialize it and then return that item 
		// once the item is initialized return it 
		
		return this.loot;
	}
	

}
