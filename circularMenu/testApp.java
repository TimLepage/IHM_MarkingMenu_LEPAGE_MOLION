package circularMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testApp {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		List<Element> items = new ArrayList<Element>();
		
		items.add(new Element("Menu1", 100));
		items.add(new Element("Menu2", 100));
		items.add(new Element("Menu3", 100));
		items.add(new Element("Menu4", 100));
		items.add(new Element("Menu5", 100));
		items.add(new Element("Menu6", 100));
		items.add(new Element("Menu7", 100));
		f.setSize(600, 600);
		Menu menu = new Menu(600, 600, 100, 200, items);
		f.add(menu, BorderLayout.CENTER);
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
