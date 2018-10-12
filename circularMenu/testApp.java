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
		Color backgroundColor = new Color(220, 220, 220);
		items.add(new Element("Menu1", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu2", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu3", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu4", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu5", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu6", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		items.add(new Element("Menu7", new Color(19, 73, 140), new Color(162, 198, 232), backgroundColor, 100));
		f.setSize(600, 600);
		Menu menu = new Menu(600, 600, 100, 200, backgroundColor, items);
		f.add(menu, BorderLayout.CENTER);
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
