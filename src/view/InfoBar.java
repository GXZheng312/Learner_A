package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import model.Teach;

public class InfoBar extends HBox {
	
	private Label counterLbl;
	
	public InfoBar() {
		Label amountLbl = new Label();
		amountLbl.setFont(new Font("Verdana", 20));
		amountLbl.setText("Amount Left");
		
		this.counterLbl = new Label();
		this.counterLbl.setFont(new Font("Verdana", 20));
		this.counterLbl.setText("0");
	
		this.getChildren().setAll(amountLbl, this.counterLbl);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
		this.setPadding(new Insets(10,0,10,0));
	}

	public void load(Teach teach) {
		this.counterLbl.textProperty().bind(teach.getFile().getCounterProperty().asString());
		
	}
	
}
