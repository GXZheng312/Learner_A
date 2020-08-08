package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Teach;

public class FilePathBar extends HBox {

	private TextField txfFilePath;
	
	public FilePathBar(Controller controller) {
		Label lblFilePath = new Label("Location: ");
		this.txfFilePath = new TextField();
		Button btnFileSelector = new Button("Search");
		btnFileSelector.setOnMouseClicked(e -> controller.openFile());
		
		this.getChildren().addAll(lblFilePath, txfFilePath, btnFileSelector);
		
	}

	public void load(Teach teach) {
		this.txfFilePath.textProperty().bind(teach.getFile().getfileLocationProperty());
	}
	
}
