package Inventory;

import java.util.ArrayList;

import Items.Item;

public class Inventory {
	
	private ArrayList<Item> backpack;
	private Item mainhand;
	private Item headGear;
	private Item armsGear;
	private Item torsoGear;
	private Item mainHandGear;
	private Item offHandGear;
	private Item legsGear;
	private int gold;
	private int silver;
	private int copper;
	

	public Inventory() {
		this.backpack= new ArrayList<>();
		this.gold= 0;
		this.silver = 0;
		this.copper = 0;
		
		
	}
	
	public void putItemInBackPack(Item item) {
		this.backpack.add(item);
	}
	public Item getItemFromBackPack(int value) {
		return this.backpack.get(value);
	}
	public ArrayList<Item> getBackPack(){
		return this.backpack;
	}
	public void setMainhand(Item item) {
		this.mainhand = item;
	}
	public Item getMainhandItem() {
			return this.mainhand;
		
	}
	private String listBackPackItems() {
		String textOut = "";
		for (Item item:backpack) {
			textOut+=(item.getDescription() + "\n");
		}
		return textOut;
		
	}
	
	public String toString() {
		return "Gold \t:" + this.gold +"\n"+
				"Silver \t:" +this.silver +"\n"+
				"Copper \t:" + this.copper +"\n"+
				" \n Items (" +backpack.size() +")"+" \n"+ listBackPackItems();
				
				
	}
}
