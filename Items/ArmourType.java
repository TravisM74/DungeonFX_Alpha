package Items;

import java.util.ArrayList;

public class ArmourType {
	private ArmourTypeEnum armourType;
	private int baseAC;
	private String desc;
	private ArrayList<DamageType> resists;
	private ArrayList<DamageType> vulnerable;
	
	
	public ArmourType(ArmourTypeEnum type) {
		this.resists = new ArrayList<>();
		this.vulnerable = new ArrayList<>();
		this.armourType = type;
	/*
	 * Base armour value for chest piece
	 * 
	 * arms /4 
	 * legs /4 
	 * head /4
	 * 
	 * Full Set Values
	 * leather AC 3  = 5.25
	 * chain AC 4  = 7
	 * scale AC 5  = 8.75
	 * plate AC 6  = 10.5
	 * 
	 * AC 10 - base = Thac0
	 *  
	 */
		
		switch (armourType) {
		case NONE:
			this.baseAC = 0;
			this.desc = " nothing ";
			break;
		case CLOTH:
			this.baseAC = 0;
			this.desc = " cloth ";
			break;
		case LEATHER:
			this.baseAC = 3;
			this.desc = " leather ";
			break;
		case CHAIN:
			this.baseAC = 4;
			this.desc = " chain ";
			break;	
		case SCALE:
			this.baseAC = 5;
			this.desc = " scale ";
			break;	
		case PLATE:
			this.baseAC = 6;
			this.desc = " plate ";
			break;	
		}
	}
	public String toString() {
		return this.desc;
	}
	public int getArmourClassBaseValue() {
		return this.baseAC;
	}

}
