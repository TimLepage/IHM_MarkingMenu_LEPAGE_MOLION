package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
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
import java.util.ArrayList;
import java.util.List;

public class Element extends JPanel {

	private final Color activeColor = new Color(80, 80, 80);
	private final Color inactiveColor = new Color(135, 135, 135);
	private Color currentColor; // Will be whether activeColor or inactiveColor
	private Color backgroundColor = new Color(0, 0, 0, 0);
	private JPanel parent;
	private String label;
	private View view;
	private static int oldclickx;
	private static int oldclicky;

	private int size;

	private MouseListener mouseListener = new MouseListener() {
		public void mouseClicked(MouseEvent e) {
			if (label.equals("Cancel")) {
				System.out.println("Cancel");
				parent.removeAll();
				view.repaint();
				removeAll();
				repaint();
				List<Element> buildList = new ArrayList<Element>();
				buildList.add(new Element("Outil", 50, view.getPanel(), view));
				buildList.add(new Element("Couleur", 50, view.getPanel(), view));
				Menu menu = new Menu(oldclickx, oldclicky, 800, 600, 50, 70,
						buildList, view);
				parent.add(menu, BorderLayout.CENTER);
				parent.repaint();
				view.repaint();
			}			
		}

		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
			currentColor = inactiveColor;
			repaint();
		}

		public void mouseEntered(MouseEvent e) {
			currentColor = activeColor;
			setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			if (label.equals("Outil")) {
				parent.removeAll();
				view.repaint();
				List<Element> itemsShapeMenu = new ArrayList<Element>();
				itemsShapeMenu.add(new Element("Pinceau", 50, parent, view));
				itemsShapeMenu.add(new Element("Rectangle", 50, parent, view));
				itemsShapeMenu.add(new Element("Oval", 50, parent, view));
				oldclickx = PanelMouseListener.clickx;
				oldclicky = PanelMouseListener.clicky - 70;
				Menu menu = new Menu(oldclickx, oldclicky, 800, 600, 50, 70,
						itemsShapeMenu, view);
				parent.add(menu, BorderLayout.CENTER);
				view.repaint();
				parent.repaint();
			} else if (label.equals("Couleur")) {
				parent.removeAll();
				view.repaint();
				List<Element> itemsColorMenu = new ArrayList<Element>();
				itemsColorMenu.add(new Element("Noir", 50, parent, view));
				itemsColorMenu.add(new Element("Rouge", 50, parent, view));
				itemsColorMenu.add(new Element("Bleu", 50, parent, view));
				itemsColorMenu.add(new Element("Vert", 50, parent, view));
				oldclickx = PanelMouseListener.clickx;
				oldclicky = PanelMouseListener.clicky + 70;
				Menu menu = new Menu(oldclickx, oldclicky, 800, 600, 50, 70,
						itemsColorMenu, view);
				parent.add(menu, BorderLayout.CENTER);
				view.repaint();
				parent.repaint();
			} else if (!label.equals("Cancel")) {
				parent.removeAll();
				parent.repaint();
				if (label.equals("Noir")) {
					view.setCurrentColor(Color.BLACK);
				} else if (label.equals("Rouge")) {
					view.setCurrentColor(Color.RED);
				} else if (label.equals("Bleu")) {
					view.setCurrentColor(Color.BLUE);
				} else if (label.equals("Vert")) {
					view.setCurrentColor(Color.GREEN);
				}
				if (label.equals("Pinceau")) {
					JButton selectedTool = new JButton(view.getToolbar()[0]);
					selectedTool.doClick();
				} else if (label.equals("Rectangle")) {
					JButton selectedTool = new JButton(view.getToolbar()[1]);
					selectedTool.doClick();
				} else if (label.equals("Oval")) {
					JButton selectedTool = new JButton(view.getToolbar()[2]);
					selectedTool.doClick();
				}
			}
			currentColor = inactiveColor;
			repaint();
		}
	};

	public Element(String label, int size, JPanel panel, View view) {
		super();
		this.view = view;
		this.parent = panel;
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
