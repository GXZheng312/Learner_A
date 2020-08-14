package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Teach;

public class BottomView extends StackPane{

	private FilePathBar filePathBar;
	
	public BottomView(Controller controller) {	
		Button btnNext = new Button("Next");
		btnNext.setPrefSize(75, 50);
		btnNext.setOnMouseClicked(e -> controller.nextConcept());
		
		Button btnReset = new Button("Reset");
		btnReset.setPrefSize(75, 50);
		btnReset.setOnMouseClicked(e -> controller.resetConcept());
		
		Button btnSwitch = new Button("Hanzi");
		btnSwitch.setPrefSize(75, 50);
		btnSwitch.setOnMouseClicked(e -> controller.swapSlideCover(btnSwitch));
		
		HBox buttonBox = new HBox();
		buttonBox.setAlignment(Pos.CENTER_RIGHT);
		buttonBox.setSpacing(10);
		buttonBox.setPadding(new Insets(0,10,10,10));
		buttonBox.getChildren().addAll(btnSwitch, btnNext, btnReset);
		
		VBox Container = new VBox();
		this.filePathBar = new FilePathBar(controller);
		Container.getChildren().addAll(this.filePathBar, buttonBox);
		
		this.getChildren().add(Container);
	}
	
	public void load(Teach teach) {
		this.filePathBar.load(teach);
	}
	
}
