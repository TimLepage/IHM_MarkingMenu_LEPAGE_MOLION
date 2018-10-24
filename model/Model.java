package model;

import java.util.ArrayList;
import java.util.List;

import view.Element;
import view.Tool;
import view.View;

public class Model {

	List<Element> elementsList;

	Tool currentTool;

	public Model(View view) {
		List<Element> buildList = new ArrayList<Element>();
		buildList.add(new Element("Outil", 50, view.getPanel(), view));
		buildList.add(new Element("Couleur", 50, view.getPanel(), view));
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
