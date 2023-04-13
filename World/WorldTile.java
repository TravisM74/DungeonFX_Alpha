package World;

import java.util.ArrayList;

import Entity.Entity;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WorldTile {
	private ArrayList<Entity> entity;
	private Group form;
	public WorldTile() {
		this.entity = new ArrayList<>();
		Rectangle tileForm = new Rectangle(0,0,10,10);
		tileForm.setFill(Color.DARKGRAY);
		this.form.getChildren().add(tileForm);
	
	}
	public void addEntity(Entity entity) {
		this.entity.add(entity);
	}
	public Entity getEntity(int value) {
		return this.entity.get(value);
	}
	public ArrayList<Entity> getAllEntities() {
		return this.entity;
	}
	public Group getTileForm() {
		return this.form;
	}

}
