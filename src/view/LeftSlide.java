package view;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Teach;

public class LeftSlide extends StackPane {
	private Label lblHanzi;
	private Pane paneCover;

	
	public LeftSlide() {
		this.lblHanzi = new Label();
		this.lblHanzi.setFont(new Font("Verdana", 72));
		this.lblHanzi.setWrapText(true);
		
		this.paneCover = new Pane();
		this.paneCover.setBackground(Background.EMPTY);
		
		this.getChildren().add(lblHanzi);
		this.getChildren().add(paneCover);

		this.setOnMouseEntered(e -> this.removeCover());
		this.setOnMouseExited(e -> this.showCover());
	}
	
	public void load(Teach teach) {
		this.lblHanzi.textProperty().bind(teach.getHanziProperty());
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
