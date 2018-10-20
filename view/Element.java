package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Element extends JPanel {

	private final Color activeColor = new Color(80, 80, 80);
	private final Color inactiveColor = new Color(135, 135, 135);
	private Color currentColor ; // Will be whether activeColor or inactiveColor
	private Color backgroundColor = new Color(0,0,0,0);
	
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
	
	public Element(String label, int size) {
		super();
		this.setBackground(backgroundColor);
		this.currentColor = inactiveColor;
		this.backgroundColor = new Color(0, 0, 0, 0);
		this.label = label;
		this.size = size;
		this.setSize(new Dimension(size, size));
		addMouseListener(mouseListener);
	}
	
	public void paint(Graphics arg0) {
		super.paint(arg0);
		Graphics2D g2d = (Graphics2D) arg0;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw oval
		g2d.setColor(currentColor);
		g2d.fillOval(0, 0, size, size);
		
		// Draw text (adapted from https://stackoverflow.com/a/27740330/6304206)
		Font font = new Font("Helvetica", Font.PLAIN, 12);
	    FontMetrics metrics = g2d.getFontMetrics(font);
	    int x = (getWidth() - metrics.stringWidth(label)) / 2;
	    int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
	    g2d.setFont(font);
		g2d.setColor(Color.BLACK);
	    g2d.drawString(label, x, y);

	}
	
}
