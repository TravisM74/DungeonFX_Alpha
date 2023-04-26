package Control;


import Display.PlayerInfo;
import Entity.Entity;
import Entity.EntityEnum;
import Interactions.Combat;
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
	
	
	
	public MoveButtons(Entity player, WorldLevel world,Stage stage, Scene scene, PlayerInfo playerInfo) {
		this.player = player;
		this.world = world;
		this.stage = stage;
		this.scene = scene;
		this.playerInfo = playerInfo;
		
		root = new BorderPane();
		VBox upPane = new VBox();
		Button upButton = new Button(" UP ");
		upButton.setOnAction(e -> { 
			
			if (player.getY() <= 0) {
				System.out.println("edge of map Warrning");
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
		
		Button downButton = new Button(" Down ");
		VBox downPane = new VBox();
		downButton.setOnAction(e -> { 
			if (player.getY() >= 40) {
				System.out.println("edge of map Warrning");
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
		
		Button leftButton = new Button(" Left ");
		VBox leftPane = new VBox();
		leftButton.setOnAction(e -> { 
			if (player.getX() <=0) {
				System.out.println("edge of map Warrning");
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
		
		Button rightButton = new Button(" Right ");
		VBox rightPane = new VBox();
		rightButton.setOnAction(e -> { 
			if(player.getX() >= 40) {
				System.out.println("edge of map Warrning");
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
		
		Button sheetButton = new Button(" . ");
		VBox centerPane = new VBox();
		centerPane.getChildren().add(sheetButton);
		centerPane.setAlignment(Pos.CENTER);
		root.setCenter(centerPane);
		
	}
	public void updatePlayerInfoPanel() {
		//this.mainRoot.setLeft(new PlayerInfo(player).getPlayerInfo());
		this.playerInfo.update();
	}

	public void interactionCheck() {
		WorldTile tile = world.getWorldTile(player.getX(), player.getY());
		for(Entity entity:tile.getAllEntities()) {
			if (entity.getEntityEnum().equals(EntityEnum.ENEMY)) {
				System.out.println("Enemy found");
				Combat combat = new Combat(this.player, this.world,this.stage, this.scene, this.playerInfo);
				
			}
		}
	}
	public BorderPane getMoveButtons() {
		return root;
	}
}
