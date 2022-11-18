package game;

public class SimpleMob extends Mob{
	
//	int level;
//	String name;
//	String description;
//	int baseDamage;
//	int healthPoints;
//	Skills[] mobAttackSkills;
	
	public int attack() {
		return baseDamage;
	}
	
	public SimpleMob(String name, String description, int baseDamage, int healthPoints, int lvl) {
		this.level = lvl;
		this.name = name;
		this.description = description;
		this.baseDamage = baseDamage;
		this.healthPoints = healthPoints;
	}

}
