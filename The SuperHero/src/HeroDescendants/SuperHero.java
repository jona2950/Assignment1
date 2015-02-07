package HeroDescendants;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author Jonathan Fachola	
 * @date Feburary, 6 2015
 * 
 */

public class SuperHero extends Hero {

	//Instance variable(s) //Static?
	String[] superPowers = new String[3];
	
	
	public enum abilityPowers
	{ //Would an array work?
		SUPERSPEED 		("Super Speed"),
		SUPERSTRENGTH 	("Super Strength"),
		BODYARMOUR 		("Body Armour"),
		FLIGHT 			("Flight"),
		FIREGENERATION	("Fire Generation"),
		WEATHERCONTROL	("Weather Control");
		
		private final String attack;
		abilityPowers(String attack) {
			this.attack = attack;
		}
		
		String n() { return attack; }

	}
	
	/**
	 * Constructor of SuperClass requires matching params as the one in its parent class
	 * @param name, of the SuperHero's name and passed to superclass, hero
	 */
	public SuperHero(String name) {
		super(name);
		
		generateRandomPowers();

	}

	private void generateRandomPowers() {
		// TODO Auto-generated method stub
		int counter = 0;
		
		do {
			for (abilityPowers ap : abilityPowers.values())
			{
				
				if (Math.random() > .75f && counter < superPowers.length)
				{
					System.out.println(ap.n());
					superPowers[counter] = ap.n();
					counter++;
				}
			}
				  Set<String> dump = new HashSet<String>();
				  for (String x : superPowers)
				  {
				    if (dump.contains(x)) {
				    	counter--;
				    }
				    else {
				    	dump.add(x);
				    }
				  }

			
			//System.out.println(superPowers[i-1]);
		} while (counter < superPowers.length);
	}
	
	

}
