package Gfx;

import javafx.scene.Group;

public class Fist extends Group implements HeldItem {
	private Group item;

	public Fist() {
	this.item = new Group();	
	}

	@Override
	public Group getItemForm() {
		
		return item;
	}

}
