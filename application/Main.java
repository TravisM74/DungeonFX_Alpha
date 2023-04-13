package application;

import Control.MoveButtons;
import Display.PlayerInfo;
import Entity.Entity;
import Entity.EntityEnum;
import Visuals.Visuals;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	private MoveButtons moveButtons;
	private PlayerInfo playerInfo;
	private Visuals visual;
	Entity player;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.player = new Entity(EntityEnum.PLAYER);
			
			playerInfo = new PlayerInfo(this.player);
			BorderPane root = new BorderPane();
			moveButtons = new MoveButtons(this.player);
			VBox playerControls = new VBox();
			playerControls.getChildren().add(moveButtons.getMoveButtons());
			root.setRight(playerControls);
			VBox playerInformation = new VBox();
			playerInformation.getChildren().add(playerInfo.getPlayerInfo());
			root.setLeft(playerInformation);
			Pane centerDisplay = new Pane();
			visual = new Visuals(centerDisplay);
			visual.addVusualForm(player.getBuild().getForm());
			
			
			root.setCenter(centerDisplay);
			Scene scene = new Scene(root,1060,840);
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
}
