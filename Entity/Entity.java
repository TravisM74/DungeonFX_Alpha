package Entity;


import Items.Item;
import Items.ItemTypeEnum;
import Items.QualityEnum;
import Items.UsedEnum;
import Items.WeaponTypeEnum;
import javafx.scene.Group;

public class Entity {
	
	private String desciption;
	private EntityEnum entity;
	private int x;
	private int y;
	private Build build;
	
	
	public Entity(EntityEnum entity) {
		this.x = 0;
		this.entity = entity;
		switch(entity) {
		case ENEMY:
			this.desciption = " a hostile ";
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
			Build build = new Build();
			this.build = build;
			this.build.getHumanoidForm().setPlayerColors();
			this.build.setForm();
			this.build.getInventory().putItemInBackPack(new Item (" short sword ",ItemTypeEnum.WEAPON,WeaponTypeEnum.SHORT_SWORD ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25));
			System.out.println("number of things inm backpack after creation " +this.build.getInventory().getBackPack().size());
			break;
		
		}
	}
		
	public String toString() {
		return this.desciption;
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
	public void setX(int value) {
		this.x = value;
	}
	public void setY(int value) {
		this.y = value;
	}
	public EntityEnum getEntityType() {
		return this.entity;
	}
	
	
}
