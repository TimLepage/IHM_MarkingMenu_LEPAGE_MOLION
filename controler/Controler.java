package controler;

import javax.swing.JFrame;

import model.Model;
import view.PanelMouseListener;
import view.View;

public class Controler {

	Model model ;
	View view;
	
	public Controler(View view) {
		model = new Model(view);
		this.view = view;
	}
	
	public void addMouseListeners(View view) {
		view.getPanel().addMouseListener(new PanelMouseListener(this, view.getPanel()));
	}

	public Model getModel(){
		return model ;
	}
	public View getView(){
		return this.view;
	}
	
}
