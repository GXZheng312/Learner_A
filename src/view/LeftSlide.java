package view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import model.ConceptProperty;
import model.Teach;

public class LeftSlide extends StackPane {
	private Label lblHanzi;
	
	public LeftSlide() {
		this.lblHanzi = new Label();
		
		this.getChildren().add(lblHanzi);
	}
	
	public void load(Teach teach) {
		this.lblHanzi.textProperty().bind(teach.getHanziProperty());
	}

}
