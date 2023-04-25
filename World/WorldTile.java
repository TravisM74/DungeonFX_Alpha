package World;

import java.util.ArrayList;

import Entity.Entity;
import Entity.EntityEnum;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WorldTile {
	private ArrayList<Entity> entity;
	private Group form;
	public WorldTile() {
		form = new Group();
		this.entity = new ArrayList<>();
		Rectangle tileForm = new Rectangle(0,0,20,20);
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
	public ArrayList<Entity> getEnemies(){
		ArrayList<Entity> enemies = new ArrayList<>();
		for (Entity entity:this.entity) {
			if (entity.getEntityEnum().equals(EntityEnum.ENEMY)) {
				enemies.add(entity);
			}
		}
		
		return enemies;
	}

}
