package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


import Gfx.HumanoidForm;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class CharacterClass {
	private int hitDice;
	private String className;
	private int requiredStat;
	private int armourClass;
	private int init;
	private int xpValue;
	
	private Color hairColor;
	private Color skinColor;
	private Color eyeColor ;
	private Color topColor ;
	private Color pantsColor ;
	private Color shoeColor ;
	private Group defaultEntityForm;
	
	
	CharacterClassEnum charClass;
	
	public CharacterClass(CharacterClassEnum characterClass) {
		this.charClass = characterClass;
		Random rand = new Random();
		
		switch (charClass) {
		case FIGHTER:
			//test Override value set to 1 from 10
			this.hitDice = 1;
			
			this.className = "Fighter";
			this.hairColor = Color.BROWN;
			this.skinColor =Color.CORNSILK;
			this.eyeColor = Color.BLUE;
			this.topColor = Color.BROWN;
			this.pantsColor = Color.BLUE;
			this.shoeColor = Color.DARKGREY;
			this.defaultEntityForm = new HumanoidForm(hairColor,skinColor,eyeColor,topColor,pantsColor,shoeColor);
			break;
			
		case BARBARIAN:
			this.hitDice = 12;
			rand = new Random();
			int red = rand.nextInt(255);
			int green = rand.nextInt(255);
			int blue = rand.nextInt(255);
			this.hairColor = Color.rgb(red, green, blue);
			this.skinColor =Color.BROWN;
			this.eyeColor = Color.LIGHTBLUE;
			this.topColor = Color.BROWN;
			int redbp = rand.nextInt(255);
			int greenbp = rand.nextInt(255);
			int bluebp = rand.nextInt(255);
			this.pantsColor = Color.rgb(redbp, greenbp, bluebp);
			this.shoeColor = Color.DARKGREY;
			this.defaultEntityForm = new HumanoidForm(hairColor,skinColor,eyeColor,topColor,pantsColor,shoeColor);
			this.className = "Barbarian";
			break;
			
		case THEIF:
			this.hitDice = 6;
			this.className = "Theif";
			break;
		
		case ORC:
			this.hitDice = 8;
			this.className = "Orrrck Bashaa";
			this.armourClass = 7;
			this.init = 12;
			this.xpValue = 100;
			rand = new Random();
			int ored = rand.nextInt(255);
			int ogreen = rand.nextInt(255);
			int oblue = rand.nextInt(255);
			this.hairColor = Color.rgb(ored, ogreen, oblue);
			this.skinColor =Color.GREEN;
			int redp = rand.nextInt(255);
			int greenp = rand.nextInt(255);
			int bluep = rand.nextInt(255);
			this.pantsColor = Color.rgb(redp, greenp, bluep);
			int redt = rand.nextInt(255);
			int greent = rand.nextInt(255);
			int bluet = rand.nextInt(255);
			this.topColor = Color.rgb(redt, greent, bluet);
			this.eyeColor = Color.RED;
			this.shoeColor = Color.GREEN;
			this.defaultEntityForm = new HumanoidForm(hairColor,skinColor,eyeColor,topColor,pantsColor,shoeColor);
									
			break;
		}
	}
	public Group getDefaultEntityForm() {
		return this.defaultEntityForm;
	}
	public int getXPValue() {
		return this.xpValue;
	}
	
	public int getHitDice () {
		return this.hitDice;
	}
	public String getClassName() {
		return this.className;
	}
	public int getRequiredStat() {
		return requiredStat;
	}
	public int getArmourClass() {
		return armourClass;
	}
	
	public int getInit() {
		return init;
	}
	public String toString() {
		return this.className;
	}
	public CharacterClassEnum getCharacterClassEnum() {
		return charClass;
	}
	
}