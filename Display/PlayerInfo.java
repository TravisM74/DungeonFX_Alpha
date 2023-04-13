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
		Label Inventory = new Label(player.getBuild().getInventory().toString());
		playerInfo.getChildren().add(Inventory);
	}
	
	public VBox getPlayerInfo() {
		return playerInfo;
	}

}
