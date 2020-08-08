package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Teach;

public class BottomView extends StackPane{

	private FilePathBar filePathBar;
	
	public BottomView(Controller controller) {	
		Button btnNext = new Button("Next");
		btnNext.setOnMouseClicked(e -> controller.nextConcept());
		
		Button btnReset = new Button("Reset");
		btnReset.setOnMouseClicked(e -> controller.resetConcept());
		
		HBox buttonBox = new HBox();
		buttonBox.getChildren().addAll(btnNext, btnReset);
		
		VBox Container = new VBox();
		this.filePathBar = new FilePathBar(controller);
		Container.getChildren().addAll(this.filePathBar, buttonBox);
		
		this.getChildren().add(Container);
	}

	public void load(Teach teach) {
		this.filePathBar.load(teach);
	}
	
}
