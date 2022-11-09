import java.util.Dictionary;
import java.util.Hashtable;
import java.util.*;

public class Character {

	String name;
	int healthPoints;
	//int level; // removing for now...
	Skills[] attackSkills; // Skills list
	int mana;
	Armor armor;
	Weapon weapon;
	// armor adds health points to the character for now...
	Object debuff;
	Object buff;
	String CharClass;
	
//	public void attack(Object target, Object attackSkill) {
//		//TODO
//		
//		// apply damage, debuff, buff or whatever stats is in attackSkill
//	}
	
	public int attack(Skills attackSkill) {	// returns int for combatManager class.
	//TODO
		return weapon.damage + attackSkill.damage;
	// apply damage, debuff, buff or whatever stats is in attackSkill
}
	
	public void chooseCharClass(String charClass) {
		CharacterClass cc = new CharacterClass();
		cc.chooseClass(charClass);
	}
	

}



	