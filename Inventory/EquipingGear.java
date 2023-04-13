package Inventory;

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
	
	private Item headGear;
	private Item armsGear;
	private Item torsoGear;
	private Item mainHandGear;
	private Item offHandGear;
	private Item legsGear;
	private Inventory inventory;
	
	public EquipingGear(Inventory inventory) {
		this.inventory = inventory;
		
			VBox bodyBoxes = new VBox(20);
			bodyBoxes.setAlignment(Pos.TOP_CENTER);
			
			HBox head = new HBox();
			Label headGearLabel = new Label("On Head:\n "+this.head.getDescription()+this.head.getArmourtype());
			headGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.HEAD)) {
					
					headGear.getItems().add(item);
					
				}
			}
			headGear.getItems().add(this.head);
			
			head.getChildren().addAll(headGearLabel,headGear);
			
			HBox arms = new HBox();
			Label armsGearLabel = new Label("On Arms:\n "+this.arms.getDescription()+this.arms.getArmourtype());
			armsGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.ARMS)) {
					armsGear.getItems().add(item);
					
				}
			}
			armsGear.getItems().add(this.arms);
			
			arms.getChildren().addAll(armsGearLabel,armsGear);
			
			VBox torso = new VBox();
			Label torsoGearLabel = new Label("On Body:\n "+this.body.getDescription()+this.body.getArmourtype());
			torsoGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.BODY)) {
					torsoGear.getItems().add(item);
					
				}
			}
			torsoGear.getItems().add(this.body);
			
			torso.getChildren().addAll(torsoGearLabel,torsoGear);
			
			VBox mainHand = new VBox();
			Label mainHandLabel = new Label("in Mainhand:\n "+this.mainHand.getDescription()+this.mainHand.getWeaponType());
			mainHandGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.MAIN_HAND) && (item.getItemTypeEnum().equals(ItemTypeEnum.WEAPON))) {
					mainHandGear.getItems().add(item);
					
				}
			}
			
			//mainHandGear.getItems().add(this.mainHand);
			mainHand.getChildren().addAll(mainHandLabel,mainHandGear);
			gearSet = false;
			
			VBox offHand = new VBox();
			Label offHandLabel = new Label("in offhand:\n "+this.offHand.getDescription());
			offHandGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.OFF_HAND)) {
					offHandGear.getItems().add(item);
					
				}
			}
			
			offHandGear.getItems().add(this.offHand);
			
			offHand.getChildren().addAll(offHandLabel,offHandGear);
			
			HBox legs = new HBox();
			Label legsGearLabel = new Label("On Legs:\n "+this.legs.getDescription()+this.legs.getArmourtype());
			legsGear = new ChoiceBox<Item>();
			for (Item item:getBackPackContents()) {
				if(item.locationUsed().equals(UsedEnum.LEGS)) {
					legsGear.getItems().add(item);
					
				}
			}
			legsGear.getItems().add(this.legs);
			
			legs.getChildren().addAll(legsGearLabel,legsGear);
			
			Button setGearButton = new Button("Equip selected gear");
			if (!gearSet) { 
				setGearButton.setText("EQUIP SELECTED GEAR");
			} else {
				setGearButton.setText("gear equiped");
			}
			setGearButton.setOnAction(e -> setGearButton_Click());
			bodyBoxes.getChildren().addAll(head,arms,mainHand,offHand,torso,legs,setGearButton);
					
			return bodyBoxes;
		}
		public void setGearButton_Click() {
			gearSet = true;
			this.head = headGear.getValue();
			this.arms = armsGear.getValue();
			this.body = torsoGear.getValue();
			this.offHand = offHandGear.getValue();
			this.mainHand.setVisabilityFalse();
			this.mainHand = mainHandGear.getValue();
			this.mainHand.setVisabilityTrue();
			this.legs = legsGear.getValue();
			displayCharacterInventoryPane();
		}
	}

}
