package circularMenu;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class testApp {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		List<Element> items = new ArrayList<Element>();
		
		items.add(new Element("Menu1", 50));
		items.add(new Element("Menu2", 50));
		items.add(new Element("Menu3", 50));
		items.add(new Element("Menu4", 50));
		items.add(new Element("Menu5", 50));
		items.add(new Element("Menu6", 50));
		items.add(new Element("Menu7", 50));
	//	items.add(new Element("Menu7", 50));

		f.setSize(600, 600);
		Menu menu = new Menu(300, 300, 600, 600, 50, 70, items);
		f.add(menu, BorderLayout.CENTER);
	
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
