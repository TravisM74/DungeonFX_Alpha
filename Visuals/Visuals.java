package Visuals;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Visuals {
	private Pane center;
	public Visuals (Pane center) {
		this.center = center;
	}

	public void addVusualForm(Group form) {
		this.center.getChildren().add(form);
	}
	public void removeVisualForm(Group form) {
		this.center.getChildren().remove(form);
	}
}
