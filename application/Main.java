package application;

import java.util.Random;

import Classes.CharacterClass;
import Classes.CharacterClassEnum;
import Control.MoveButtons;
import Display.InteractionButtons;
import Display.PlayerInfo;
import Entity.Entity;
import Entity.EntityEnum;
import Items.Item;
import Items.ItemTypeEnum;
import Items.QualityEnum;
import Items.UsedEnum;
import Items.WeaponTypeEnum;
import Visuals.Visuals;
import World.WorldLevel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	private MoveButtons moveButtons;
	private PlayerInfo playerInfo;
	private Visuals visual;
	private WorldLevel world;
	private Entity player;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.player = new Entity(EntityEnum.PLAYER);
			world = new WorldLevel();
			Pane centerDisplay = new Pane();
			visual = new Visuals(centerDisplay);
			
			BorderPane root = new BorderPane();
			scene = new Scene(root,1060,840);
			
			VBox playerInformation = new VBox();
			playerInfo = new PlayerInfo(this.player);
			playerInformation.getChildren().add(playerInfo.getPlayerInfo());
			root.setLeft(playerInformation);

			VBox playerControls = new VBox();
			InteractionButtons interactionButtons = new InteractionButtons(this.player, this.world,primaryStage, this.scene,this.playerInfo);
			playerControls.getChildren().add(interactionButtons.getButtonContainer());
			root.setRight(playerControls);
			visual.addVusualForm(player.getBuild().getForm());
			player.getBuild().diplayMainhandWeapon();
			createOrcEntity();
			
			root.setCenter(centerDisplay);
			primaryStage.setScene(scene);
			primaryStage.setTitle("The Grand Adventure");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	public void createOrcEntity() {
		 Entity orcEnemy = new Entity(EntityEnum.ENEMY);
		 orcEnemy.getBuild().setName("Orc");
		 Random rand = new Random();
		 orcEnemy.getBuild().getInventory().addCopperCoin(rand.nextInt(10));
		 orcEnemy.getBuild().getInventory().setMainHandGear(new Item (" long lost ",ItemTypeEnum.WEAPON,WeaponTypeEnum.DAGGER ,QualityEnum.POOR,UsedEnum.MAIN_HAND, 0, 1, 25,true));
		 //set his xy
		 orcEnemy.setX(2);
		 orcEnemy.setY(2);
		 //load him onto the corresponding tile
		 world.getWorldTile(2, 2).addEntity(orcEnemy);
		 //create hisForm
		 orcEnemy.getBuild().setHumanoidForm(Color.RED,Color.GREEN,Color.RED,Color.BROWN,Color.BROWN, Color.GREEN);
		 //set it to the Entity
		 orcEnemy.getBuild().setForm();
		 orcEnemy.getBuild().setCharacterClass(CharacterClassEnum.ORC);
		 //Calculate its relative screen location
		 orcEnemy.getBuild().getForm().setTranslateX(orcEnemy.getX()*20);
		 orcEnemy.getBuild().getForm().setTranslateY(orcEnemy.getY()*20);
		 //add entity's Visual to the Pane
		 visual.addVusualForm(orcEnemy.getBuild().getForm());
		 orcEnemy.getBuild().diplayMainhandWeapon();
		 
	}
}

