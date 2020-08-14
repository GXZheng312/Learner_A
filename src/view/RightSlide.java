package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Teach;

public class RightSlide extends StackPane {
	
	private Label lblPinYin;
	private Label lblInfo;
	private Pane paneCover;
	
	public RightSlide() {
		this.lblPinYin = new Label();
		this.lblPinYin.setFont(new Font("Verdana", 72));
		this.lblPinYin.setMaxHeight(Double.MAX_VALUE);
		
		this.lblInfo = new Label();
		this.lblInfo.setFont(new Font("Verdana", 42));
		this.lblInfo.setMaxHeight(Double.MAX_VALUE);
		
		VBox vContainer = new VBox();
		VBox.setVgrow(lblPinYin, Priority.ALWAYS);
		VBox.setVgrow(lblInfo, Priority.ALWAYS);
		vContainer.setAlignment(Pos.CENTER);
		vContainer.getChildren().addAll(lblPinYin, lblInfo);
		
		this.paneCover = new Pane();
		this.paneCover.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
		this.getChildren().add(vContainer);	
		this.getChildren().add(paneCover);	
		this.setAlignment(Pos.CENTER);
		
		this.setOnMouseEntered(e -> this.removeCover());
		this.setOnMouseExited(e -> this.showCover());
	}

	public void load(Teach teach) {
		this.lblPinYin.textProperty().bind(teach.getPinYinProperty());
		this.lblInfo.textProperty().bind(teach.getInfoProperty());
	}

	private void removeCover() {
		if(this.paneCover.getBackground() != Background.EMPTY) {
			this.paneCover.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		}
	}
	
	private void showCover() {
		if(this.paneCover.getBackground() != Background.EMPTY) {
			this.paneCover.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		}
	}

	public void toggleCover(boolean cover) {
		if(cover) {
			this.paneCover.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		} else {
			this.paneCover.setBackground(Background.EMPTY);
		}
	}
	
}
