package view;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controler.Controler;

public class PanelMouseListener implements MouseListener{

	JPanel associatedPanel ;
	Controler associatedControler ;
	
	public PanelMouseListener(Controler controler, JPanel panel) {
		super();
		associatedPanel = panel ;
		associatedControler = controler ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {//if right click
			Menu menu = new Menu(e.getX(), e.getY(), 800, 600, 50, 70, associatedControler.getModel().getElementsList());
			associatedPanel.add(menu, BorderLayout.CENTER);
			associatedPanel.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
