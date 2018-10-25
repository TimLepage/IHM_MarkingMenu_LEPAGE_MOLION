package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class Menu extends JPanel {

	private Element centerElement;
	private List<Element> items;

	private int x;
	private int y;
	private int elementSize;

	private int radius;

	private Color backgroundColor;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Menu(int x, int y, int width, int height, int elementSize, int radius, List<Element> items, View view) {
		super();
		this.centerElement = new Element("Annuler", elementSize, this, view, new Color(135, 135, 135));
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
		int inCircle = Math.min(items.size(), 7);
		double angle = 2 * Math.PI / inCircle;
		int xCenter = this.x;
		int yCenter = this.y;
		int vertSpace = elementSize + 5; // vertical space between +7 items
		for (int i = 0; i < inCircle; i++) {
			items.get(i).setBounds((int) (xCenter - (elementSize / 2) + radius * Math.cos((i * angle) - (Math.PI / 2))),
					(int) (yCenter - (elementSize / 2) + radius * Math.sin((i * angle) - (Math.PI / 2))),
					this.elementSize, this.elementSize);
			add(items.get(i));
		}
		for (int nItem = 7, i = 0; nItem < items.size(); i++, nItem++) {
			items.get(nItem).setBounds(xCenter - (elementSize / 2),
					yCenter + (elementSize / 2) + radius + i * vertSpace, this.elementSize, this.elementSize);
			add(items.get(nItem));
		}
		this.centerElement.setBounds(xCenter - this.elementSize / 2, yCenter - this.elementSize / 2, this.elementSize,
				this.elementSize);
		add(this.centerElement);

	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

}
