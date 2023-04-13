package Gfx;


	
	import java.util.Random;

import Items.Quality;
	import Items.QualityEnum;

	import javafx.scene.Group;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

	public class Long_Sword extends Group implements HeldItem{
		
		private Group item;
		
		private Color color;
		private Quality quality;
		private Color baseColor;
		//private double scale = .13;
		private double scale = .14;
		private double startPointX = 0;
		private double startPointY = 0;
		private double swordLength = 160;
		private double handleEnd = 20;
		private double itemRotateAngle;
		
		public Long_Sword() {
			
			this.item = new Group();
			Random rand = new Random();
			itemRotateAngle = rand.nextDouble(180) -90;
			
			Rotate rotate = new Rotate();
			rotate.setPivotX(startPointX);
			rotate.setPivotY(startPointY);
			
			item.getTransforms().add(rotate);
			rotate.setAngle(itemRotateAngle);
			//this.baseColor = quality.getBaseColor();
			
			drawHandle();
			drawBlade();
			
		}
		public void drawHandle() {
			Line handleLine = new Line();
			handleLine.setStroke(Color.SADDLEBROWN);
			handleLine.setStartX(startPointX);
			handleLine.setStartY(startPointY);
			handleLine.setEndX(startPointX + handleEnd*scale);
			handleLine.setEndY(startPointY);
			handleLine.setStrokeWidth(12*scale);
			item.getChildren().add(handleLine);
			
		}
		public void drawBlade() {
			Line bladeLine = new Line();
			
			bladeLine.setStroke(Color.GRAY);
			bladeLine.setStartX(startPointX + handleEnd*scale + (12*scale));
			bladeLine.setStartY(startPointY);
			bladeLine.setEndX(startPointX + swordLength*scale);
			bladeLine.setEndY(startPointY);
			bladeLine.setStrokeWidth(24*scale);
			item.getChildren().add(bladeLine);
			
		}
		
		public Group getItemForm() {
			return this.item;
		}
		public void setStartPointX(double value) {
			this.startPointX = value;
			
		}
		public void setStartPointY(double value) {
			this.startPointY = value;
		}
		public void setQuality(Quality quality) {
			this.quality =quality;
		}
	}


