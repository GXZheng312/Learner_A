import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MyScene;

public class Main extends Application {

	public final static String TITLE = "Learner A";
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Controller controller = new Controller();
		MyScene myScene = new MyScene(controller);
		
		controller.loadScene(myScene);
		
		stage.setScene(myScene);
		stage.setTitle(TITLE);
		stage.show();
		
	}

}
