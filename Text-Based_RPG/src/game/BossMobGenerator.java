package game;

public class BossMobGenerator {
	String[] bossMobs = {"Skeleton King", "Cave Spider Hive Mind", "Wasp Queen", "Dragon Mother", "Bandit Leader"};
	int[] bossMobHealth = {500, 400, 450, 750, 350};
	int[] bossMobDamage = {40, 40, 45, 60, 30};
	String[] bossMobDescription = {"A skeleton that stands 8 feet tall with a giant cleaver as a weapon! Was there really a creature that lived that was this tall?",
			"This spider looks different from the others... Its bigger, taller, and all the other cave spiders rush to aid it.",
			"It's the queen of all wasps. You heard ghost stories about it when you were a youngling, but know you see the real thing and you can hardly belive your eyes...",
			"This fight seems almost impossible... The dragon is as tall as the mountains! It seems logical to try and run! \nYou can feel the heat of her fire brewing in her belly ready to burn you alive!",
			"This guy looks cocky. He mocks you and how your dressed. Who the hell is this guy?"};
	
	public BossMob createRandomEncounter() {
		// This function should take a random mob and create an Object of said mob for the player to encounter
		int randIndex = (int)(Math.random() * bossMobs.length);
		BossMob boss = new BossMob(bossMobs[randIndex],bossMobDescription[randIndex],bossMobDamage[randIndex], bossMobHealth[randIndex]); // instantiates mob Object, and sets attributes
		return boss;
	}
}
