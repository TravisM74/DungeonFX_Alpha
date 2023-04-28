package Entity;

import java.util.Random;

import Classes.CharacterClass;
import Classes.CharacterClassEnum;
import Gfx.HumanoidForm;
import Inventory.Inventory;
import Stats.Stats;
import Status.Status;
import Status.StatusEnum;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Build {
	private String name;
	private Stats buildStats;
	private int level;
	private int currentHP;
	private int maxHitPoints;
	private HumanoidForm hForm;
	private Group form;
	private Inventory inventory;
	private CharacterClass characterClass;
	private int experiancePoints;
	private Status status;
	private StatusEnum statusEnum;
	private boolean restrictMovement;

	public Build() {
		this.name = "Bob";
		this.buildStats = new Stats();
		//setCharacterClass(CharacterClassEnum.FIGHTER);
		this.level = 1;
		this.experiancePoints = 0;
		this.inventory = new Inventory();
		this.hForm = new HumanoidForm();
		this.status = new Status(StatusEnum.ADVENTURING);
		this.restrictMovement = false;
		
		
		
	}
	public void diplayMainhandWeapon() {
		this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm().setTranslateX(this.hForm.getRightHandX());
		this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm().setTranslateY(this.hForm.getRightHandY());
		addToForm(this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm());
			
	}
	public void swapDisplayedMainhandWeapon(Group group) {
		this.form.getChildren().remove(this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm());
		this.form.getChildren().add(group);
		this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm().setTranslateX(this.hForm.getRightHandX());
		this.getInventory().getMainHandGear().getWeaponType().getMainhandHeldItemForm().getItemForm().setTranslateY(this.hForm.getRightHandY());
		
	}
	public void setHumanoidForm(Color hair,Color skin,Color eye,Color top,Color pants, Color shoe) {
		this.hForm = new HumanoidForm(hair, skin, eye, top, pants,  shoe);
	}
	public void addToForm(Group group) {
		this.form.getChildren().add(group);
	}
	public Stats getStats() {
		return this.buildStats;
	}

	public void setStatus(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
		this.status = new Status(statusEnum);
	}
	public void setMoveRestrictionsTrue() {
		this.restrictMovement = true;
		
	}
	public HumanoidForm getHForm() {
		return this.hForm;
	}
	public void setMoveRestrictionsFalse() {
		this.restrictMovement = false;
	}
	public boolean getIsEntityMoveRestricted() {
		return this.restrictMovement;
	}
	public void setForm() {
		this.form = hForm.getBody();
	}
	public void setCharacterClass(CharacterClassEnum cClass) {
		this.characterClass = new CharacterClass(cClass);
		calculateStartHitPoints();
	}
	public void setEntityName(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Status getStatus() {
		return this.status;
	}
	public StatusEnum getStatusEnum() {
		return this.statusEnum;
	}
	public void getClassDefaultForm() {
		this.hForm.getChildren().clear();
		this.hForm.getChildren().add(this.characterClass.getDefaultEntityForm());
	}
	public int getEntityLevel() {
		return this.level;
	}
	public Group getNewDisplayForm() {
		return hForm.getBody();
	}
	public Group getForm() {
		return this.form;
	}
	public Inventory getInventory() {
		return this.inventory;
	}
	public CharacterClass getEntityClass() {
		return this.characterClass;
	}
	public String getName() {
		return this.name;
	}
	public int getCurrentHitPoints() {
		return this.currentHP;
	}
	
	public void addExperiancePoints(int value) {
		this.experiancePoints += value;
	}
	
	private void calculateStartHitPoints() {
		Random rand = new Random();
		this.maxHitPoints = this.characterClass.getHitDice();
		this.maxHitPoints = rand.nextInt(this.maxHitPoints)+1;
		
		this.currentHP = this.maxHitPoints;
	}
	public void gainHealth(int value) {
		this.currentHP += value;
		if (this.currentHP > this.maxHitPoints) {
			System.out.println("full reached HP");
			this.currentHP = this.maxHitPoints;
		}
	}
	public void takeDamage(int value) {
		this.currentHP -= value;
	}
	public int causeDamage() {
		int damage= 0;
		damage = this.inventory.getMainWeaponAttackDamage();
		return damage;
	}

	public VBox getCombatInfoPane() {
		VBox combatInfo = new VBox();
		combatInfo.getChildren().add(new Label("Hit Points :"+this.currentHP+"/"+this.maxHitPoints));
		combatInfo.getChildren().add(new Label("Status :"+this.status));
		
		return combatInfo;
	}
	public String toString() {
		return this.name + "\t " + "level :" + level 
				+"\n" +this.characterClass.toString()
				+"\nHit Points : "+this.currentHP+" / "+ this.maxHitPoints
				+"\nExperiance\n " + this.experiancePoints +"\n"
				+"Status : \n"+
				this.status;
		
	}
}
