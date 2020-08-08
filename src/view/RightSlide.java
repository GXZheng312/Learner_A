package view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.ConceptProperty;
import model.Teach;

public class RightSlide extends StackPane {
	
	private Label lblPinYin;
	private Label lblInfo;
	
	public RightSlide() {
		this.lblPinYin = new Label();
		this.lblInfo = new Label();
		
		VBox vContainer = new VBox();
		vContainer.getChildren().addAll(lblPinYin, lblInfo);
		
		this.getChildren().add(vContainer);	
	}

	public void load(Teach teach) {
		this.lblPinYin.textProperty().bind(teach.getPinYinProperty());
		this.lblInfo.textProperty().bind(teach.getInfoProperty());
	}
	
}
