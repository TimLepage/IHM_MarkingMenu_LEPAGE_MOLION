package controler;

import javax.swing.JFrame;

import model.Model;
import view.PanelMouseListener;
import view.View;

public class Controler {

	Model model ;
	
	public Controler() {
		model = new Model();
	}
	
	public void addMouseListeners(View view) {
		view.getPanel().addMouseListener(new PanelMouseListener(this, view.getPanel()));
	}

	public Model getModel(){
		return model ;
	}
	
}
