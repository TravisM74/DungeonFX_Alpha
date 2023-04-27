package Display;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import Entity.Entity;
import Items.Item;
import Items.UsedEnum;
import World.WorldLevel;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class LootPane {
	private BorderPane root;
	private Entity player;
	private WorldLevel world;
	private ChoiceBox<Item> getLoot;
	
	public LootPane(Entity player, WorldLevel world) {
		this.player = player;
		this.world = world;
		this.root = new BorderPane();
		root.setCenter(centerPane());
		root.setBottom(bottomPane());
		
		
	}
	public VBox centerPane() {
		VBox lootItemsPane = new VBox();
		
		getLoot = new ChoiceBox<>();
		updateLootSelection();
		
		return lootItemsPane;
		
	}
	public VBox bottomPane() {
		VBox bottomButtons = new VBox();
		Button takeLoot = new Button("Take Loot");
		takeLoot.setOnAction(e -> takeLootAction());
		bottomButtons.getChildren().add(takeLoot);
		return bottomButtons;
	}
	public void takeLootAction() {
		this.player.getBuild().getInventory().putItemInBackPack(getLoot.getValue());
		for (Entity entity :this.world.getWorldTile(this.player.getX(), this.player.getY()).getItems()) {
			if (entity.getItem().equals(getLoot.getValue())) {
				this.world.getWorldTile(this.player.getX(), this.player.getY()).removeEntity(entity);
			
			}
		}
		
	}
	
	public void updateLootSelection() {
		ArrayList<Item>lootItems = new ArrayList<>();
		for (Entity entity:this.world.getWorldTile(this.player.getX(), this.player.getY()).getItems()) {
			if(entity.getItem().isLootable()) {
				Item newItem = entity.getItem();
				lootItems.add(newItem);
			}
		}
		getLoot.getItems().clear();
		getLoot.getItems().addAll(lootItems);
		getLoot.getSelectionModel().selectFirst();
	}

}
