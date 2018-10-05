package circularMenu;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Element extends JPanel {

	private Color activeColor ;
	private Color inactiveColor ;
	private Color currentColor ; // Will be whether activeColor or inactiveColor
	
	private String label ;
	
	private int size ;

	private MouseListener mouseListener = new MouseListener () { 
		public void mouseClicked(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {
			currentColor = inactiveColor;
			repaint();
		}
		public void mouseEntered(MouseEvent e) {
			currentColor = activeColor;
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			repaint();
		}
	};
	
	public Element(String label, Color activeColor, Color inactiveColor, int size) {
		super();
		this.activeColor = activeColor;
		this.inactiveColor = inactiveColor;
		this.label = label;
		this.size = size;
		this.setSize(new Dimension(size, size));
		addMouseListener(mouseListener);
	}
	
	public void paint(Graphics arg0) {
		super.paint(arg0);
		Graphics2D g2d = (Graphics2D) arg0;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(currentColor);
		g2d.fillRect(0, 0, size, size);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Helvetica", Font.PLAIN, 12));
		g2d.drawString(label, 0, 0);
	}
	
}
