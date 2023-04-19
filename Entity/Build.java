package Entity;

import java.util.Random;

import Classes.CharacterClass;
import Classes.CharacterClassEnum;
import Gfx.HumanoidForm;
import Inventory.Inventory;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Build {
	private String name;
	private int level;
	private int maxHitPoints;
	private HumanoidForm hForm;
	private Group form;
	private Inventory inventory;
	private CharacterClass characterClass;
	private int experiancePoints;

	public Build() {
		this.name = "Bob";
		this.level = 1;
		this.maxHitPoints = 10;
		this.experiancePoints = 0;
		this.inventory = new Inventory();
		this.hForm = new HumanoidForm();
			
	}
	public void setHumanoidForm(Color hair,Color skin,Color eye,Color top,Color pants, Color shoe) {
		this.hForm = new HumanoidForm(hair, skin, eye, top, pants,  shoe);
	}
	public void getClassDefaultForm() {
		this.hForm.getChildren().clear();
		this.hForm.getChildren().add(this.characterClass.getDefaultEntityForm());
	}
	public void setForm() {
		this.form =hForm.getBody();
	}
	public Group getForm() {
		return this.form;
	}
	public void setCharacterClass(CharacterClassEnum cClass) {
		this.characterClass = new CharacterClass(cClass);
		calculateHitPoints();
	}
	public void setEntityName(String name) {
		this.name = name;
	}
	public Inventory getInventory() {
		return this.inventory;
	}
	public void addExperiancePoints(int value) {
		this.experiancePoints += value;
	}
	public String toString() {
		return this.name + "\t " + "level :" + level 
				+"\n" +this.characterClass.toString()
				+"\nExperiance\n " + this.experiancePoints +"\n";
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private void calculateHitPoints() {
		Random rand = new Random();
		this.maxHitPoints = this.characterClass.getHitDice();
		this.maxHitPoints = rand.nextInt(this.maxHitPoints)+1;
	}

}
