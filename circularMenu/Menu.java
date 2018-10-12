package circularMenu;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;


public class Menu extends JPanel{

	private List<Element> items;

	private int elementSize;

	private int radius;

	public Menu(int width, int height, int elementSize, int radius, List<Element> items) {
		super();
		setSize(width, height);
		this.items = items;
		this.elementSize = elementSize;
		this.radius = radius;
		positionElements();
	}
	
	public void positionElements(){
		double angle = 2 * Math.PI / items.size();
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		for(int i = 0 ; i < items.size(); i++){
			items.get(i).setBounds(
					(int) (xCenter - (elementSize / 2) + radius * Math.cos((i * angle) - (Math.PI / 2))),
					(int) (yCenter - (elementSize / 2) + radius * Math.sin((i * angle) - (Math.PI / 2))),
					elementSize,
					elementSize
					);
			add(items.get(i));
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillRect(0, 0, getWidth(), getHeight());	}
	
}
