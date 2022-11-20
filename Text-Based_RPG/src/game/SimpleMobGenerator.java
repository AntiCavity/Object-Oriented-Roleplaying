package game;
import java.lang.Math;

public class SimpleMobGenerator {
	
	// we have to make sure that all these arrays are always the same length, this could be a unit test we implement later

	String[] simpleMobs = {"Skeleton Knight", "Cave Spider", "Giant Wasp", "Undead", "Bandit"};
	int[] simpleMobHealth = {50, 40, 40, 25, 35};
	int[] simpleMobDamage = {20, 15, 20, 15, 20};
	String[] simpleMobDescription = {"A skeleton who wears the armor from a Kingdom lost to time...", "A giant hairy cave spider that wants you as it's next meal!",
			"A giant wasp that flaps it's wings so fierce it almost knocks you of your feet!", "Someone who was cursed to wake up from their eternal slumber to serve the "
					+ "evil necromancer.", "A bandit hellbent on taking your coin no matter the cost!"};
	
	public SimpleMob createRandomEncounter(int lvl) {
		// This function should take a random mob and create an Object of said mob for the player to encounter
		int randIndex = (int)(Math.random() * simpleMobs.length);
		SimpleMob mob = new SimpleMob(simpleMobs[randIndex],simpleMobDescription[randIndex],simpleMobDamage[randIndex], simpleMobHealth[randIndex], lvl); // instantiates mob Object, and sets attributes
		mob.healthPoints = (mob.healthPoints) * (mob.level);
		return mob;
	}
	
}
