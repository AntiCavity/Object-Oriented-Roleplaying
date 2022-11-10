
public class SimpleMob {
	
	String name;
	String description;
	int baseDamage;
	int healthPoints;
	Skills[] mobAttackSkills;
	
	public int attack() {
		return baseDamage;
	}
	
	public SimpleMob(String name, String description, int baseDamage, int healthPoints) {
		this.name = name;
		this.description = description;
		this.baseDamage = baseDamage;
		this.healthPoints = healthPoints;
	}

}
