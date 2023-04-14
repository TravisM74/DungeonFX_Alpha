package Display;

import Entity.Entity;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerInfo {
	private Entity player;
	
	private VBox playerInfo;
	
	public PlayerInfo(Entity player) {
		this.player = player;
		playerInfo = new VBox();
		
		Label name = new Label();
		name.setText(player.getBuild().toString());
		playerInfo.getChildren().add(name);
		Label inventory = new Label(player.getBuild().getInventory().toString());
		playerInfo.getChildren().add(inventory);
		Label equipedGear = new Label(player.getBuild().getInventory().getEquipedGear());
		playerInfo.getChildren().add(equipedGear);
	}
	
	public VBox getPlayerInfo() {
		return playerInfo;
	}

}
