package Items;

import java.util.ArrayList;
import java.util.Random;

import Gfx.HeldItem;

public class LootTables {
	private ArrayList<Item> loot;
	private ArrayList<Item> weaponsCommon;
	private ArrayList<Item> empty;
	private ArrayList<Item> armour;
	

	public LootTables() {
		
		loot = new ArrayList<>();
		weaponsCommon = new ArrayList<>();
		armour = new ArrayList<>();
		empty = new ArrayList<>();
		
		empty.add( new Item("Nothing on head.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.HEAD, 0, 0, 0,false));
		empty.add( new Item("Nothing on arms.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.ARMS, 0, 0, 0,false));
		empty.add( new Item("Nothing on torso.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.BODY, 0, 0, 0,false));
		empty.add( new Item("Nothing on legs.",ItemTypeEnum.ARMOUR,ArmourTypeEnum.NONE,QualityEnum.COMMON,UsedEnum.LEGS, 0, 0, 0,false));
		empty.add( new Item("nothing in offhand.",ItemTypeEnum.EMPTY,UsedEnum.OFF_HAND, QualityEnum.COMMON,0, 0, 0,false));
		empty.add( new Item("Fist",ItemTypeEnum.WEAPON,WeaponTypeEnum.HANDS, QualityEnum.COMMON,UsedEnum.MAIN_HAND,0, 0, 0,false));
		
		
		
		
		Item starterRustySword = new Item (" forgotten ",ItemTypeEnum.WEAPON,WeaponTypeEnum.SHORT_SWORD ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true);
		weaponsCommon.add(starterRustySword);
		Item starterRustyDagger = new Item (" long lost ",ItemTypeEnum.WEAPON,WeaponTypeEnum.DAGGER ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true);
		weaponsCommon.add(starterRustyDagger);
		Item starterRustyShortSword = new Item (" long lost ",ItemTypeEnum.WEAPON,WeaponTypeEnum.SHORT_SWORD ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true);
		weaponsCommon.add(starterRustyShortSword);
		Item starterRustyAxe = new Item (" long lost ",ItemTypeEnum.WEAPON,WeaponTypeEnum.AXE ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true);
		weaponsCommon.add(starterRustyAxe);
		Item orcAxe = new Item (" orc forged ",ItemTypeEnum.WEAPON,WeaponTypeEnum.AXE ,QualityEnum.COMMON,UsedEnum.MAIN_HAND, 0, 1, 7,true);
		weaponsCommon.add(orcAxe);
		Item axe = new Item (" forged ",ItemTypeEnum.WEAPON,WeaponTypeEnum.AXE ,QualityEnum.COMMON,UsedEnum.MAIN_HAND, 0, 1, 7,true);
		weaponsCommon.add(axe);
		
		Item leatherhelm = new Item (" leather helm ",ItemTypeEnum.ARMOUR,ArmourTypeEnum.LEATHER,QualityEnum.COMMON,UsedEnum.HEAD, 0, 1, 85,true);
		armour.add(leatherhelm);
		
	}
	public Item getRandomCommonWeapon() {
		System.out.println("RandomCommonWeapon size =" +weaponsCommon.size());
		Random rand = new Random();
		int select = rand.nextInt(weaponsCommon.size());
		return weaponsCommon.get(select);
	}
	
	
}	
