package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.MyFile;
import model.Teach;

public class InfoBar extends HBox {
	
	private Label counterLbl;
	
	public InfoBar() {
		Label amountLbl = new Label();
		amountLbl.setText("Amount Left");
		
		this.counterLbl = new Label();
		this.counterLbl.setText("0");
		
		this.getChildren().setAll(amountLbl, this.counterLbl);
		
	}

	public void load(Teach teach) {
		this.counterLbl.textProperty().bind(teach.getFile().getCounterProperty().asString());
		
	}
	
}
