package Inventory;

import java.util.ArrayList;

import Items.ArmourTypeEnum;
import Items.Item;
import Items.ItemTypeEnum;
import Items.QualityEnum;
import Items.UsedEnum;
import Items.WeaponTypeEnum;

public class Inventory {
	
	private ArrayList<Item> backpack;
	
	private Item headGear;
	private Item armsGear;
	private Item torsoGear;
	private Item mainHandGear;
	private Item offHandGear;
	private Item legsGear;
	private int gold;
	private int silver;
	private int copper;
	

	public Inventory() {
		this.backpack= new ArrayList<>();
		this.gold= 0;
		this.silver = 0;
		this.copper = 0;
		this.headGear = new Item("Nothing.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.HEAD, 0, 0, 0);
		this.armsGear = new Item("Nothing.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.ARMS, 0, 0, 0);
		this.torsoGear = new Item("Nothing.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.BODY, 0, 0, 0);
		this.legsGear = new Item("Nothing.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.LEGS, 0, 0, 0);
		this.offHandGear = new Item("empty",ItemTypeEnum.EMPTY,UsedEnum.OFF_HAND, QualityEnum.COMMON,0, 0, 0);
		this.mainHandGear = new Item("Fist",ItemTypeEnum.WEAPON,WeaponTypeEnum.HANDS, QualityEnum.COMMON,UsedEnum.MAIN_HAND,0, 0, 0);
		
	}
	public String getEquipedGear() {
		String textOut = "";
		textOut = "Equiped. \nHead \t:"+this.headGear.getDescription()+"\n"+
				"Torso \t:"+this.torsoGear.getDescription()+"\n"+
				"Arms \t:"+this.armsGear.getDescription()+"\n"+
				"Leggs \t:"+this.legsGear.getDescription()+"\n"+
				"Main-Hand \t:"+this.mainHandGear.getDescription()+"\n"+
				"Off-Hand \t:"+this.offHandGear.getDescription()+"\n";
		
		return textOut;
	}
	public int calulateBaseArmourClass() {
		int value = 0;
		value += this.headGear.getArmourtype().getArmourClassBaseValue()/4;
		value += this.armsGear.getArmourtype().getArmourClassBaseValue()/4;
		value += this.legsGear.getArmourtype().getArmourClassBaseValue()/4;
		value += this.torsoGear.getArmourtype().getArmourClassBaseValue();
			
		return value;
	}
	
	public Item getHeadGear() {
			
		return headGear;
	}

	public void setHeadGear(Item headGear) {
		this.headGear = headGear;
	}

	public Item getArmsGear() {
		return armsGear;
	}

	public void setArmsGear(Item armsGear) {
		this.armsGear = armsGear;
	}

	public Item getTorsoGear() {
		return torsoGear;
	}

	public void setTorsoGear(Item torsoGear) {
		this.torsoGear = torsoGear;
	}

	public Item getMainHandGear() {
		return mainHandGear;
	}

	public void setMainHandGear(Item mainHandGear) {
		this.mainHandGear = mainHandGear;
	}

	public Item getOffHandGear() {
		return offHandGear;
	}

	public void setOffHandGear(Item offHandGear) {
		this.offHandGear = offHandGear;
	}

	public Item getLegsGear() {
		return legsGear;
	}

	public void setLegsGear(Item legsGear) {
		this.legsGear = legsGear;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getCopper() {
		return copper;
	}

	public void setCopper(int copper) {
		this.copper = copper;
	}

	public void putItemInBackPack(Item item) {
		this.backpack.add(item);
	}
	public Item getItemFromBackPack(int value) {
		return this.backpack.get(value);
	}
	public ArrayList<Item> getBackPack(){
		return this.backpack;
	}
	
	private String listBackPackItems() {
		String textOut = "";
		for (Item item:backpack) {
			textOut+=(item.getDescription() + "\n");
		}
		return textOut;
		
	}
	
	public String toString() {
		return "Gold \t:" + this.gold +"\n"+
				"Silver \t:" +this.silver +"\n"+
				"Copper \t:" + this.copper +"\n"+
				" \n Items (" +backpack.size() +")"+" \n"+ listBackPackItems()+"\n";
				
				
	}
}
