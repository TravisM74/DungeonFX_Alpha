package Display;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

import Entity.Entity;
import Items.Item;
import Items.UsedEnum;
import World.WorldLevel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class LootPane {
	private BorderPane root;
	private Entity player;
	private WorldLevel world;
	private ChoiceBox<Item> getLootChoiceBox;
	private Button takeLoot;
	private ArrayList<Item>lootItems;
	private PlayerInfo playerInfo;
	
	
	public LootPane(Entity player, WorldLevel world,PlayerInfo playerInfo) {
		this.player = player;
		this.world = world;
		this.playerInfo = playerInfo;
		this.root = new BorderPane();
		takeLoot = new Button("Take Loot");
		root.setCenter(centerPane());
		root.setBottom(bottomPane());
		
		
	}
	public void update() {
		updateLootSelection();
		root.setCenter(null);
		root.setCenter(centerPane());
		
	}
	public BorderPane displayLootPane() {
		return this.root;
	}
	
	public VBox centerPane() {
		VBox lootItemsPane = new VBox();
		
		getLootChoiceBox = new ChoiceBox<>();
		getLootChoiceBox.setDisable(true);
		updateLootSelection();
		lootItemsPane.getChildren().add(getLootChoiceBox);
		return lootItemsPane;
		
	}
	public VBox bottomPane() {
		VBox bottomButtons = new VBox();

		takeLoot.setDisable(true);
		takeLoot.setOnAction(e -> takeLootAction());
		bottomButtons.setAlignment(Pos.TOP_CENTER);
		bottomButtons.getChildren().add(takeLoot);
		return bottomButtons;
	}
	public void takeLootAction() {
		this.player.getBuild().getInventory().putItemInBackPack(getLootChoiceBox.getValue());
		for (Entity entity :this.world.getWorldTile(this.player.getX(), this.player.getY()).getItems()) {
			if (entity.getItem().equals(getLootChoiceBox.getValue())) {
				this.world.getWorldTile(this.player.getX(), this.player.getY()).removeEntity(entity);
			
			}
		}
		lootItems.clear();
		playerInfo.update();
		update();
		
	}
	
	public void updateLootSelection() {
		lootItems = new ArrayList<>();
		for (Entity entity:this.world.getWorldTile(this.player.getX(), this.player.getY()).getItems()) {
			if(entity.getItem().isLootable()) {
				Item newItem = entity.getItem();
				System.out.println("item added to Loot selection:"+newItem);
				lootItems.add(newItem);
			}
		}
		System.out.println("lootItems count:"+lootItems.size());
		if (lootItems.size() > 0) {
			takeLoot.setDisable(false);
			getLootChoiceBox.setDisable(false);
		} else {
			takeLoot.setDisable(true);
			getLootChoiceBox.setDisable(true);
		}
		getLootChoiceBox.getItems().clear();
		getLootChoiceBox.getItems().addAll(lootItems);
		getLootChoiceBox.getSelectionModel().selectFirst();
	}

}
