package circularMenu;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class Menu extends JPanel {

	private Element centerElement ;
	private List<Element> items;

	private int x;
	private int y;
	private int elementSize;

	private int radius;

	private Color backgroundColor;
	
	
	public Menu(int x, int y, int width, int height, int elementSize, int radius, List<Element> items) {
		super();
		this.centerElement = new Element("Cancel", elementSize);
		setSize(width, height);
		this.x = x;
		this.y = y;
		this.items = items;
		this.elementSize = elementSize;
		this.radius = radius;
		this.backgroundColor = new Color(0, 0, 0, 0);
		positionElements();
	}

	public void positionElements() {
		setLayout(null);
		double angle = 2 * Math.PI / this.items.size();
		int xCenter = this.x;
		int yCenter = this.y;
		for (int i = 0; i < items.size(); i++) {
			items.get(i).setBounds(
					(int) (xCenter - (elementSize / 2) + radius * Math.cos((i * angle) - (Math.PI / 2))),
					(int) (yCenter - (elementSize / 2) + radius * Math.sin((i * angle) - (Math.PI / 2))),
					this.elementSize, this.elementSize);
			add(items.get(i));
		}
		this.centerElement.setBounds(xCenter - this.elementSize / 2, yCenter - this.elementSize / 2, this.elementSize, this.elementSize);
		add(this.centerElement);
		
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

}
