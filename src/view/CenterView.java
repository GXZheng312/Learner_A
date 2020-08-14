package view;

import controller.Controller;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.Teach;

public class CenterView extends HBox {

	private LeftSlide leftSlide;
	private RightSlide rightSlide;

	public CenterView(Controller controller) {
		Double sizeSplit = MyScene.MIN_WIDTH/2 + 5;
		
		this.leftSlide = new LeftSlide();
		this.leftSlide.setPrefWidth(sizeSplit);
		this.leftSlide.setMaxWidth(sizeSplit);
		this.leftSlide.setMinWidth(sizeSplit);
		
		this.rightSlide = new RightSlide();
		this.rightSlide.setPrefWidth(sizeSplit);
		this.rightSlide.setMaxWidth(sizeSplit);
		this.rightSlide.setMinWidth(sizeSplit);

		this.getChildren().addAll(leftSlide, rightSlide);
		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));

	}

	public void load(Teach teach) {
		this.leftSlide.load(teach);
		this.rightSlide.load(teach);
	}

	public void swapSlideCover(boolean isRightSlide) {
		if(isRightSlide) {
			this.rightSlide.toggleCover(true);
			this.leftSlide.toggleCover(false);
		} else {
			this.rightSlide.toggleCover(false);
			this.leftSlide.toggleCover(true);
		}
	}

}
