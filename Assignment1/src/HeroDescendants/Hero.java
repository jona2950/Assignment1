package HeroDescendants;

import java.util.Random;

/**
 * 
 * @author Jonathan Fachola
 * @date January, 25 2015
 * 
 * Hero simulation game, 
 * which hero produces random ability levels in ranges of 1 to 100, -
 * and where a limited chance of hitting is factored before damage is calculated.
 * Damage is calculated by strength * a random value of 1 - 6
 *
 */

public class Hero {
	
	//Instance variables
	private int strength;
	private int speed;
	private int health;
	
	private String name;
	
	//constant variables
	private final int MIN = 1;
	private final int MAX = 100;
	
	private final int MAX_DAMAGE_MULTIPLIER = 6;
	
	private final float HIT_CHANCE = 0.20f;
	
	//RNG is object of Random
	Random RNG = new Random(); //Acronym for, "Random Number Generator"

	/**
	 * Purpose: A defined constructor with argument, "name" for hero.
	 * 
	 * @param name assignment to hero
	 */
	public Hero(String name) {

		this.name = name;
		
		generateAbilities();
	}
	
	/**
	 * Purpose:
	 * 	Method produces random values between 1-100 for "strength", "speed" & "health" 
	 * associated to hero abilities
	 */
	private void generateAbilities()
	{
		strength = (MIN+RNG.nextInt(MAX));
		speed = (MIN+RNG.nextInt(MAX));
		health = (MIN+RNG.nextInt(MAX));
		
	}
	
	/**
	 * Purpose: a value output of the damage hero produced. 
	 * 	Dependent on hero's attack chance (20%) before calculating damage output
	 */
	public void fight()
	{
		if (hitAttempt())
		{
			System.out.println(hitDamage());
		}
	}
	
	/**
	 * Purpose: 
	 * 	Preventing a 100% hit chance, this method will determine if hero is apt of hitting.
	 * By employing the random object, with method "nextInt()" a output of 0 to 1 is produced. 
	 * thus, chance can be calculated. 
	 * As so, output is less then 0.20f, return true. Underlying the 20% chance rate.
	 * 
	 * @return boolean for, hero, if hit was made or not
	 */
	private boolean hitAttempt()
	{
		if (RNG.nextInt() < HIT_CHANCE)
		{
			return true;
		}
		
		return false;
	}
	
	/** 
	 * Purpose: Calculates hit damage dependent on hero's strength -
	 * 	and multiplied with random  number generated between 1 - 6
	 * @return damage hero hits
	 */
	private int hitDamage()
	{
	
		return strength*(MIN+RNG.nextInt(MAX_DAMAGE_MULTIPLIER));
	}
	
	/**
	 * Purpose: 
	 * 	Displays the hero's name and ability skills, calling the "toString" -
	 * posting/passing to console with "System.out.println()"
	 */
	public void show()
	{
		System.out.println(toString());
	}
	
	/**
	 * This method overrides the original toString in object, 
	 * 	with a custom string output in relation of the class
	 */
	@Override
	public String toString()
	{
		
		return String.format("I am %s, the hero of COMP1011.%n-------------%nStrength: %s%nSpeed: %s%nHealth: %s",
				name, strength, speed, health);
	}
	

}
