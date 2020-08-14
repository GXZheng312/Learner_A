package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Teach {

	private MyFile file;

	private boolean isRightSlide;
	private StringProperty hanziProperty;
	private StringProperty pinYinProperty;
	private StringProperty infoProperty;

	public Teach() {
		this.hanziProperty = new SimpleStringProperty(this, "hanzi");
		this.pinYinProperty = new SimpleStringProperty(this, "pinYin");
		this.infoProperty = new SimpleStringProperty(this, "info");
		this.setRightSlide(true);
		
		this.file = new MyFile();
	}

	public void shuffle() {
		ArrayList<ConceptProperty> ar = this.file.getConcepts();
		Collections.shuffle(ar);
		this.file.setConcepts(ar);
	}

	public void setProperty(ConceptProperty concept) {
		this.hanziProperty.set(concept.getHanzi());
		this.pinYinProperty.set(concept.getPinYin());
		this.infoProperty.set(concept.getExtraInfo());
	}

	public MyFile getFile() {
		return this.file;
	}

	public StringProperty getHanziProperty() {
		return hanziProperty;
	}

	public StringProperty getPinYinProperty() {
		return pinYinProperty;
	}

	public StringProperty getInfoProperty() {
		return infoProperty;
	}

	public boolean isRightSlide() {
		return isRightSlide;
	}

	public void setRightSlide(boolean isRightSlide) {
		this.isRightSlide = isRightSlide;
	}
}
