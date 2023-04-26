package Interactions;

import java.util.ArrayList;
import java.util.Random;

import Display.PlayerInfo;
import Entity.Entity;
import Entity.EntityEnum;
import Items.Item;
import Status.Status;
import Status.StatusEnum;
import World.WorldLevel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Combat {
	private Stage stage;
	private Scene scene;
	private WorldLevel world;
	private Entity attacker;
	private Entity defender;
	private ArrayList<Entity> enemies;
	private String combatText;
	private Label combatTextLabel;
	private HBox frame;
	private VBox textPane;
	private Button fightButton;
	private PlayerInfo playerInfo;
	
	public Combat(Entity attacker, WorldLevel world,Stage stage, Scene scene, PlayerInfo playerInfo) {
		this.stage = stage;
		this.scene = scene;
		this.world = world;
		this.attacker = attacker;
		this.playerInfo = playerInfo;
		this.enemies = new ArrayList<>();
		this.enemies = this.world.getWorldTile(attacker.getX(), attacker.getY()).getEnemies(); 
		this.defender = enemies.get(0);
		System.out.println("Eniemies detected in array :"+ enemies.size());
		this.combatTextLabel = new Label();
		fight(this.attacker, this.defender);
	}
	
	public void fight(Entity attacker , Entity defender) {
		VBox combatRoot = new VBox();
		combatRoot.setAlignment(Pos.TOP_CENTER);
		this.frame = new HBox();
		this.frame.getChildren().addAll(createCombatPane(attacker),createCombatPane(defender));
		textPane = new VBox();
		textPane.getChildren().add(combatTextLabel);
		combatRoot.getChildren().addAll(frame,createCombatButtons(),textPane);
		Scene combatScene = new Scene(combatRoot,1060,840);
		this.stage.setScene(combatScene);
	}
	private void fleeButtonAction() {
		//to Implement- attcker will be attacked for trying to flee from battle.
		entityFleeing(this.attacker);
		//To Implement-update main Stage Information
		
		this.stage.setScene(scene);
	}
	
	private void fightButtonAction() {
		ToHitAC0 thac0Attacker = new ToHitAC0(this.attacker,this.defender);
		if(this.attacker.getBuild().getCurrentHitPoints() >0 ){
			if (this.defender.getBuild().getStatusEnum() == StatusEnum.DEAD) {
				combatText = "No need to hit a corpse !";
			} else {
				combatText = this.attacker.getBuild().getName() + " and the " +this.defender.getBuild().getName() + " fight ";
				if (thac0Attacker.tryToHit()) {
					combatText += this.attacker.getBuild().getName()+" hits for ";
					dealDamage(this.attacker,this.defender);
				} else {
					combatText += " but "+this.attacker.getBuild().getName()+ " misses. \n";
				}
			}
			if (this.defender.getBuild().getStatusEnum() != StatusEnum.DEAD) {
				combatText += "The "+this.defender.getBuild().getName() + "'s attack " ;
			}
				
		}
		ToHitAC0 defenderAttacks = new ToHitAC0(this.defender,this.attacker);
	
		if (this.defender.getBuild().getStatusEnum() != StatusEnum.DEAD ) {
			if (defenderAttacks.tryToHit()) {
				combatText += " hits for ";
				dealDamage(this.defender,this.attacker);
			} else {
				combatText += " misses. \n";
			}
		}
		additionalEntitiesAttack();	
		testForDefeats();
		
		this.frame.getChildren().clear();
		this.frame.getChildren().addAll(createCombatPane(this.attacker),createCombatPane(this.defender));
		this.combatTextLabel.setText(combatText);
	}
	public void testForDefeats() {
		//set attacker to unconscious if below 0
		if (this.attacker.getBuild().getCurrentHitPoints() <= 0) {
			this.attacker.getBuild().setStatus(StatusEnum.UNCONCEOUS);
			combatText += this.attacker.getBuild().getName() +" falls to the ground " + this.attacker.getBuild().getStatus();
			//entity will remove an item or coin
			entityLootPlayer(this.defender);
			//entity will relocate on map with taken loot
			entityFleeing(this.defender);
			this.attacker.getBuild().getForm().setRotate(90);
			this.playerInfo.update();
			this.stage.setScene(scene);
		}
		if (this.attacker.getBuild().getCurrentHitPoints() <= -9) {
			this.attacker.getBuild().setStatus(StatusEnum.DEAD);
			combatText += this.attacker.getBuild().getName() +" falls to the ground " + this.attacker.getBuild().getStatus();
			//To Implement- fatal damage end game.
			gameOver();
		}
		// entity enemies have not unconscious they just die
		if (this.defender.getBuild().getCurrentHitPoints() <=0)  {
			if (this.defender.getBuild().getStatusEnum() != StatusEnum.DEAD) {
				combatText += this.defender.getBuild().getName() +" falls to the ground ";
				this.defender.getBuild().setStatus(StatusEnum.DEAD);
				combatText +=   this.defender.getBuild().getStatus();
				this.defender.getBuild().getForm().setRotate(90);
				//make entity to loot in world map
				turnEntityToLoot(this.defender);
				//assign next defender it multiple enemies are in grid.
				getNextDefender();
			}
		}
		
	}
	public void getNextDefender() {
		if (this.enemies.size() > 1) {
			this.enemies.remove(0);
			this.defender=enemies.get(0);
		} else {
			//no more enemies to fight return to adventure screen.
			this.playerInfo.update();
			this.stage.setScene(scene);
			//To Implement- or loot screen.
		}
		
	}
	
	public void turnEntityToLoot(Entity entity) {
		// turn the entity to loot bits and drop to floor.
		for (Item item:this.defender.getBuild().getInventory().getAllLootables()) {
			world.getWorldTile(this.attacker.getX(), this.attacker.getY()).createItem(item);
		}
		//automatic coin collection
		this.attacker.getBuild().getInventory().addGoldCoin(this.defender.getBuild().getInventory().getGold());
		this.attacker.getBuild().getInventory().addSilverCoin(this.defender.getBuild().getInventory().getSilver());
		this.attacker.getBuild().getInventory().addCopperCoin(this.defender.getBuild().getInventory().getCopper());
		//To Implement- provide xp.
		//then remove entity.
		world.getWorldTile(entity.getX(),entity.getY()).removeEntity(entity);
	}
	
	public void entityLootPlayer(Entity entity) {
		//To Implement- entity removes an item/ money from player.
		
	}
	
	public void additionalEntitiesAttack() {
		//other enemy entities if any attack here.
		if(this.attacker.getBuild().getCurrentHitPoints() > 0) {
			if (this.enemies.size() > 1) {
				for (int i = 1 ; i < this.enemies.size(); i++) {
					ToHitAC0 additionalAttack = new ToHitAC0(this.defender,this.enemies.get(i));
					if (additionalAttack.tryToHit()) {
						combatText += this.enemies.get(i).getBuild().getName() +" hits for ";
						dealDamage(this.enemies.get(i),this.attacker);
					} else {
						combatText += this.enemies.get(i).getBuild().getName() +" misses. \n";
					}
				}
			}
		} else {
			if (this.enemies.size() > 1) {
				for (int i = 1 ; i < this.enemies.size(); i++) {
					entityLootPlayer(this.enemies.get(i));
					entityFleeing(this.enemies.get(i));
				}
			}
		}
	}
	
	public void gameOver() {
		//To Implement- Initialise a game over class and make it swap to A game over page
	}
	
	
	private void dealDamage(Entity dealer,Entity reciever) {
		int damage = dealer.getBuild().causeDamage();
		combatText += damage + " damage. ";
		reciever.getBuild().takeDamage(damage);
	}
	
	private HBox createCombatButtons() {
		HBox combatButtons = new HBox();
		combatButtons.setPadding(new Insets(10));
		combatButtons.setAlignment(Pos.CENTER);
		fightButton = new Button("Fight");
		fightButton.setOnAction(e -> fightButtonAction());
		Button fleeButton = new Button("Flee");
		fleeButton.setOnAction(e -> fleeButtonAction());
		combatButtons.getChildren().addAll(fightButton,fleeButton);
		return combatButtons;
	}
	
	private BorderPane createCombatPane(Entity entity) {
		BorderPane attackerPane = new BorderPane();
		
		VBox topPane = new VBox();
		topPane.getChildren().add(new Label (entity.getBuild().getName()));
		topPane.setAlignment(Pos.CENTER);
		attackerPane.setTop(topPane);
		
		VBox leftPane = new VBox();
		leftPane.getChildren().add(entity.getBuild().getCombatInfoPane());
		leftPane.getChildren().add(entity.getBuild().getInventory().getCombatGear());
		leftPane.setAlignment(Pos.CENTER);
		attackerPane.setLeft(leftPane);
		
		VBox centerPane = new VBox();
		Rectangle backGroundRectangle = new Rectangle(0,0,50,50);
		/*
		 * background rectangle has unexpected result.
		 * expected to see rectangle start in top left of area and fill out 50 by 50 pixel
		 * when combined with image in group seem mid way.
		 * Re read -Layout manager VBox()
		 * Re read -Group() 
		 * group is a layout manager not a combined object understand the results seen looking for correct
		 * method.
		 * maybe try create an ImageView of the shaped i have used to create the group ?
		 * current book only describes Parent node.
		 * Possible node options to read on :
		 * 	Canvas
		 * 	Shape
		 * ImageView
		 */
		Group attackerForm = new Group();
		/*
		 * creating and editing the body form remove it from the main stage when returning ?
		 * 
		 * Following line displays it as expected but need more knowledge on how to do correctly.
		 * re read Staging()
		 * re read Scene()
		 */
		
		//attackerForm.getChildren().add(entity.getBuild().getNewDisplayForm());
		attackerForm.setScaleX(5);
		attackerForm.setScaleY(5);
		attackerForm.setTranslateX(0);
		attackerForm.setTranslateY(0);
		centerPane.setPrefWidth(200);
		centerPane.setPrefHeight(250);
		centerPane.getChildren().add(attackerForm);
		centerPane.setAlignment(Pos.CENTER);
		attackerPane.setCenter(centerPane);
		return attackerPane;
	}
	
	private void entityFleeing(Entity entity) {
		Random rand = new Random();
		int locX = 0;
		int locY = 0 ;
		boolean validLoc = false;
		while (!validLoc) {
			locX = rand.nextInt(40);
			locY = rand.nextInt(40);
			if (entity.getEntityEnum().equals(EntityEnum.PLAYER)) {
				if (this.world.getWorldTile(locX, locY).getEnemies().size() > 0) {
					validLoc = false;
				} else {
					validLoc = true;
				}
			}
			if (entity.getEntityEnum().equals(EntityEnum.ENEMY)) {
				if((locX == this.attacker.getX()) &&(locY == this.attacker.getY())) {
					validLoc = false;
				} else {
					validLoc = true;
				}
			}
		}
		entity.setX(locX);
		entity.setY(locY);
		entity.getBuild().getForm().setTranslateX(locX *20);
		entity.getBuild().getForm().setTranslateY(locY *20);
	}

	
}
