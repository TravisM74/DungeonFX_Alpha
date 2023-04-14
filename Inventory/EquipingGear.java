package Inventory;

import Entity.Entity;
import Items.Item;
import Items.ItemTypeEnum;
import Items.UsedEnum;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EquipingGear {
	
	private ChoiceBox<Item> headGear;
	private ChoiceBox<Item> armsGear;
	private ChoiceBox<Item> torsoGear;
	private ChoiceBox<Item> mainHandGear;
	private ChoiceBox<Item> offHandGear;
	private ChoiceBox<Item> legsGear;
	private Inventory inventory;
	private Entity player;
	private boolean gearSet = false;
	
	public EquipingGear(Entity  player) {
		this.player = player;
		
		this.inventory = this.player.getBuild().getInventory();
		
		VBox bodyBoxes = new VBox(20);
		bodyBoxes.setAlignment(Pos.TOP_CENTER);
		
		HBox head = new HBox();
		Label headGearLabel = new Label("On Head:\n "+inventory.getHeadGear().getDescription()+inventory.getHeadGear().getArmourtype());
		headGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.HEAD)) {
					headGear.getItems().add(item);
			}
		}
		headGear.getItems().add(inventory.getHeadGear());
		head.getChildren().addAll(headGearLabel,headGear);

		HBox arms = new HBox();
		Label armsGearLabel = new Label("On Arms:\n "+inventory.getArmsGear().getDescription()+inventory.getArmsGear().getArmourtype());
		armsGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.ARMS)) {
				armsGear.getItems().add(item);
			}
		}
		armsGear.getItems().add(inventory.getArmsGear());
		arms.getChildren().addAll(armsGearLabel,armsGear);
		
		VBox torso = new VBox();
		Label torsoGearLabel = new Label("On Body:\n "+inventory.getTorsoGear()+inventory.getTorsoGear().getArmourtype());
		torsoGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.BODY)) {
				torsoGear.getItems().add(item);
			}
		}
		torsoGear.getItems().add(inventory.getTorsoGear());
		torso.getChildren().addAll(torsoGearLabel,torsoGear);
		
		VBox mainHand = new VBox();
		Label mainHandLabel = new Label("in Mainhand:\n "+inventory.getMainHandGear().getDescription()+this.inventory.getMainHandGear().getWeaponType());
		mainHandGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.MAIN_HAND) && (item.getItemTypeEnum().equals(ItemTypeEnum.WEAPON))) {
				mainHandGear.getItems().add(item);
			}
		}
		//mainHandGear.getItems().add(this.mainHand);
		mainHand.getChildren().addAll(mainHandLabel,mainHandGear);
		
		VBox offHand = new VBox();
		Label offHandLabel = new Label("in offhand:\n "+inventory.getOffHandGear().getDescription());
		offHandGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.OFF_HAND)) {
				offHandGear.getItems().add(item);
			}
		}
		offHandGear.getItems().add(inventory.getOffHandGear());
		offHand.getChildren().addAll(offHandLabel,offHandGear);
		
		HBox legs = new HBox();
		Label legsGearLabel = new Label("On Legs:\n "+inventory.getLegsGear().getDescription()+inventory.getLegsGear().getArmourtype());
		legsGear = new ChoiceBox<Item>();
		for (Item item:this.inventory.getBackPack()) {
			if(item.locationUsed().equals(UsedEnum.LEGS)) {
				legsGear.getItems().add(item);
				
			}
		}
		legsGear.getItems().add(inventory.getLegsGear());
		legs.getChildren().addAll(legsGearLabel,legsGear);
		
		Button setGearButton = new Button("Equip selected gear");
		if (!gearSet) { 
			setGearButton.setText("EQUIP SELECTED GEAR");
		} else {
			setGearButton.setText("gear equiped");
		}
		setGearButton.setOnAction(e -> setGearButton_Click());
		bodyBoxes.getChildren().addAll(head,arms,mainHand,offHand,torso,legs,setGearButton);
					
			
		}
	public void setGearButton_Click() {
		gearSet = true;
		inventory.setHeadGear(headGear.getValue());
		inventory.setArmsGear(armsGear.getValue()); 
		inventory.setTorsoGear(torsoGear.getValue()); 
		inventory.setOffHandGear(offHandGear.getValue());
		inventory.setMainHandGear(mainHandGear.getValue());
		inventory.setLegsGear(legsGear.getValue());
					
		
	}
}


