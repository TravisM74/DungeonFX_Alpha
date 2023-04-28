package Display;

import Control.MoveButtons;
import Entity.Entity;
import Inventory.EquipGear;
import World.WorldLevel;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InteractionButtons {
	private VBox buttonContainer;
	private Entity player;
	private WorldLevel world;
	private Stage primaryStage;
	private Scene mainScene;
	private PlayerInfo playerInfo;
	private LootPane lootPane;
	
	public InteractionButtons(Entity player ,WorldLevel world, Stage primaryStage,Scene scene,PlayerInfo playerInfo ) {
		this.player = player;
		this.world = world;
		this.primaryStage = primaryStage;
		this.mainScene = scene;
		this.playerInfo = playerInfo;
		this.lootPane = new LootPane(player, world, playerInfo);
	
			buttonContainer = new VBox();
		buttonContainer.setAlignment(Pos.CENTER);
		
		MoveButtons moveButtons = new MoveButtons(this.player,this.world,this.primaryStage, this.mainScene, this.playerInfo, this.lootPane);
		buttonContainer.getChildren().add(moveButtons.getMoveButtons());
		Button characterEquipment = new Button("Equip Gear");
		characterEquipment.setOnAction(e -> switchToEquipment());
		buttonContainer.getChildren().add(characterEquipment);
		
		buttonContainer.getChildren().add(lootPane.displayLootPane());
	}

	public VBox getButtonContainer() {
		return this.buttonContainer;
	}
	private void switchToEquipment() {
		EquipGear equipGear = new EquipGear(player,primaryStage,mainScene);
		Pane gearScene = new Pane();
		gearScene.getChildren().add(equipGear.getEqiuipGearPage());
		Scene sceneGear = new Scene(gearScene,1060,840);
		primaryStage.setScene(sceneGear);
		
	}
}
