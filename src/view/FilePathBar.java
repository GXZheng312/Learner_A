package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.Teach;

public class FilePathBar extends HBox {

	private TextField txfFilePath;
	
	public FilePathBar(Controller controller) {
		Label lblFilePath = new Label("Location: ");
		lblFilePath.setFont(new Font("Verdana", 20));
		
		this.txfFilePath = new TextField();
		this.txfFilePath.setPrefWidth(420);
		
		Button btnFileSelector = new Button("Search");
		btnFileSelector.setPrefSize(75, 50);
		btnFileSelector.setOnMouseClicked(e -> controller.openFile());

		this.getChildren().addAll(lblFilePath, txfFilePath, btnFileSelector);
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setPadding(new Insets(10,10,10,10));
		this.setSpacing(10);
	}

	public void load(Teach teach) {
		this.txfFilePath.textProperty().bind(teach.getFile().getfileLocationProperty());
	}
	
}
