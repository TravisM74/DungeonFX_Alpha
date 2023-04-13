package Entity;

import Gfx.HumanoidForm;
import Inventory.Inventory;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Build {
	private String name;
	private int level;
	private int hitPoints;
	private HumanoidForm hForm;
	private Group form;
	private Inventory inventory;

	public Build() {
		this.name = "Bob";
		this.level = 1;
		this.hitPoints = 10;
		this.inventory = new Inventory();
		this.hForm = new HumanoidForm();
			
	}
	public HumanoidForm getHumanoidForm() {
		return hForm;
	}
	public void setForm() {
		this.form =hForm.getBody();
	}
	public Group getForm() {
		return this.form;
	}
		
	public void setEntityName(String name) {
		this.name = name;
	}
	public Inventory getInventory() {
		return this.inventory;
	}
	
	public String toString() {
		return this.name + "\t " + "level :" + level ;
	}

}
