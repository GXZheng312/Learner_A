package model;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyFile {

	private StringProperty fileLocationProperty;
	private ArrayList<ConceptProperty> concepts;
	private IntegerProperty counterProperty;
	
	public MyFile() {
		this.concepts = new ArrayList<ConceptProperty>();
		this.fileLocationProperty = new SimpleStringProperty(this, "fileLocation");
		this.fileLocationProperty.set("");
		
		this.counterProperty = new SimpleIntegerProperty(this, "counter");
		this.counterProperty.set(0);
	}

	public String getFileLocation() {
		return this.fileLocationProperty.get();
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocationProperty.set(fileLocation);
	}

	public final StringProperty getfileLocationProperty() {
		return this.fileLocationProperty;
	}

	public final IntegerProperty getCounterProperty() {
		return this.counterProperty;
	}
	
	public ArrayList<ConceptProperty> getConcepts() {
		return concepts;
	}

	public void setConcepts(ArrayList<ConceptProperty> concepts) {
		this.concepts = concepts;
		this.counterProperty.set(concepts.size());
	}
	
	
	
}
