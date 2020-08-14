package view;

import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import model.Teach;

public class MyScene extends Scene {
	
	public final static double MIN_HEIGHT = 480;
	public final static double MIN_WIDTH = 640;
	
	private InfoBar infoBar;
	private CenterView centerView;
	private BottomView bottomView;
	
	public MyScene(Controller controller) {
		super(new BorderPane(), MIN_WIDTH, MIN_HEIGHT);
		BorderPane root = (BorderPane)this.getRoot();
		
		this.infoBar = new InfoBar();
		this.centerView = new CenterView(controller);
		this.bottomView = new BottomView(controller);
		
		root.setTop(infoBar);
		root.setCenter(centerView);
		root.setBottom(bottomView);
	}
	
	public void load(Teach teach) {
		this.infoBar.load(teach);
		this.bottomView.load(teach);
		this.centerView.load(teach);
	}

	public void swapSlideCover(Boolean isRightSlide) {
		this.centerView.swapSlideCover(isRightSlide);
	}
}
