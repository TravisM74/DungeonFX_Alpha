package Display;

import javafx.scene.layout.BorderPane;

public class StatusStateDisplay {
	private BorderPane root;
	
	
	public StatusStateDisplay() {
		
	
	}
	
	public BorderPane displayStatus() {
		return this.root;
	}
	
	public void update() {
		root = new BorderPane();
	}

}
