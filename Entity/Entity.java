package Entity;


import Classes.CharacterClassEnum;
import Items.Item;
import Items.ItemTypeEnum;
import Items.QualityEnum;
import Items.UsedEnum;
import Items.WeaponTypeEnum;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Entity {
	
	private String desciption;
	private EntityEnum entity;
	private int x;
	private int y;
	private Build build;
	private Item item;
	
	
	public Entity(EntityEnum entity) {
		this.x = 0;
		this.entity = entity;
		switch(entity) {
		case LOOTABLE:
			break;
		case ENEMY:
			this.desciption = " a hostile ";
			this.build = new Build();
			break;
		case STAIRS:
			this.desciption = " stairs leading somewhere ";
			break;
		case SHOP:
			this.desciption = " a happy trade Goblin ";
			break;
		case ITEM:
			
			break;
		case PORTAL:
			this.desciption = " a portal leading somewhere.";
			break;
		case PLAYER:
			this.desciption = "...";
			this.build = new Build();
			this.build.setForm();
			this.build.setCharacterClass(CharacterClassEnum.FIGHTER);
			this.build.getInventory().putItemInBackPack(new Item (" short sword ",ItemTypeEnum.WEAPON,WeaponTypeEnum.SHORT_SWORD ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true));
			//System.out.println("number of things in backpack after creation " +this.build.getInventory().getBackPack().size());
			break;
			
		
		}
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setX(int value) {
		this.x = value;
	}
	public void setY(int value) {
		this.y = value;
	}
	
	public Item getItem() {
		if (this.item.equals(null)) {
			return new Item("a.nothing.ERROR",ItemTypeEnum.EMPTY,UsedEnum.POUCH, QualityEnum.COMMON,0,0,0,false);
		}
		return this.item;
	}
	public Build getBuild() {
		return this.build;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public EntityEnum getEntityEnum() {
		return this.entity;
	}
	public String toString() {
		return this.desciption;
	}
	
	
}
