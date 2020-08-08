package view;

import controller.Controller;
import javafx.scene.layout.StackPane;
import model.ConceptProperty;
import model.Teach;

public class CenterView extends StackPane {
	
	private LeftSlide leftSlide;
	private RightSlide rightSlide;
	
	public CenterView(Controller controller) {
		this.leftSlide = new LeftSlide();
		this.rightSlide = new RightSlide();
		
		this.getChildren().addAll(leftSlide, rightSlide);
	}

	public void load(Teach teach) {
		this.leftSlide.load(teach);
		this.rightSlide.load(teach);
	}
	
}
