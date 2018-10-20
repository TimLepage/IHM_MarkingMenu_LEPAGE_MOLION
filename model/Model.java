package model;

import java.util.ArrayList;
import java.util.List;

import view.Element;
import view.Tool;

public class Model {

	List<Element> elementsList;

	Tool currentTool;

	public Model() {
		List<Element> buildList = new ArrayList<Element>();
		buildList.add(new Element("Outil", 50));
		buildList.add(new Element("Couleur", 50));
		elementsList = buildList; 
	}
	
	public List<Element> getElementsList() {
		return elementsList;
	}

	public void setCurrentTool(Tool tool) {
		currentTool = tool;
	}

	public Tool getCurrentTool() {
		return currentTool;
	}

}
