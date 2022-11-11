import java.lang.Math;

public class SimpleMobGenerator {
	
	// we have to make sure that all these arrays are always the same length, this could be a unit test we implement later

	String[] simpleMobs = {"Skeleton Knight", "Cave Spider", "Giant Wasp", "Undead", "Bandit"};
	int[] simpleMobHealth = {50, 40, 35, 25, 35};
	int[] simpleMobDamage = {10, 10, 20, 5, 20};
	String[] simpleMobDescription = {"A knight from a Kingdom lost in time", "A giant hairy cave spider that wants you as it's next meal",
			"A giant wasp that nests in the forests to the north.", "Someone who was cursed to wake up from their eternal sleep to serve the "
					+ "evil necromancer.", "A bandit hellbent on taking your coin no matter the cost!"};
	
	public SimpleMob createRandomEncounter() {
		// This function should take a random mob and create an Object of said mob for the player to encounter
		int randIndex = (int)(Math.random() * simpleMobs.length);
		SimpleMob mob = new SimpleMob(simpleMobs[randIndex],simpleMobDescription[randIndex],simpleMobDamage[randIndex], simpleMobHealth[randIndex]); // instantiates mob Object, and sets attributes
		return mob;
	}
	
}
