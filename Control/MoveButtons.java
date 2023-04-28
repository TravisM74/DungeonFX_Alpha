package Control;


import Display.LootPane;
import Display.PlayerInfo;
import Entity.Entity;
import Entity.EntityEnum;
import Interactions.Combat;
import Status.StatusEnum;
import World.WorldLevel;
import World.WorldTile;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MoveButtons {
	private BorderPane root;
	private Entity player;
	private WorldLevel world;
	private Stage stage;
	private Scene scene;
	private PlayerInfo playerInfo;
	private LootPane lootPane;
	
	
	
	public MoveButtons(Entity player, WorldLevel world,Stage stage, Scene scene, PlayerInfo playerInfo, LootPane lootPane) {
		this.player = player;
		this.world = world;
		this.stage = stage;
		this.scene = scene;
		this.playerInfo = playerInfo;
		this.lootPane = lootPane;
		
		root = new BorderPane();
		VBox upPane = new VBox();
		Button upButton = new Button("  ▲  ");
		upButton.setOnAction(e -> { 
			
			if ((player.getY() <= 0) || (player.getBuild().getIsEntityMoveRestricted())) {
				System.out.println("move restricted");
			} else {
				player.getBuild().getForm().setTranslateY(player.getBuild().getForm().getTranslateY()-20);
				player.setY(player.getY()-1);
				System.out.println("up " + player.getY());
				interactionCheck();
				updatePlayerInfoPanel();
				
				
			}
		});
		upPane.getChildren().add(upButton);
		upPane.setAlignment(Pos.CENTER);
		root.setTop(upPane);
		
		Button downButton = new Button("  ▼  ");
		VBox downPane = new VBox();
		downButton.setOnAction(e -> { 
			if ((player.getY() >= 40) || (player.getBuild().getIsEntityMoveRestricted())){
				System.out.println("move restricted");
			} else {
				player.getBuild().getForm().setTranslateY(player.getBuild().getForm().getTranslateY()+20);
				player.setY(player.getY()+1);
				System.out.println("down " + player.getY());
				interactionCheck();
				updatePlayerInfoPanel();
				
				
			}
		});
		downPane.getChildren().add(downButton);
		downPane.setAlignment(Pos.CENTER);
		root.setBottom(downPane);
		
		Button leftButton = new Button(" ◄\n ");
		VBox leftPane = new VBox();
		leftButton.setOnAction(e -> { 
			if ((player.getX() <=0)|| (player.getBuild().getIsEntityMoveRestricted())) {
				System.out.println("move restricted");
			} else {
				player.getBuild().getForm().setTranslateX(player.getBuild().getForm().getTranslateX()-20);
				player.setX(player.getX()-1);
				System.out.println("left "  + player.getX());
				interactionCheck();
				updatePlayerInfoPanel();
				
			}
		});
		leftPane.getChildren().add(leftButton);
		leftPane.setAlignment(Pos.CENTER);
		root.setLeft(leftPane);
		
		Button rightButton = new Button(" ►\n ");
		VBox rightPane = new VBox();
		rightButton.setOnAction(e -> { 
			if((player.getX() >= 40)|| (player.getBuild().getIsEntityMoveRestricted())) {
				System.out.println("move restricted");
			} else {
				player.getBuild().getForm().setTranslateX(player.getBuild().getForm().getTranslateX()+20);
				player.setX(player.getX()+1);
				System.out.println("right " + player.getX());
				interactionCheck();
				updatePlayerInfoPanel();
				
			}
		});
		rightPane.getChildren().add(rightButton);
		rightPane.setAlignment(Pos.CENTER);
		root.setRight(rightPane);
		
		Button searchButton = new Button(" Search\n  Rest ");
		searchButton.setOnAction(e -> searchAreaAndRestTurn());
		VBox centerPane = new VBox();
		centerPane.getChildren().add(searchButton);
		centerPane.setAlignment(Pos.CENTER);
		root.setCenter(centerPane);
		
	}
	public void updatePlayerInfoPanel() {
		this.playerInfo.update();
	}
	public void searchAreaAndRestTurn() {
		recoverHealth();
		if (this.player.getBuild().getCurrentHitPoints() > 0 ) {
			this.player.getBuild().setMoveRestrictionsFalse();
			this.player.getBuild().getForm().setRotate(0);
		} else {
			this.player.getBuild().getForm().setRotate(90);
			this.player.getBuild().setMoveRestrictionsTrue();
		}
		interactionCheck();
		updatePlayerInfoPanel();
		this.lootPane.update();
	}

	public void interactionCheck() {
		WorldTile tile = world.getWorldTile(player.getX(), player.getY());
		for(Entity entity:tile.getAllEntities()) {
			if (entity.getEntityEnum().equals(EntityEnum.ENEMY)) {
				System.out.println("Enemy found");
				Combat combat = new Combat(this.player, this.world,this.stage, this.scene, this.playerInfo);
				
			}
			if (entity.getEntityEnum().equals(EntityEnum.ITEM)) {
				System.out.println("Item :"+entity.getItem());
			}
		}
		
	}
	
	public void recoverHealth() {
		this.player.getBuild().gainHealth(this.player.getBuild().getStatus().gethealthRegen());
		
	}
	public BorderPane getMoveButtons() {
		return root;
	}
}
