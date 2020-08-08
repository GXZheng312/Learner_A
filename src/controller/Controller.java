package controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.ConceptProperty;
import model.MyFile;
import model.Teach;
import view.MyScene;

public class Controller {

	public MyScene myScene;
	public Teach teach;

	public Controller() {
		this.teach = new Teach();
	}

	public void loadScene(MyScene myScene) {
		this.myScene = myScene;
		this.myScene.load(this.teach);
	}

	public void openFile() {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Text Files", "*.txt"));
		File currentDir = new File(System.getProperty("user.dir"));
		chooser.setInitialDirectory(currentDir);

		File file = chooser.showOpenDialog(this.myScene.getWindow());

		if (file == null) {
			return;
		}

		try {
			this.teach.getFile().setFileLocation(file.getPath());

			ArrayList<ConceptProperty> arr = new ArrayList<ConceptProperty>();

			for (String s : Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)) {
				String[] parts = s.split(",");
				String hanzi, pinyin, explain;
				
				hanzi = parts[0];
				pinyin = parts[1];
				
				if(parts.length > 2 ) {
					explain = parts[2];
				} else {
					explain = "";
				}
				ConceptProperty conceptProperty = new ConceptProperty(hanzi, pinyin, explain);
				
				arr.add(conceptProperty);
			}

			this.teach.getFile().setConcepts(arr);

			resetConcept();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void resetConcept() {
		MyFile file = this.teach.getFile();

		file.getCounterProperty().set(file.getConcepts().size());

		int fileIndex = file.getConcepts().size() - file.getCounterProperty().get();

		this.teach.setProperty(file.getConcepts().get(fileIndex));

		this.teach.shuffle();

		nextConcept();
	}

	public void nextConcept() {
		MyFile file = this.teach.getFile();
		
		if (file.getCounterProperty().get() <= 0) {
			return;
		}
		
		file.getCounterProperty().set(file.getCounterProperty().get() - 1);

		int fileIndex = file.getConcepts().size() - file.getCounterProperty().get() - 1;

		this.teach.setProperty(file.getConcepts().get(fileIndex));

	}

}
