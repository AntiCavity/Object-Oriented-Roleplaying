import java.util.Dictionary;
import java.util.Hashtable;
import java.util.*;

public class Character {

	String name;
	int healthPoints;
	int level;
	Dictionary<String, List[]> attackSkills;
	int energy;
	Armor armor;
	// armor adds health points to the character for now
	Object debuff;
	Object buff;
	String CharClass;
	
	public void attack(Object target, Object attackSkill) {
		//TODO
		
		// apply damage, debuff, buff or whatever stats is in attackSkill
	}
	
	public void chooseCharClass(String charClass) {
		//TODO
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
public class Skills {
	
	String name;
	
	int damage;
	
	object debuff;
	
	object buff;
	
	int energyCost;
	
	int heal;
	
	
	skillConstructor(attributes)
	
*/

	