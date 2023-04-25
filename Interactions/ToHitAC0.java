package Interactions;

import java.util.Random;

import Classes.CharacterClass;
import Classes.CharacterClassEnum;
import Entity.Entity;


public class ToHitAC0 {
	private CharacterClassEnum cClass;
	private int level;
	private int armourClass;
	private int thac0;
	private int toHit;
	
	private Random rand;
	
	public ToHitAC0(Entity attacker, Entity defender) {
		this.cClass = attacker.getBuild().getEntityClass().getCharacterClassEnum();
		this.level = attacker.getBuild().getEntityLevel();
		this.armourClass = 7;
		switch(this.cClass) {
			case FIGHTER:
				this.thac0 = 20-(level - 1);
				this.armourClass = defender.getBuild().getEntityClass().getArmourClass();
				break;
			case ORC:
				this.thac0 = 20-(level - 1);
				this.armourClass = defender.getBuild().getInventory().calulateBaseArmourClass();
				
				break;
			case BARBARIAN:
				this.thac0 = 20-(level - 1);
				this.armourClass = defender.getBuild().getEntityClass().getArmourClass();
				break;
			case THEIF: 
				this.thac0 = 20-((level/2)- 1);
				this.armourClass = defender.getBuild().getEntityClass().getArmourClass();
				break;
		}
		
	}
	
	public boolean tryTohit() {
		toHit = (thac0 - level)- armourClass;
		//System.out.print("a " +toHit + ":(20) is needed to hit, ");
		rand = new Random();
		int roll = (rand.nextInt(20)+1);
		//System.out.print("rolls a "+ roll +" ");
		if(toHit <= roll) {
			//System.out.println(" and hit.");
			return true;
		} else {
			//System.out.println(" and missed.");
			return false;
		}
	}
}
