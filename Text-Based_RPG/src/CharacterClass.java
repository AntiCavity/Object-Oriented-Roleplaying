import java.util.Dictionary;
import java.util.List;


public class CharacterClass {
	
	// we might need to make something with the skills like their own type for example or even another class
	// Dictionary<String, List[]> attackSkills;
	
	Character character = new Character();

	String[] classes = {"Rogue", "Archer", "Warrior", "Knight", "Wizard", "Bastard"};
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public void chooseClass(String s) {
		// if string is == to one of the classes, makes the character into said class and assigns the right items
		// if != then returns an error message and prompts the user in narrator to reselect their class
		if (s == "Rogue" ) {
			// add a dagger to the characters bag and equip
			// add thieves guild armor to characters bag and equip
			// add 2 potions to bag
			// add rogue attack skills
		}
	}
	

}
