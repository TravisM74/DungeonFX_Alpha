package Control;


import Entity.Entity;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MoveButtons {
	private BorderPane root;
	private Entity player;
	
	public MoveButtons(Entity player) {
		this.player = player;
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
	public BorderPane getMoveButtons() {
		return root;
	}
}
