package Display;

import Entity.Entity;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerInfo {
	private Entity player;
	
	private VBox playerInfo;
	private Label name;
	private Label inventory; 
	private Label equipedGear;
	
	public PlayerInfo(Entity player) {
		this.player = player;
		playerInfo = new VBox();
		update();
		/*
		this.name = new Label();
		name.setText(player.getBuild().toString());
		playerInfo.getChildren().add(name);
		this.inventory = new Label(player.getBuild().getInventory().toString());
		playerInfo.getChildren().add(inventory);
		this.equipedGear = new Label(player.getBuild().getInventory().getEquipedGear());
		playerInfo.getChildren().add(equipedGear);
		*/
	}
	
	public void update() {
		this.playerInfo.getChildren().clear();
		this.name = new Label();
		name.setText(player.getBuild().toString());
		playerInfo.getChildren().add(name);
		this.inventory = new Label(player.getBuild().getInventory().toString());
		playerInfo.getChildren().add(inventory);
		this.equipedGear = new Label(player.getBuild().getInventory().getEquipedGear());
		playerInfo.getChildren().add(equipedGear);
		
		
	}
	
	public VBox getPlayerInfo() {
		return playerInfo;
	}

}
