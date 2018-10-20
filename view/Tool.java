package view;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import model.Model;

public class Tool extends AbstractAction implements MouseInputListener {

	private View view ; // The view the tool is in
	private Model model ;
	
	public Point o;
	public Shape shape;

	private String name ;
	
	public Tool(String name, View view, Model model) {
		super(name);
		this.name = name ;
		this.view = view ;
		this.model = model ;
	}

	public void actionPerformed(ActionEvent e) {
		Tool oldTool = view.getModel().getCurrentTool() ;
		JPanel panel = view.getPanel();
		System.out.println("using tool " + this.name);
		panel.removeMouseListener(oldTool);
		panel.removeMouseListener(oldTool);
		panel.removeMouseMotionListener(oldTool);
		model.setCurrentTool(this);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Right Click!");
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		o = e.getPoint();
	}

	public void mouseReleased(MouseEvent e) {
		shape = null;
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}
}
