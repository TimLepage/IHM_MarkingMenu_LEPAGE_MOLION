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
		int elementSize = 50 ;
		items.add(new Element("Menu1", elementSize));
		items.add(new Element("Menu2", elementSize));
		items.add(new Element("Menu3", elementSize));
		items.add(new Element("Menu4", elementSize));
		items.add(new Element("Menu5", elementSize));
		items.add(new Element("Menu6", elementSize));
		items.add(new Element("Menu7", elementSize));
		items.add(new Element("Menu6", elementSize));
		items.add(new Element("Menu7", elementSize));
		items.add(new Element("Menu7", elementSize));
		f.setSize(600, 600);
		Menu menu = new Menu(600, 600, 50, 70, items);
		f.add(menu, BorderLayout.CENTER);
	
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
